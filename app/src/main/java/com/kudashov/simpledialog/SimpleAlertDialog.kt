package com.kudashov.simpledialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class SimpleAlertDialog : DialogFragment() {

    companion object {
        const val MESSAGE_ID = "message"

        fun newInstance(bundle: Bundle): SimpleAlertDialog {
            val dialog = SimpleAlertDialog()
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext(), theme)
            .setMessage(arguments?.getString(MESSAGE_ID))
            .setPositiveButton("Close") { _, _ ->
                dismiss()
            }
            .create()

    }
}