package com.github.andreyasadchy.xtra.ui.view

import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.text.style.ReplacementSpan
import com.github.andreyasadchy.xtra.model.chat.NamePaint
import kotlin.math.max
import kotlin.math.min

class NamePaintSpan(
    private val name: String,
    private val type: String,
    private val colors: IntArray,
    private val colorPositions: FloatArray,
    private val angle: Int?,
    private val repeat: Boolean?,
    private val shadows: List<NamePaint.Shadow>?,
) : ReplacementSpan() {

    private val drawPaint = Paint()
    private var gradient: Shader? = null
    private var gradientX = Float.NaN
    private var gradientWidth = Float.NaN
    private var gradientTop = 0
    private var gradientBottom = 0
    private var gradientColors: IntArray? = null
    private var gradientPositions: FloatArray? = null

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
        // TextView may redraw this span for a neighbouring animated emote. Reuse its fixed gradient.
        drawPaint.set(paint)
        val yOffset = y.toFloat()
        shadows?.forEach {
            drawPaint.setShadowLayer(it.radius, it.xOffset, it.yOffset, it.color)
            canvas.drawText(name, x, yOffset, drawPaint)
        }
        drawPaint.clearShadowLayer()
        val width = paint.measureText(name)
        if (width <= 0f || bottom <= top) return
        if (gradient == null || gradientX != x || gradientWidth != width || gradientTop != top || gradientBottom != bottom ||
            gradientColors?.contentEquals(colors) != true || gradientPositions?.contentEquals(colorPositions) != true) {
            gradient = createGradient(x, top, bottom, width)
            gradientX = x
            gradientWidth = width
            gradientTop = top
            gradientBottom = bottom
            gradientColors = colors.copyOf()
            gradientPositions = colorPositions.copyOf()
        }
        gradient?.let { drawPaint.shader = it }
        canvas.drawText(name, x, yOffset, drawPaint)
    }

    private fun createGradient(x: Float, top: Int, bottom: Int, width: Float): Shader? = when (type) {
            "LINEAR_GRADIENT" -> {
                val height = (bottom - top).toFloat()
                val topFloat = top.toFloat()
                val points = floatArrayOf(x, topFloat, x + width, topFloat)
                val matrix = Matrix()
                matrix.setRotate(((angle ?: 0) - 90).toFloat(), x + (width / 2), top + (height / 2))
                matrix.mapPoints(points)
                LinearGradient(
                    points[0],
                    min(points[1], bottom.toFloat()),
                    points[2],
                    max(points[3], topFloat),
                    colors,
                    colorPositions,
                    if (repeat == true) {
                        Shader.TileMode.REPEAT
                    } else {
                        Shader.TileMode.CLAMP
                    }
                )
            }
            "RADIAL_GRADIENT" -> {
                val halfWidth = width / 2
                val height = (bottom - top).toFloat()
                RadialGradient(
                    x + halfWidth,
                    top + (height / 2),
                    halfWidth,
                    colors,
                    colorPositions,
                    if (repeat == true) {
                        Shader.TileMode.REPEAT
                    } else {
                        Shader.TileMode.CLAMP
                    }
                )
            }
            else -> null
        }
}
