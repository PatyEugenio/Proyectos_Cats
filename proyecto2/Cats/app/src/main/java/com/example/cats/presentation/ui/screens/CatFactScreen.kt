package com.example.cats.presentation.ui.screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cats.domain.model.CatFactStates
import com.example.cats.presentation.ui.composables.CatFactCard
import com.example.cats.presentation.ui.composables.CatFactText
import kotlinx.coroutines.flow.*


@Composable
fun CatFactScreen(
    catFact: Flow<CatFactStates>,
    onClick: () -> Unit
) {
    val catFact: CatFactStates
            by catFact.collectAsStateWithLifecycle(initialValue= CatFactStates.Loading)

    when (catFact) {
        is CatFactStates.Loading -> CatFactCard(
            text = "Click to Get a Cat Fact!",
            onClick = onClick)
        is CatFactStates.CatFactData -> CatFactCard(
            text = (catFact as CatFactStates.CatFactData).fact.text,
            onClick = onClick)
        else -> CatFactText(text = "Nothing to show")
    }
}
