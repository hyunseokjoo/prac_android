# MVVM패턴이란?

![123](https://user-images.githubusercontent.com/49854618/162969429-13259761-a684-4789-acc9-0943a6f0d31e.png)

- View
    - 사용자의 내용을 입력 받고, UI관련 내용을 처리하는 곳
    - 즉, UI에 관련 된이벤트나 데이터 변경 건에 대한 내용을 ViewModel에 알려줌 ViewModel에 상태가 변경되면 바로 UI에 반영이 됨
- ViewModel
    - View와 Model의 중간다리 역할을 함
    - ViewModel은 LiveData의 등록시켜 View(Activity, Fragment)의 Lifecycle을 따르게 하여 View가 사라지면 ViewModel도 없어지도록 설정 할 수 있음
    - View의 내용과 Model의 내용을 같이 가지고 있음
- Model
    - ViewModel에서 데이터를 가져갈 수 있게 준비하며 실질 적인 데이터베이스에 접근처리 하는 역할을 함
    - 데이터베이스에 접근 처리 한 내용은 ViewModel에 알려주어 바로 UI에 반영될 수 있도록 해줌

# AAC(Android Architecture Component)란?

<img width="450" alt="123 (1)" src="https://user-images.githubusercontent.com/49854618/162969453-1acc14cb-7d7f-4ce1-b428-2ea7a9350f24.png">

- 구글에서 제공하는 안드로이드 아키텍쳐(디자인 패턴)임 이것이 MVVM으로 되어있음
    - android가 google에서 제공하는 공식 앱 프레임워크로 등록 되었고 jetbrain에서 만든 kotlin이 google공식 언어가 되었음, 그래서 AAC(MVVM)에 대해 알아야 함
- Android Libraries - Architecture Components (라이브러리 집합)
    - Android에서 사용하라고 제공해주는 Library 집합 - Jetpack이라고도 함 (공홈에 있음)
- Architecture Components란?
    - 아키텍쳐에 대한 가이드를 Lifecycle관리 및 Data Persistence와 같은 일반적인 작업을 위한 라이브러리와 함께 제공하는 것 Architecture Component는 Jetpack에 속해있다.
    - Architecture Component 구성 요소
    - LifeCycle을 Handling 할 수 있는 방법
    - Live Data
    - ViewModel
    - Room Persistence Library(Persistence 지속성)

# LiveData

- Jetpack에 속해 있는 라이브러리로 ViewModel을 구현 할 수 있게 해줌
- ViewModel을 LiveData에 등록하여 사용 등록 할때 해당 Activity나 Fragment를 Owner로 설정함
- 등록된 Owner인 Activity, Fragment의 LifeCycle을 따르고 있어서 Owner가 사라지면 해당 LiveData도 사라지게 되어 메모리 누수가 없게 해줌
- 항상 캡슐화 해서 사용해야함(private)

# Repository

- 직접적으로 데이터 가지고 있는 클래스
- 데이터를 가져오기 위해 API처리를 해주는 기능이 들어가게됨

# Room

- Sqlite를 편하게 사용하게 도와 주는 라이브러리
- Sqlite는 데이터베이스 이기 때문에 데이터를 저장하거나 삭제하는 것이 가능하여 데이터 처리가 가능해짐
- 보통 큰 데이터를 조회하거나 처리하는 경우 백단이 개발되어 API로 처리하게 되고 간단하게 앱에서 처리 가능 한것은 Room을 이용하여 처리하게 됨

# MVVM 패턴 사용법 알아보기 ViewModel + LiveData

- ViewModel이란 그냥 하나의 패턴명이나 파일명에 불과함 (ex: Activity화면명ViewModel.kt라는 파일이)
- 여기에서 LiveData라는 라이브러리를 붙이게 되면 MVVM패턴에 VM부분을 담당 할 수 있음
- LiveData에 ViewModel을 등록해주면 해당 Activity와 Fragment의 Lifecycle대로 유지되었다가 사라지게 만들어 줌
- LiveData는 ViewModel에 데이터가 변경 될 때마다 Onchanged 메소드를 계속 호출을 해줌
