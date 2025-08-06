package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.entity.Game
import org.junit.Assert
import org.junit.Test

class GameRulesTest {

    private val game: Game = Game()

    @Test
    fun `should player X when the game starts`() {
        game.play(position = 1)
        Assert.assertEquals("X", game.giveMeCurrentPlayer())
        Assert.assertNotEquals("O", game.giveMeCurrentPlayer())
    }

    @Test (expected = Exception::class)
    fun `should an Exception when the player games a positioned position`() {
        game.play(position = 1)
        game.play(position = 1)
    }
}