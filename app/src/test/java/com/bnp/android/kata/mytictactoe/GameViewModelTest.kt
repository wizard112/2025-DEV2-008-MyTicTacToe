package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.presentation.GameIntents
import com.bnp.android.kata.mytictactoe.presentation.GameUiState
import com.bnp.android.kata.mytictactoe.presentation.GameViewModel
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    private val gameViewModel = GameViewModel()

    @Test
    fun `should state is Loading when the view model is instantiated`() {
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState is GameUiState.Loading)
    }

    @Test
    fun `should player x starts when the game is instantiated`() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        val uiState = gameViewModel.uiState.value
        Assert.assertEquals(Player.X.name, (uiState as GameUiState.Playing).playerName)
    }

    @Test
    fun `should positions are filled when the players play`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 0))
        val uiStateOne = gameViewModel.uiState.value
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 2))
        val uiStateTwo = gameViewModel.uiState.value
        Assert.assertEquals(Player.X.name, (uiStateOne as GameUiState.Playing).playerName)
        Assert.assertEquals(Player.O.name, (uiStateTwo as GameUiState.Playing).playerName)
    }

    @Test
    fun `should can do nothing when the player O tries to taken a position already filled by player X`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 1))
        val uiState = gameViewModel.uiState.value
        Assert.assertEquals(Player.X, (uiState as GameUiState.Playing).board[0]!![1])
    }

    @Test
    fun `should game is over when the player X wins`() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 2, row = 2))
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState is GameUiState.Winner)
        Assert.assertEquals(Player.X.name, (uiState as GameUiState.Winner).winnerName)
    }

    @Test
    fun `should game is over when the player O wins`() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 2, row = 1))
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState is GameUiState.Winner)
        Assert.assertEquals(Player.O.name, (uiState as GameUiState.Winner).winnerName)
    }

    @Test
    fun `should the game is draw when all nine squares are filled but without three x or O consecutive in horizontal - vertical - diagonal or antidiagonal`() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 2, row = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 2, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 2, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 1))
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState is GameUiState.MatchNull)
    }

    @Test
    fun `should restart game when a player wins and click on button`() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 0, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 1, row = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(column = 2, row = 1))
        val uiState = gameViewModel.uiState.value
        gameViewModel.handleIntents(intent = GameIntents.Restarting)
        val uiStateTwo = gameViewModel.uiState.value
        Assert.assertTrue(uiState is GameUiState.Winner)
        Assert.assertEquals(Player.O.name, (uiState as GameUiState.Winner).winnerName)
        Assert.assertTrue(uiStateTwo is GameUiState.Playing)
        Assert.assertEquals(Player.X.name, (uiStateTwo as GameUiState.Playing).playerName)
    }
}