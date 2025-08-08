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
import com.bnp.android.kata.mytictactoe.domain.constants.REF_BOARD
import com.bnp.android.kata.mytictactoe.domain.constants.REF_BUTTON
import com.bnp.android.kata.mytictactoe.domain.constants.REF_LOADING
import com.bnp.android.kata.mytictactoe.domain.constants.REF_PLAYERS
import com.bnp.android.kata.mytictactoe.domain.constants.REF_STATE

@Composable
fun GameScreen(viewModel: GameViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ConstraintLayout(
        constraintSet = gameScreenConstraintSet(),
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

private fun gameScreenConstraintSet(): ConstraintSet = ConstraintSet {
    val playersRef = createRefFor(id = REF_PLAYERS)
    val boardRef = createRefFor(id = REF_BOARD)
    val stateRef = createRefFor(id = REF_STATE)
    val loadingRef = createRefFor(id = REF_LOADING)
    val restartRef = createRefFor(id = REF_BUTTON)

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
}