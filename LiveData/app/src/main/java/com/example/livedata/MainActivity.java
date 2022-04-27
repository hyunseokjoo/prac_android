package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 화면 구성 전역 변수 선언
    Button btnAdd;
    Button btnMinus;
    TextView tvNum;

    // ViewModel 전역 변수 선언
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewModel();
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        tvNum = findViewById(R.id.tv_num);

        //버튼 클릭 시 ViewModel에 있는 컨트롤러 실행
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.plus();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.minus();
            }
        });
    }

    //ViewModel에서 사용할 onChanged메소드 구현
    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvNum.setText(integer.toString());
            }
        });
    }
}