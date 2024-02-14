package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

    @Composable
    fun App(){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // add your column here (with align modifier)
                Column(modifier = Modifier.align(Alignment.Center)) {
                    PersonCard(painterResource(id = R.drawable.android),"Dimitris Klokidis","cs student")
                }
            }
            Box(modifier = Modifier.fillMaxSize()) {
                // add your column here (with align modifier)
                Column(modifier = Modifier.align(Alignment.BottomEnd)) {
                    InfoCard(icon = painterResource(R.drawable.mail_24px),"mail","Dimitrisklokidis@gmail.com")
                }
            }
        }
    }

@Composable
fun PersonCard(image: Painter = painterResource(id = R.drawable.android), name: String, title: String) {
    Column(
        Modifier
            .fillMaxWidth(1f)
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = image, contentDescription = null,Modifier.size(200.dp))
        Text(
            text = name,
            modifier = Modifier.padding(top = 6.dp, bottom = 5.dp),
            fontSize = 35.sp,
            textAlign = TextAlign.Justify,
        )
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
@Composable
fun InfoCard(icon: Painter, description: String, name: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Icon(
            painter = icon,
            contentDescription = description,
            Modifier
                .padding(10.dp)
        )
        Text(
            text = name,
            modifier = Modifier.padding(5.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
      App()
    }
}