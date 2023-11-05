package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


val TAG: String? = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //根据项目名字生成
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//                    for (i in 0..10){
//                        More("Compose课程第${i+1}课,快来学习吧～")
//                    }
//                }
                    //LazyColumn
//                    LazyColumn(content = {
//                        //1.写法一
////                    item {
////                        for (i in 1..20){
////                            More("Compose课程第${i+1}课,快来学习吧～")
////                        }
////                    }
//                        //将item包装成一个list
//                        items(items = getData()) { data ->
//                            More(title = data)
//                        }
//                    })
                    //LazyRow
                    LazyRow(content = {
                        items(items = getData()) { data ->
                            More(title = data)
                        }
                    })
                }
            }
        }
    }

    fun getData(): List<String> {
        return List(20) { "Compose课程第${it + 1}课,快来学习吧～" }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Row() {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Text(
                text = "First Compose Demo",
                modifier = Modifier
                    //先后顺序也会影响效果
                    .background(Color.Red)
                    .padding(10.dp)
                    .clickable {
                        Log.i(TAG, "Greeting: click")
                    },
                color = Color.White
            )
        }
    }

    @Composable
    fun More(title: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Red)
        ) {
            Text(
                text = title,
                fontSize = 16.sp, color = Color.White, modifier = Modifier.weight(1f)
            )
            Button(onClick = {
                Log.i(TAG, "More: ")
            }) {
                Text(text = "查看详情", color = Color.White)
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
//        Greeting("Android")
            More("Hello Compose")
        }
    }
}