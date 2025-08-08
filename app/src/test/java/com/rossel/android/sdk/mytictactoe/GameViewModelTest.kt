package com.rossel.android.sdk.mytictactoe

import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    @Test
    fun `should state started when the view model is instantiated`() {
        Assert.assertEquals("Started", viewModel.state)
    }
}