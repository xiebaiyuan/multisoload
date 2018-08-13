package com.example.xiebaiyuan.jnitest2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method

        val assetPath = "testso"
        val dataPath = (filesDir.toString()
                + File.separator + assetPath)
        Utils.copyFilesFromAssets(this, assetPath, dataPath)
        System.load(dataPath+File.separator+"test1.so");
//
       System.loadLibrary("native-lib")
//
        sample_text.text = stringFromJNI()

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
//            /storage/sdcard0/libtest1so.so
            val externalStorageDirectory = Environment.getExternalStorageDirectory().path + File.separator +"testso/test1.so"
//            Log.e("hah","externalStorageDirectory:$externalStorageDirectory")
//            externalStorageDirectory + "libtest1so.so"
//            val soPath = (Environment.getExternalStorageDirectory().toString()
//                    + File.separator + "test1so.so")

        }
    }


}
