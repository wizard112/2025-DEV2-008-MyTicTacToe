package com.rossel.android.sdk.mytictactoe

import org.junit.Assert
import org.junit.Test

class PlayersTest {

    @Test
    fun `should have the player X and player O when start the game`() {
        Assert.assertEquals("X", players.playerX)
    }
}