package com.kudashov.simpledialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            SimpleDialog
                .newInstance(
                    bundleOf(
                        SimpleDialog.MESSAGE_ID to "Привет"
                    )
                )
                .show(supportFragmentManager, "BaseFragment")
        }
    }
}