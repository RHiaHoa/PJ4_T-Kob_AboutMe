package com.android.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener({addNickname(it)})
        findViewById<TextView>(R.id.nickname_text).setOnClickListener({updateName(it)})
    }


    private fun updateName(view: View){
        val editText = findViewById<EditText>(R.id.name_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        val doneButton = findViewById<Button>(R.id.done_button)
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        editText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE
        doneButton.visibility = View.VISIBLE

        editText.requestFocus()
        inputMethodManager.showSoftInput(editText,0)
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.name_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        val doneButton = findViewById<Button>(R.id.done_button)
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        nicknameTextView.text = editText.text

        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        doneButton.visibility = View.GONE
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }
}
