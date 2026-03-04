package com.example.app12_DropdownMenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app12_DropdownMenu.ui.theme.MyApp_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp_Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyExample(modifier = Modifier.padding( innerPadding))
                }
            }
        }
    }
}


@Composable
fun MyExample(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxSize().verticalScroll( rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.padding(10.dp))

        MyDropdownMenu1()

        Spacer(modifier = Modifier.padding(10.dp))
        Text("--------")
    }
}

@Composable
fun MyDropdownMenu1() {
    Text("DropdownMenu bàsic")
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val hobbies = listOf("Play music", "Practice sport", "Programming", "Reading", "Other")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            hobbies.forEach { hobby ->
                DropdownMenuItem(text = { Text(text = hobby) }, onClick = {
                    expanded = false
                    selectedText = hobby
                })
            }
        }

    }

    Text("DropdownMenu bàsic")

}
