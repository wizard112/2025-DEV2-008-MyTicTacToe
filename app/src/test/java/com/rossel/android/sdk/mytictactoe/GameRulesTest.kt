package com.rossel.android.sdk.mytictactoe

import org.junit.Assert
import org.junit.Test

class GameRulesTest {

    @Test
    fun `should player X when the game starts`() {
        Assert.assertTrue(currentPlayer())
    }
}