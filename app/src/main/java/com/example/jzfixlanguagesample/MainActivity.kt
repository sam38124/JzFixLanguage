package com.example.jzfixlanguagesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.jzfixlanguage.FixLanguage
import com.example.jzfixlanguage.callback
import com.example.jzfixlanguage.fixLanguage
import com.example.jzfixlanguage.jzString
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FixLanguage.newInstance.setUP(this,"https://bento2.orange-electronic.com/Orange%20Cloud/fixLanguage.txt",object :callback{
            override fun result(a: Boolean) {
                Log.e("加載結果","$a")
            }
        })
        findViewById<View>(android.R.id.content).rootView.fixLanguage()
        Log.e("replace",resources.jzString(R.string.repl))
    }
}
