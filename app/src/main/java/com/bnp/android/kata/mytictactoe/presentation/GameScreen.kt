package com.bnp.android.kata.mytictactoe.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bnp.android.kata.mytictactoe.R
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
        modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        when(uiState) {
            is GameUiState.Winner -> {
                StateText(txt = stringResource(R.string.game_winner, (uiState as GameUiState.Winner).winnerName.uppercase()),
                    textStyle = TextStyle(color = Color.LightGray, fontSize = 20.sp),
                    modifier = Modifier.layoutId(layoutId = REF_STATE))
                PlayAgainButton { viewModel.handleIntents(intent = GameIntents.Restarting) }
            }
            is GameUiState.Playing -> {
                StateText(txt = stringResource(R.string.game_turn_to, (uiState as GameUiState.Playing).playerName.uppercase()),
                    color = playerColor(playerName = (uiState as GameUiState.Playing).playerName),
                    modifier = Modifier.layoutId(layoutId = REF_PLAYERS),
                    textStyle = TextStyle(fontSize = 15.sp))
                Grid(board = (uiState as GameUiState.Playing).board, viewModel = viewModel)
            }
            is GameUiState.Loading -> {
                CircularProgressIndicator(
                    color = Color.Green,
                    modifier = Modifier.layoutId(layoutId = REF_LOADING))
            }
            is GameUiState.MatchNull -> {
                StateText(txt = stringResource(R.string.game_match_null, Player.X.name.uppercase(), Player.O.name.uppercase()),
                    modifier = Modifier.layoutId(layoutId = REF_STATE),
                    textStyle = TextStyle(color = Color.DarkGray, fontSize = 20.sp))
                PlayAgainButton { viewModel.handleIntents(intent = GameIntents.Restarting) }
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

private fun playerColor(playerName: String): Color = if (playerName.contains(Player.X.name)) Color.Blue else Color.Red

@Composable
private fun StateText(txt: String, color: Color = Color.DarkGray, textStyle: TextStyle = TextStyle.Default, modifier: Modifier = Modifier) {
    Text(text = txt,
        color = color,
        style = textStyle,
        modifier = modifier)
}

@Composable
private fun PlayAgainButton(onclickButton: () -> Unit) {
    StateText(
        txt = stringResource(R.string.game_play_again),
        textStyle = TextStyle(color = Color.LightGray, fontSize = 16.sp),
        modifier = Modifier
            .layoutId(layoutId = REF_BUTTON)
            .border(width = 3.dp, color = Color.DarkGray, shape = RoundedCornerShape(size = 5.dp))
            .padding(all = 7.dp)
            .clickable(
                enabled = true,
                onClick = { onclickButton() } )
    )
}

@Composable
private fun Grid(board: List<Player>, viewModel: GameViewModel) {
    LazyVerticalGrid(columns = GridCells.Fixed(count = 3),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp)
            .layoutId(layoutId = REF_BOARD)) {
        items(
            count = board.size,
            key = { it }) { position ->
            val item = board[position]
            Cell(player = item,
                onClickCell = { viewModel.handleIntents(intent = GameIntents.Moving(position = position)) },
                modifier = Modifier.testTag(tag = "cell_$position"))
        }
    }
}

@Composable
private fun Cell(player: Player, onClickCell:() -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier
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