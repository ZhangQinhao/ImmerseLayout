# ImmerseLayout
满足普通开发者对于沉浸式界面的开发
ImmerserLinearLayout   →  LinearLayout  
ImmerserFrameLayout  →  FrameLayout  
ImmerseRelativeLayout  →  RelativeLayout  
ImmerseTableLayout → TableLayout  
在需要沉浸的页面合理使用ImmerseLayout替换原本布局。   
  
### 引入  

 - Android Studio  

在build.gradle引入  `implementation 'io.github.zhangqinhao:ImmerseLayout:3.0.2'`

 - eclipse

建议使用As，方便版本更新。实在不行，只有复制粘贴源码了。
### 注意
 - 在从2.0.0版本开始，`setImmersePadding(int left, int top, int right, int bottom);`方法改为`setPadding(int left, int top, int right, int bottom)`
 - 新增刘海屏等异型屏兼容，`app:need_immerse_notchscreen="false"` 表明如果是异型屏，则不沉浸

### 如果仅仅是需要底层布局的background沉浸，则将最外层布局替换为相应的ImmerseLayout布局，其余布局不变。
![enter description here][1]

``` stylus
<com.monke.immerselayout.ImmerseFrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:background="@drawable/bg">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="30dp"
        android:text="背景沉浸"
        android:textSize="24sp"
        android:textColor="#000000"
        android:background="#90ffffff"/

</com.monke.immerselayout.ImmerseFrameLayout>
```

### 如果对背景图片显示比例要求较高，则需要使用双重ImmerseLayout嵌套
一般可以用在底部是需要全屏沉浸的视频或者录像  
![enter description here][2]

``` stylus
<com.monke.immerselayout.ImmerseFrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    app:need_immerse="true">
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent" 
        android:src="@drawable/ivbg"
        android:scaleType="centerCrop"/>
    <com.monke.immerselayout.ImmerseLinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="布局底层ImageView沉浸,同时再次使用了一次沉浸式布局，避免内部内容也沉浸在状态栏"
            android:textSize="24sp"
            android:textColor="#000000"
            android:background="#90ffffff"/>
    </com.monke.immerselayout.ImmerseLinearLayout>
    
</com.monke.immerselayout.ImmerseFrameLayout>
```
#### 如果只是要标题栏等界面沉浸
![enter description here][3]

``` stylus
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.monke.immerselayout.ImmerseLinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:background="@drawable/tabcolor">
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@mipmap/ic_launcher"
            android:layout_gravity="center_horizontal"/>
    </com.monke.immerselayout.ImmerseLinearLayout>
</LinearLayout>
```
### 如果只要自定义颜色沉浸
![enter description here][4]
```stylus
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.monke.immerselayout.ImmerseFrameLayout
        android:id="@+id/abc"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:need_immerse_notchscreen="true"
        android:background="@drawable/tabcolor">
        <!--android:background="#ff00ff"-->
    </com.monke.immerselayout.ImmerseFrameLayout>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="自定义颜色"/>
</LinearLayout>
```
具体用法参照Sample代码

  


  [1]: ./images/1.png "1.png"
  [2]: ./images/2.png "2.png"
  [3]: ./images/3.png "3.png"
  [4]: ./images/4.png "4.png"