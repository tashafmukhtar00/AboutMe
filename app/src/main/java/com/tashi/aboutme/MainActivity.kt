package com.tashi.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tashi.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding
    private val myName: MyName = MyName("Tashaf Mukhtar")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityBinding.myName = myName
        settingUpOnClickListener();


    }

    private fun settingUpOnClickListener() {
        mainActivityBinding.buttonDone.setOnClickListener {

            mainActivityBinding.apply {
                myName.nickName = mainActivityBinding.editTextTextPersonName.text.toString()
                invalidateAll()
                mainActivityBinding.textViewNick.text = myName.nickName

                mainActivityBinding.textViewNick.visibility = View.VISIBLE
                mainActivityBinding.editTextTextPersonName.visibility = View.INVISIBLE
                // Hide the keyboard.
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(mainActivityBinding.buttonDone.windowToken, 0)
                mainActivityBinding.buttonDone.visibility = View.INVISIBLE

            }
        }
    }


}