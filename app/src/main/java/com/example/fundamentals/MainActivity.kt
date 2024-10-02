package com.example.fundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.fundamentals.ui.theme.FundamentalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel= ViewModelProvider(this)[StateTestViewModel::class.java]
        setContent {
            FundamentalsTheme {
                SearchPage(viewModel)
            }
        }
    }
}



@Composable
fun SearchPage(viewModel: StateTestViewModel){

    val name by viewModel.name.observeAsState(initial = "")
    val sirName by viewModel.sirName.observeAsState(initial = "")


    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        SearchArea(name,sirName, onSirNameChange = {viewModel.onSirNameUpdate(it)},
            onNameChange={
                viewModel.onNameUpdate(it)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        DataArea(name, sirName)
    }

}

@Composable
fun SearchArea(sirName: String,name: String,onNameChange: (String)->Unit, onSirNameChange: (String)->Unit){

    OutlinedTextField(
        value = name,
        onValueChange = {onNameChange(it)},
        label = { Text(text = "firstName")}
    )

    OutlinedTextField(
        value = sirName,
        onValueChange = {onSirNameChange(it)},
        label = { Text(text = "Surname")}
    )
}


@Composable
fun DataArea(name: String,sirName: String){

    Text(text = "My name is: $name $sirName",
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold)

}







