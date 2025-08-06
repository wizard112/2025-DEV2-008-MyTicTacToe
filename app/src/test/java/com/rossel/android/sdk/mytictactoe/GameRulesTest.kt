package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.entity.Game
import org.junit.Assert
import org.junit.Test

class GameRulesTest {

    private val game: Game = Game()

    @Test
    fun `should player X when the game starts`() {
        game.turnTo()
        Assert.assertEquals("X", game.giveMeCurrentPlayer())
    }

    @Test (expected = GameException::class)
    fun `should an Exception when the player games a positioned position`() {
        game.play(position = 1)
        game.play(position = 1)
        Assert.assertTrue(game.giveMePositions().contains(element = 1))
    }

    @Test
    fun `should players alternate when the board is not filled`() {
        game.turnTo()
        val turnOne = game.giveMeCurrentPlayer()
        game.turnTo()
        val turnTwo = game.giveMeCurrentPlayer()
        Assert.assertEquals("X", turnOne)
        Assert.assertEquals("O", turnTwo)
    }
}