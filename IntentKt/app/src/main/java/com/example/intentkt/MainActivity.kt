package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Main Activity xml 연결
    private var mBinding : ActivityMainBinding? = null
    //binding으로 mBinding 가져오는 getter 생성
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        //getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        //인스턴스를 활용하여 생성된 뷰를 액티비티에 표시함.
        setContentView(binding.root)

        binding.btnMoveSecond.setOnClickListener {
            //다음 화면으로 이동하는 intent객체 생성
            val intent = Intent(this, SecondActivity::class.java)

            //putExtra는 (키, 값)을 입력하여 intent에 담겨주면 키로 조회해 값을 가져와 데이터 사용가능
            intent.putExtra("msg",binding.tvSendMsg.text.toString())

            //startActivity는 intent의 설정된 Activity를 실행해주는 함수
            //SecondActivity라는 객체를 가지고 있는 intent를 넘겨 그 Activity를 실행하게 해줌
            startActivity(intent)

            //해당 소스에 액티비티를 죽이고 다른 화면으로 넘어가고 싶을 때는 finish라는 함수를 사용한다
            //이렇게 구현을 하면 home화면으로 갈 것임
            finish()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}