package com.bnp.android.kata.mytictactoe.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bnp.android.kata.mytictactoe.domain.constants.REF_BOARD
import com.bnp.android.kata.mytictactoe.domain.constants.REF_BUTTON
import com.bnp.android.kata.mytictactoe.domain.constants.REF_LOADING
import com.bnp.android.kata.mytictactoe.domain.constants.REF_PLAYERS
import com.bnp.android.kata.mytictactoe.domain.constants.REF_STATE
import com.bnp.android.kata.mytictactoe.domain.enums.Player

@Composable
fun GameScreen(viewModel: GameViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ConstraintLayout(
        constraintSet = gameScreenConstraintSet(),
        modifier = Modifier.fillMaxSize()) {
        when {
            uiState.loading -> {
                CircularProgressIndicator(
                    color = Color.Green,
                    modifier = Modifier.layoutId(layoutId = REF_LOADING))
            }
            uiState.matchNul -> {
                StateText(txt = "MATCH NUL ${Player.X.name.uppercase()} ${Player.O.name.uppercase()}", modifier = Modifier.layoutId(layoutId = REF_STATE))
                StateText(txt = "Rejouer", modifier = Modifier.layoutId(layoutId = REF_BUTTON).clickable(enabled = true, onClick = { viewModel.handleIntents(intent = GameIntents.Restarting)}))
            }
            uiState.winner -> {
                StateText(txt = "Winner is ${uiState.playerName.uppercase()} !", modifier = Modifier.layoutId(layoutId = REF_STATE))
                StateText(txt = "Rejouer", modifier = Modifier.layoutId(layoutId = REF_BUTTON).clickable(enabled = true, onClick = { viewModel.handleIntents(intent = GameIntents.Restarting)}))
            }
            uiState.board.isNotEmpty() -> {
                StateText(txt = "${uiState.playerName} is your turn", color = if (uiState.playerName.contains(Player.X.name)) Color.Blue else Color.Red, modifier = Modifier.layoutId(layoutId = REF_PLAYERS))
                LazyVerticalGrid(columns = GridCells.Fixed(count = 3),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .layoutId(layoutId = REF_BOARD)) {
                    items(
                        count = uiState.board.size,
                        key = { it }) { position ->
                        val item = uiState.board[position]
                        Cell(player = item) { viewModel.handleIntents(intent = GameIntents.Moving(position = position)) }
                    }
                }
            }
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
        bottom.linkTo(anchor = boardRef.top, margin = 20.dp)
        centerHorizontallyTo(other = parent)
    }
    constrain(ref = stateRef){
        bottom.linkTo(anchor = boardRef.top, margin = 10.dp)
        centerHorizontallyTo(other = parent)
    }
    constrain(ref = loadingRef){
        centerTo(other = parent)
    }
    constrain(restartRef){
        top.linkTo(anchor = boardRef.bottom, margin = 10.dp)
        centerHorizontallyTo(other = parent)
    }
}

@Composable
private fun StateText(txt: String, color: Color = Color.DarkGray, modifier: Modifier = Modifier) {
    Text(text = txt,
        color = color,
        modifier = modifier)
}

@Composable
private fun Cell(player: Player, onClickCell:() -> Unit) {
    Column(modifier = Modifier
        .size(size = 50.dp)
        .background(color = Color.LightGray, shape = RoundedCornerShape(size = 10.dp))
        .clickable(
            enabled = true,
            onClick = { onClickCell() }
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = if (player == Player.EMPTY) "" else player.name.uppercase(),
            modifier = Modifier,
            color = if (player == Player.X) Color.Blue else Color.Red,
            fontSize = 30.sp
        )
    }
}