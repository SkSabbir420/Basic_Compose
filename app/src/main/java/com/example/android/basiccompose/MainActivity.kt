package com.example.android.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
//    IncrementScreen()
    SendMassageScreen()
}

@Composable
fun IncrementScreen(modifier: Modifier = Modifier){
    var count by rememberSaveable{ mutableStateOf(0) }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$$count")
        Button(
            onClick = {
                ++count
            }
        ) {
            Text(text = "Increment 1")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendMassageScreen(modifier: Modifier = Modifier){
    var massage by rememberSaveable{ mutableStateOf("") }
    var tempMassage by rememberSaveable{ mutableStateOf("") }
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$massage")
            TextField(
                value = tempMassage,
                label = { Text(text = "Enter your massage")},
                onValueChange = {tempMassage = it}
            )
            Button(
                onClick = {
                    massage = tempMassage
                    tempMassage = ""
                }
            ) {
                Text(text = "Send")
            }

        }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BasicComposeTheme {
        MainScreen()
    }
}