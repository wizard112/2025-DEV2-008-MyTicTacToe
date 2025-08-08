package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.presentation.GameViewModel
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    private val gameViewModel = GameViewModel()

    @Test
    fun `should state started when the view model is instantiated`() {
        Assert.assertEquals("Started", gameViewModel.state)
    }
}