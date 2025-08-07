package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.entity.GameState
import org.junit.Assert
import org.junit.Test

class StateTest {
    private val state = GameState()

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        Assert.assertEquals("finished", state.current())
    }
}