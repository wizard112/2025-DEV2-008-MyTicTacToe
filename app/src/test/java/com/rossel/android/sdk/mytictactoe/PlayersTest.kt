package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.entity.Players
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer
import org.junit.Assert
import org.junit.Test

class PlayersTest {

    private val players: IPlayer = Players()

    @Test
    fun `should have the player X and player O when start the game`() {
        Assert.assertEquals(Player.X, players.playerX())
        Assert.assertEquals(Player.O, players.playerO())
    }

    @Test
    fun `should player 0 plays when player X just played`() {
        players.turnTo()
        Assert.assertEquals(Player.O, players.playerO())
    }

    @Test
    fun `should player X plays when player 0 just played`() {
        players.turnTo()
        val firstTurn = players.currentPlayer()
        players.turnTo()
        val secondTurn = players.currentPlayer()
        Assert.assertEquals(Player.X, firstTurn)
        Assert.assertEquals(Player.O, secondTurn)
    }
}