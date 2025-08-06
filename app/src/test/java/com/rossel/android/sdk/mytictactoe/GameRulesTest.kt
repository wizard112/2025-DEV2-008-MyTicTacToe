package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.entity.Game
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import org.junit.Assert
import org.junit.Test

class GameRulesTest {

    private val game: Game = Game()

    @Test
    fun `should player X when the game starts`() {
        game.players.turnTo()
        Assert.assertEquals(Player.X, game.players.currentPlayer())
    }

    @Test (expected = GameException::class)
    fun `should an Exception when the player games a positioned position`() {
        game.play(position = 1)
        game.play(position = 1)
        Assert.assertTrue(game.giveMePositions().contains(element = 1))
    }

    @Test
    fun `should players alternate when the board is not filled`() {
        game.players.turnTo()
        val turnOne = game.players.currentPlayer()
        game.players.turnTo()
        val turnTwo = game.players.currentPlayer()
        Assert.assertEquals(Player.X, turnOne)
        Assert.assertEquals(Player.O, turnTwo)
    }
}