package com.example.kmmfirstapp.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmmfirstapp.Greeting
import android.widget.TextView
import com.example.kmmfirstapp.GithubApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        mainScope.launch {
            kotlin.runCatching {
                GithubApi().fetchRepos()
            }.onSuccess {
                tv.text = it.joinToString { it.toString() }
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }
    }
}
