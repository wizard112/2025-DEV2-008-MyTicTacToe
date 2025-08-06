package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.entity.Players
import org.junit.Assert
import org.junit.Test

class PlayersTest {

    private val players: Players = Players()

    @Test
    fun `should have the player X and player O when start the game`() {
        Assert.assertEquals("X", players.playerX)
    }
}