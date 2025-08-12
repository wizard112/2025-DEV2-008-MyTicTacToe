package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.domain.usecase.PlayersUseCase
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IPlayer
import org.junit.Assert
import org.junit.Test

class PlayersTest {

    private val players: IPlayer = PlayersUseCase()

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

    @Test
    fun `should player X when restart the game`() {
        players.reset()
        Assert.assertEquals(Player.EMPTY, players.currentPlayer())
    }
}