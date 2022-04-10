package com.example.imageviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imageviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding?=null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnToast.setOnClickListener {
            //ImageView 이미지를 setImageResource라는 함수를 이용하여 이미지를 변경이 가능하다
            binding.ivProfile.setImageResource(R.drawable.androidlogo)
            //Toast라는 것을 이용하여 알림이 가능하게 해준다
            //첫 번째 인자 : 화면, 두번째 인자 : 메세지, 세 번째 인자 : Toast 노출 길이
            //show라는 함수를 꼭 붙여 주어야한다.
            Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}