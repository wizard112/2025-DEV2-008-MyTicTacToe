package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.presentation.GameViewModel
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    private val gameViewModel = GameViewModel()

    @Test
    fun `should state is started when the view model is instantiated`() {
        Assert.assertEquals("Started", gameViewModel.state)
    }

    @Test
    fun `should state is not finished when move in a position`() {
        gameViewModel.manageGame(position = 1)
        Assert.assertEquals("not finished", gameViewModel.state)
    }
}