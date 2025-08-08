package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import com.rossel.android.sdk.mytictactoe.presentation.GameIntents
import com.rossel.android.sdk.mytictactoe.presentation.GameUiState
import com.rossel.android.sdk.mytictactoe.presentation.GameViewModel
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
        Assert.assertTrue(uiState is GameUiState.Playing)
        Assert.assertEquals(Player.X.name, (uiState as GameUiState.Playing).playerName)
    }

    @Test
    fun `should positions are filled when the players play`() {
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 0))
        val uiStateOne = gameViewModel.uiState.value
        gameViewModel.handleIntents(intent = GameIntents.Moving(position = 2))
        val uiStateTwo = gameViewModel.uiState.value
        Assert.assertTrue(uiStateOne is GameUiState.Playing)
        Assert.assertTrue(uiStateTwo is GameUiState.Playing)
        Assert.assertEquals(Player.X.name, (uiStateOne as GameUiState.Playing).playerName)
        Assert.assertEquals(Player.O.name, (uiStateTwo as GameUiState.Playing).playerName)
        Assert.assertEquals(StateEnum.NOT_FINISHED, uiStateOne.state)
    }
}