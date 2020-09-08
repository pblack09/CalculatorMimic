package com.example.aug28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("abc", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("abc", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("abc", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("abc", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("abc", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abc", "onDestroy")
    }

}