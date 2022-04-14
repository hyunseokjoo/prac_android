package com.example.permissionkt

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var permissionLauncher : ActivityResultLauncher<Array<String>>

    private var isAccessCoarseLocationPermissionGranted = false
    private var isReadPermissionGranted = false
    private var isWritePermissionGranted = false
    private var isLocationPermissionGranted = false
    private var isRecordAudioPermissionGranted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions ->
            isAccessCoarseLocationPermissionGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: isAccessCoarseLocationPermissionGranted
            isReadPermissionGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: isReadPermissionGranted
            isWritePermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: isWritePermissionGranted
            isLocationPermissionGranted = permissions[Manifest.permission.WRITE_EXTERNAL_STORAGE] ?: isLocationPermissionGranted
            isRecordAudioPermissionGranted = permissions[Manifest.permission.RECORD_AUDIO] ?: isRecordAudioPermissionGranted

            //자리에 맞게 재요청 할 내용 Toast표시 및 requestPermission다시 보내기 등 하면 되는 자리
        }

        selfCheckPermission()
        requestPermission()
    }


    //권한 없는것 요청
    private fun requestPermission() {
        val permissionRequest : MutableList<String> = ArrayList()
        if(!isAccessCoarseLocationPermissionGranted){ permissionRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION) }
        if(!isLocationPermissionGranted)            { permissionRequest.add(Manifest.permission.ACCESS_FINE_LOCATION) }
        if(!isReadPermissionGranted)                { permissionRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE) }
        if(!isWritePermissionGranted)               { permissionRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE) }
        if(!isRecordAudioPermissionGranted)         { permissionRequest.add(Manifest.permission.RECORD_AUDIO) }

        //없는 권한 ArrayList로 만들어 Launch로 MultiPermission열기
        if(permissionRequest.isNotEmpty()){permissionLauncher.launch(permissionRequest.toTypedArray())}
    }

    //권한 등록되어있는지 체크
    private fun selfCheckPermission() {
        //위치 기반 권한 체크
        isAccessCoarseLocationPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        isLocationPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        //저장소 일기 권한 체크
        isReadPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

        //저장소 쓰기 권한 체크
        val isWritePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
        val minSdkLevel = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q //쓰기 권한은 28이후에 나왔으므로
        isWritePermissionGranted = isWritePermission || minSdkLevel

        //오디오
        isRecordAudioPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }
}