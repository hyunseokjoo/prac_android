package com.example.edittextbuttonkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edittextbuttonkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetText.setOnClickListener {
            var resultText = binding.etId.text.toString()
            binding.textView.setText(resultText)
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}