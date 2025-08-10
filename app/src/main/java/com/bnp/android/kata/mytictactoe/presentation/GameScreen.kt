package com.bnp.android.kata.mytictactoe.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
        modifier = Modifier.fillMaxSize()) {
        when {
            uiState.loading -> {
                CircularProgressIndicator(
                    color = Color.Green,
                    modifier = Modifier.layoutId(layoutId = REF_LOADING))
            }
            uiState.matchNul -> {
                StateText(txt = stringResource(R.string.game_match_null, Player.X.name.uppercase(), Player.O.name.uppercase()), modifier = Modifier.layoutId(layoutId = REF_STATE))
                StateText(txt = stringResource(R.string.game_play_again), modifier = Modifier.layoutId(layoutId = REF_BUTTON).clickable(enabled = true, onClick = { viewModel.handleIntents(intent = GameIntents.Restarting)}))
            }
            uiState.winner -> {
                StateText(txt = stringResource(R.string.game_winner, uiState.playerName.uppercase()),
                    textStyle = TextStyle(color = Color.LightGray, fontSize = 16.sp),
                    modifier = Modifier.layoutId(layoutId = REF_STATE))
                PlayAgainButton { viewModel.handleIntents(intent = GameIntents.Restarting) }
            }
            uiState.board.isNotEmpty() -> {
                StateText(txt = stringResource(R.string.game_turn_to, uiState.playerName.uppercase()), color = if (uiState.playerName.contains(Player.X.name)) Color.Blue else Color.Red, modifier = Modifier.layoutId(layoutId = REF_PLAYERS))
                Column(modifier = Modifier.layoutId(layoutId = REF_BOARD)) {
                    uiState.board.keys.forEach { column ->
                        Row {
                            uiState.board[column]?.let { row ->
                                row.forEach { player ->
                                    Box(modifier = Modifier
                                        .padding(all = 5.dp)
                                        .background(color = Color.DarkGray, shape = RoundedCornerShape(size = 4.dp))
                                        .clickable(enabled = true, onClick = {})) {
                                        Text(text = if(player == Player.EMPTY) " " else player.name.uppercase(),
                                            modifier = Modifier.height(height = 50.dp).width(width = 40.dp))
                                    }
                                }
                            }
                        }
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
                onClick = { onclickButton } )
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
            Cell(player = item) { viewModel.handleIntents(intent = GameIntents.Moving(position = position)) }
        }
    }
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