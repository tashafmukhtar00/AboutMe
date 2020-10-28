package com.tashi.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var doneButton: Button
    private  lateinit var userNickEditText: EditText
    private lateinit var userNicknameTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        settingUpOnClickListener();




    }

    private fun settingUpOnClickListener() {
        doneButton.setOnClickListener {
            val userNick : String = userNickEditText.text.toString()
            userNicknameTextView.text = userNick
            userNicknameTextView.visibility = View.VISIBLE
            userNickEditText.visibility = View.INVISIBLE
            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(doneButton.windowToken, 0)
            doneButton.visibility = View.INVISIBLE
        }
    }

    private fun initViews() {
        doneButton = findViewById(R.id.buttonDone)
        userNickEditText = findViewById(R.id.editTextTextPersonName)
        userNicknameTextView =  findViewById(R.id.textViewNick)
    }
}