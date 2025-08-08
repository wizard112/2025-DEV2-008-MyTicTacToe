package com.bnp.android.kata.mytictactoe.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun GameScreen(viewModel: GameViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ConstraintLayout(
        constraintSet = ConstraintSet {
            val playersRef = createRefFor(id = "players")
            val boardRef = createRefFor(id = "board")
            val stateRef = createRefFor(id = "state")
            val loadingRef = createRefFor(id = "loading")
            val restartRef = createRefFor(id = "button")

            constrain(ref = boardRef){
                centerTo(other = parent)
            }
            constrain(ref = playersRef){
                bottom.linkTo(anchor = boardRef.top, margin = 10.dp)
                centerHorizontallyTo(other = parent)
            }
            constrain(ref = stateRef){
                bottom.linkTo(anchor = boardRef.top, margin = 10.dp)
                centerHorizontallyTo(other = parent)
            }
            constrain(ref = loadingRef){
                bottom.linkTo(anchor = boardRef.top, margin = 10.dp)
                centerHorizontallyTo(other = parent)
            }
            constrain(restartRef){
                top.linkTo(anchor = boardRef.bottom, margin = 10.dp)
                centerHorizontallyTo(other = parent)
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        when(uiState) {
            is GameUiState.Loading -> {
                CircularProgressIndicator(color = Color.Green, modifier = Modifier.layoutId(layoutId = "loading"))
            }
            is GameUiState.MatchNul -> {}
            is GameUiState.Winner -> {}
            is GameUiState.Playing -> {}
        }
    }
}