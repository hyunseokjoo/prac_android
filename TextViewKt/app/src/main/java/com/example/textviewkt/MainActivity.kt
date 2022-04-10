package com.example.textviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.textviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //ActivityMainBinding 타입에 해당하는 mBinding 변수를 선언하고 ?를 표시하여 null 허용하게 함
    //onDestroy에서 없애 주어야 하기 때문
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTest1.setText("Hello world")
    }
}