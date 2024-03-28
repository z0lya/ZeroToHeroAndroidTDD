package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2, 4)
    private lateinit var button: Button
    private var isButtonEnabled: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            val uiState = count.increment(textView.text.toString())

            when (uiState) {
                is UiState.Base -> textView.text = uiState.text
                is UiState.Max -> {
                    textView.text = uiState.text
                    button.setEnabled(false)
                    isButtonEnabled = false
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("BUTTON STATE", isButtonEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (!savedInstanceState.getBoolean("BUTTON STATE")) {
            button.setEnabled(false)
        }
    }
}