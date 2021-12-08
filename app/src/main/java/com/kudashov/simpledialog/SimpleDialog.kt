package com.kudashov.simpledialog

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.DialogFragment

class SimpleDialog : DialogFragment(R.layout.dialog_base) {

    companion object {
        const val MESSAGE_ID = "message"

        fun newInstance(bundle: Bundle): SimpleDialog {
            val dialog = SimpleDialog()
            dialog.arguments = bundle
            return dialog
        }
    }

    private var btnClose: Button? = null
    private var tvMessage: TextView? = null

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog?.apply {
            window?.setBackgroundDrawableResource(R.drawable.shape_dialog)
            window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
            window?.setBackgroundDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.color.transparent
                )
            )

            btnClose = dialog?.findViewById(R.id.btn_close)
            tvMessage = dialog?.findViewById(R.id.tv_title)

            tvMessage?.text = arguments?.getString(MESSAGE_ID)
            btnClose?.setOnClickListener { dialog?.dismiss() }
        }
    }
}