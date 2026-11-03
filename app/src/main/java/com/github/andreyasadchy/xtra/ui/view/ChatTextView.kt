package com.github.andreyasadchy.xtra.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.github.andreyasadchy.xtra.util.chat.ChatImageSession

/** Pauses emote decoding whenever a chat row or one of its parents is hidden. */
class ChatTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.textViewStyle,
) : AppCompatTextView(context, attrs, defStyleAttr) {
    override fun onVisibilityAggregated(isVisible: Boolean) {
        super.onVisibilityAggregated(isVisible)
        ChatImageSession.onVisibilityChanged(this, isVisible)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ChatImageSession.onAttachmentChanged(this, true)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        ChatImageSession.onAttachmentChanged(this, false)
    }
}
