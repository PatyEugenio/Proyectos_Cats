package com.example.cats.presentation.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CatFactButton(codeForOnClick:()->Unit){
    //Unit espera pero no va a mandar nada, y se lo carga a onclick
    Button(onClick = codeForOnClick) {
        Text(text="Get a Cat Fact")

    }
}