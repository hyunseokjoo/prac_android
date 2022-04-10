package com.example.textviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.textviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //ActivityMainBinding 타입에 해당하는 mBinding 변수를 선언하고 ?를 표시하여 null 허용하게 함
    //onDestroy에서 없애 주어야 하기 때문
    //타입뒤에 '?'를 붙이면 Nullsafety가 발생하여 Null이 허용이 된다
    private var mBinding: ActivityMainBinding? = null
    //!!은 해당 변수나 값이 Null이면 에러가 나고, Null이 아니면 데이터가 출력된다. !!로 표시하면 절대 Null이면 안된다.
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate는 부풀리다라는 말
        //xml에 작성되어있는 화면단을 inflate함수로 실체화 시켜준다는 말이다.
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //tv_test1으로 표기해도 java에서 카멜표기법으로변겨해준다.
        binding.tvTest1.setText("Hello world")
    }
}