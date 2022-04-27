package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    // 1. ViewModel LiveData 객체 정의
    private MutableLiveData<Integer> num;

    // 2. 생성자에 객체 값 생성
    public MainActivityViewModel() {
        num = new MutableLiveData<>();
        num.setValue(0);
    }

    // 3. 객체 getter 메소드 구현
    public MutableLiveData<Integer> getNum() {
        if(num == null){
            num = new MutableLiveData<>();
            return num;
        }
        return num;
    }

    // 4. 화면에서 호출해줄 로직 구현
    public void plus() {
        num.setValue(num.getValue() + 1);
    }

    public void minus(){
        num.setValue(num.getValue() - 1);
    }
}
