package com.example.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var mBinding : ActivitySecondBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)

        mBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent에 키에 값이 있는지 확인
        if(intent.hasExtra("msg"))
        {
            //intent에
            binding.tvGetMsg.setText(intent.getStringExtra("msg"))
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}