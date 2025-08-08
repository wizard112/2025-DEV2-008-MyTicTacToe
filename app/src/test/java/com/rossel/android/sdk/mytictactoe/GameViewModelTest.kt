package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import com.rossel.android.sdk.mytictactoe.presentation.GameViewModel
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    private val gameViewModel = GameViewModel()

    @Test
    fun `should state is started when the view model is instantiated`() {
        gameViewModel.manageGame(position = 1)
        Assert.assertEquals(StateEnum.NOT_FINISHED.name, gameViewModel.state)
    }
}