package com.github.andreyasadchy.xtra.util.chat

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.SystemClock
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.github.andreyasadchy.xtra.R

/** Owns the requests and animated drawables for one binding of a chat row. */
internal class ChatImageSession private constructor(
    private val view: View,
    private var lifecycle: Lifecycle,
) : DefaultLifecycleObserver, Drawable.Callback {
    private var disposed = false
    private var attached = view.isAttachedToWindow
    private var visible = view.isShown
    private val requests = mutableListOf<() -> Unit>()
    private val drawables = mutableSetOf<Drawable>()
    private val scheduled = mutableMapOf<Runnable, Runnable>()

    val isCurrent: Boolean
        get() = !disposed && view.getTag(R.id.chat_image_session) === this

    private val canAnimate: Boolean
        get() = isCurrent && attached && visible && lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)

    fun addRequest(cancel: () -> Unit) {
        if (isCurrent) requests.add(cancel) else cancel()
    }

    fun animate(drawable: Drawable) {
        if (!isCurrent) return
        drawables.add(drawable)
        drawable.callback = this
        (drawable as? Animatable)?.let { if (canAnimate && !it.isRunning) it.start() }
    }

    fun updateVisibility() {
        if (canAnimate) {
            drawables.forEach { (it as? Animatable)?.let { animation -> if (!animation.isRunning) animation.start() } }
        } else {
            drawables.forEach { (it as? Animatable)?.let { animation -> if (animation.isRunning) animation.stop() } }
            scheduled.values.forEach { view.removeCallbacks(it) }
            scheduled.clear()
        }
    }

    private fun onAttachmentChanged(isAttached: Boolean) {
        attached = isAttached
        visible = view.isShown
        if (isAttached) {
            // Dialog rows are created by the main chat adapter but belong to the dialog's view.
            view.findViewTreeLifecycleOwner()?.lifecycle?.let { ownerLifecycle ->
                if (ownerLifecycle !== lifecycle) {
                    lifecycle.removeObserver(this)
                    lifecycle = ownerLifecycle
                    lifecycle.addObserver(this)
                }
            }
        }
        updateVisibility()
    }

    private fun onVisibilityChanged(isVisible: Boolean) {
        visible = isVisible
        updateVisibility()
    }

    fun clear() {
        if (disposed) return
        disposed = true
        updateVisibility()
        drawables.forEach { it.callback = null }
        drawables.clear()
        requests.forEach { it() }
        requests.clear()
        lifecycle.removeObserver(this)
        if (view.getTag(R.id.chat_image_session) === this) view.setTag(R.id.chat_image_session, null)
    }

    override fun onStart(owner: LifecycleOwner) = updateVisibility()
    override fun onStop(owner: LifecycleOwner) = updateVisibility()
    override fun onDestroy(owner: LifecycleOwner) = clear()

    override fun invalidateDrawable(who: Drawable) {
        if (canAnimate) view.postInvalidateOnAnimation() else updateVisibility()
    }

    override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
        if (canAnimate) {
            scheduled.remove(what)?.let { view.removeCallbacks(it) }
            val callback = Runnable {
                scheduled.remove(what)
                if (canAnimate) what.run()
            }
            scheduled[what] = callback
            // Drawable.Callback supplies an absolute uptime, while View.postDelayed expects a delay.
            view.postDelayed(callback, (`when` - SystemClock.uptimeMillis()).coerceAtLeast(0))
        }
    }

    override fun unscheduleDrawable(who: Drawable, what: Runnable) {
        scheduled.remove(what)?.let { view.removeCallbacks(it) }
    }

    companion object {
        fun begin(view: View, lifecycle: Lifecycle): ChatImageSession {
            clear(view)
            return ChatImageSession(view, view.findViewTreeLifecycleOwner()?.lifecycle ?: lifecycle).also {
                view.setTag(R.id.chat_image_session, it)
                it.lifecycle.addObserver(it)
            }
        }

        fun onAttachmentChanged(view: View, isAttached: Boolean) = (view.getTag(R.id.chat_image_session) as? ChatImageSession)?.onAttachmentChanged(isAttached)

        fun onVisibilityChanged(view: View, isVisible: Boolean) = (view.getTag(R.id.chat_image_session) as? ChatImageSession)?.onVisibilityChanged(isVisible)

        fun clear(view: View) = (view.getTag(R.id.chat_image_session) as? ChatImageSession)?.clear()
    }
}
