package com.sribnyak.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val counterValueText: TextView = findViewById(R.id.counterValueText)
        counterValueText.text = "0"

        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun afterTextChanged(p0: Editable?) { }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                counterValueText.text = countWords(p0.toString()).toString()
            }
        })
    }

    private fun isWord(s: String): Boolean {
        for (c in s)
            if (c.isLetter() || c in '0'..'9')
                return true
        return false
    }

    private fun countWords(text: String): Int {
        val items = text.split(' ', '\n', '\t', '\u00A0')
        var cnt = 0
        for (item in items)
            if (isWord(item))
                ++cnt
        return cnt
    }
}
