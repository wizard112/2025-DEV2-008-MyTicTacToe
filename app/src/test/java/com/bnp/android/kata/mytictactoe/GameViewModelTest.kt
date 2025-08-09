package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.presentation.GameIntents
import com.bnp.android.kata.mytictactoe.presentation.GameViewModel
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    private val gameViewModel = GameViewModel()

    @Test
    fun `should state is Loading when the view model is instantiated`() {
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState.loading)
    }

    @Test
    fun `should player x starts when the game is instantiated`() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        val uiState = gameViewModel.uiState.value
        Assert.assertEquals(Player.X.name, uiState.playerName)
    }

    @Test
    fun `should positions are filled when the players play`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 0))
        val uiStateOne = gameViewModel.uiState.value
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 2))
        val uiStateTwo = gameViewModel.uiState.value
        Assert.assertEquals(Player.X.name, uiStateOne.playerName)
        Assert.assertEquals(Player.O.name, uiStateTwo.playerName)
    }

    @Test(expected = GameException::class)
    fun `should catch GameException when the player tries to taken a position already filled`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 1))
    }

    @Test
    fun `should game is over when the player X wins`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 4))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 8))
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState.winner)
        Assert.assertEquals(Player.X.name, uiState.playerName)
    }

    @Test
    fun `should game is over when the player O wins`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 1))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 4))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 5))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 7))
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState.winner)
        Assert.assertEquals(Player.O.name, uiState.playerName)
    }

    @Test
    fun `should the game is draw when all nine squares are filled but without three x or O consecutive in horizontal - vertical - diagonal or antidiagonal`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 0))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 2))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 6))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 3))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 8))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 4))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 5))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 7))
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 1))
        val uiState = gameViewModel.uiState.value
        Assert.assertTrue(uiState.matchNul)
    }
}