package com.aomi.mybase.core.platform

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.view.KeyEvent.ACTION_DOWN
import android.view.KeyEvent.KEYCODE_BACK
import android.view.Window.FEATURE_NO_TITLE
import android.view.WindowManager.LayoutParams.MATCH_PARENT
import android.view.WindowManager.LayoutParams.WRAP_CONTENT
import androidx.annotation.LayoutRes
import com.aomi.mybase.R
import com.aomi.mybase.extension.inflate
import dagger.android.support.DaggerAppCompatDialogFragment

abstract class BaseDialogFragment : DaggerAppCompatDialogFragment() {

    @LayoutRes
    abstract fun getLayoutResource(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(getLayoutResource())
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.let {
            it.requestFeature(FEATURE_NO_TITLE)
            it.setBackgroundDrawableResource(R.color.transparent)
        }
        return dialog
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            MATCH_PARENT,
            WRAP_CONTENT
        )
    }

    protected fun disableDismissOnBackPress() {
        dialog?.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KEYCODE_BACK) {
                if (event.action != ACTION_DOWN) true else true
            } else {
                false
            }
        }
    }

}