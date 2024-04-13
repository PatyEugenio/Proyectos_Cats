package com.example.cats.presentation.ui.composables

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable



@Composable
fun CatFactText(text:String){
    Text(
        text=text,
        style=typography.bodyMedium
    )
}