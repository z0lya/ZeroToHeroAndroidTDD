package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var viewGroup: ViewGroup
    private lateinit var button: Button
    private var isButtonClicked: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)
        viewGroup = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            isButtonClicked = true
            viewGroup.removeView(textView)
            button.setEnabled(false)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isClicked", isButtonClicked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean("isClicked")) {
            viewGroup.removeView(textView)
            button.setEnabled(false)
        }
    }
}