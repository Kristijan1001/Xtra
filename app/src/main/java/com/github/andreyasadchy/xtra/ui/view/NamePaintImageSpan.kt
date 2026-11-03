package com.github.andreyasadchy.xtra.ui.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.style.ReplacementSpan
import com.github.andreyasadchy.xtra.model.chat.NamePaint
import kotlin.math.ceil

class NamePaintImageSpan(
    private val name: String,
    private val shadows: List<NamePaint.Shadow>?,
    var backgroundColor: Int?,
    private val bottomBackgroundColor: Int,
    val drawable: Drawable,
) : ReplacementSpan() {

    // Only the drawable's frame changes during animation. The text cutout and shadows stay fixed.
    private var maskBitmap: Bitmap? = null
    private val maskCanvas = Canvas()
    private val maskPaint = Paint()
    private val sourcePaint = Paint()
    private val sourceMode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    private var hasSourcePaint = false
    private var maskBaseline = Float.NaN
    private var maskBackgroundColor: Int? = null
    private var maskShadows: List<NamePaint.Shadow>? = null

    override fun getSize(paint: Paint, text: CharSequence?, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        if (fm != null) {
            val paintFm = paint.fontMetrics
            fm.ascent = paintFm.ascent.toInt()
            fm.bottom = paintFm.bottom.toInt()
            fm.descent = paintFm.descent.toInt()
            fm.leading = paintFm.leading.toInt()
            fm.top = paintFm.top.toInt()
        }
        return paint.measureText(name).toInt()
    }

    override fun draw(canvas: Canvas, text: CharSequence?, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint) {
        val xOffset = x.toInt()
        val width = paint.measureText(name).toInt()
        val height = bottom - top
        val drawableWidth = drawable.intrinsicWidth
        val drawableHeight = drawable.intrinsicHeight
        if (width <= 0 || height <= 0 || drawableWidth <= 0 || drawableHeight <= 0) return
        val widthRatio = drawableWidth.toFloat() / drawableHeight.toFloat()
        val fullWidth: Int
        val fullHeight: Int
        if (height > drawableHeight) {
            val addedWidth = ceil((height - drawableHeight) * widthRatio).toInt()
            val newWidth = drawableWidth + addedWidth
            if (width > newWidth) {
                val addedHeight = ceil((width - newWidth) / widthRatio).toInt()
                fullWidth = xOffset + width
                fullHeight = bottom + addedHeight
            } else {
                fullWidth = xOffset + newWidth
                fullHeight = bottom
            }
        } else {
            if (width > drawableWidth) {
                val addedHeight = ceil((width - drawableWidth) / widthRatio).toInt()
                fullWidth = xOffset + width
                fullHeight = top + drawableHeight + addedHeight
            } else {
                fullWidth = xOffset + drawableWidth
                fullHeight = top + drawableHeight
            }
        }
        drawable.setBounds(xOffset, top, fullWidth, fullHeight)
        drawable.draw(canvas)
        val maskWidth = fullWidth - xOffset
        val maskHeight = fullHeight - top
        val baseline = y.toFloat() - top
        var bitmap = maskBitmap
        val sameDimensions = bitmap != null && bitmap.width == maskWidth && bitmap.height == maskHeight
        if (!sameDimensions || maskBaseline != baseline || maskBackgroundColor != backgroundColor || maskShadows != shadows || !sameMaskPaint(paint)) {
            if (!sameDimensions) {
                bitmap = Bitmap.createBitmap(maskWidth, maskHeight, Bitmap.Config.ARGB_8888)
                maskBitmap = bitmap
                maskCanvas.setBitmap(bitmap)
            } else {
                bitmap!!.eraseColor(Color.TRANSPARENT)
            }
            drawMask(paint, baseline)
            sourcePaint.set(paint)
            hasSourcePaint = true
            maskBaseline = baseline
            maskBackgroundColor = backgroundColor
            maskShadows = shadows?.toList()
        }
        canvas.drawBitmap(bitmap!!, xOffset.toFloat(), top.toFloat(), paint)
    }

    private fun sameMaskPaint(paint: Paint): Boolean {
        // These effects can change internally without replacing their object, so don't cache them.
        // Public shadow inspection starts at API 29. Older devices still reuse the
        // bitmap and drawing objects, but redraw the mask to preserve shadow changes.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return false
        if (!hasSourcePaint || hasMutableEffects(paint) || hasMutableEffects(sourcePaint)) return false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && paint.fontVariationSettings != sourcePaint.fontVariationSettings) return false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && paint.blendMode != sourcePaint.blendMode) return false
        return paint.flags == sourcePaint.flags && paint.color == sourcePaint.color &&
                paint.textSize == sourcePaint.textSize && paint.textScaleX == sourcePaint.textScaleX &&
                paint.textSkewX == sourcePaint.textSkewX && paint.letterSpacing == sourcePaint.letterSpacing &&
                paint.typeface == sourcePaint.typeface && paint.textAlign == sourcePaint.textAlign &&
                paint.textLocales == sourcePaint.textLocales && paint.fontFeatureSettings == sourcePaint.fontFeatureSettings &&
                paint.hinting == sourcePaint.hinting && paint.isElegantTextHeight == sourcePaint.isElegantTextHeight
    }

    private fun hasMutableEffects(paint: Paint): Boolean = paint.shader != null || paint.colorFilter != null ||
            paint.maskFilter != null || paint.pathEffect != null || paint.xfermode != null ||
            (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && paint.shadowLayerRadius != 0f)

    private fun drawMask(paint: Paint, baseline: Float) {
        maskPaint.set(paint)
        maskPaint.style = Paint.Style.FILL
        maskPaint.color = bottomBackgroundColor
        maskCanvas.drawPaint(maskPaint)
        backgroundColor?.let {
            maskPaint.color = it
            maskCanvas.drawPaint(maskPaint)
        }
        maskPaint.color = paint.color
        shadows?.forEach {
            maskPaint.setShadowLayer(it.radius, it.xOffset, it.yOffset, it.color)
            maskCanvas.drawText(name, 0f, baseline, maskPaint)
        }
        maskPaint.clearShadowLayer()
        maskPaint.xfermode = sourceMode
        maskPaint.alpha = 0
        maskCanvas.drawText(name, 0f, baseline, maskPaint)
    }
}
