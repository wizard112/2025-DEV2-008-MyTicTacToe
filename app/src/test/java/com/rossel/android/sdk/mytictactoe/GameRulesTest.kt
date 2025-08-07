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
        Assert.assertTrue(game.board.contains(element = Player.X))
    }

    @Test
    fun `should players alternate when the board is not filled`() {
        game.play(position = 1)
        val turnOne = game.players.currentPlayer()
        game.play(position = 2)
        val turnTwo = game.players.currentPlayer()
        Assert.assertEquals(Player.X, turnOne)
        Assert.assertEquals(Player.O, turnTwo)
    }

    @Test
    fun `should position 1 is filled in the board when player X take the position 1`() {
        game.play(position = 1)
        Assert.assertEquals(Player.X, game.board[1])
    }

    @Test
    fun `should position 8 is filled in the board when player O take the position 8`() {
        game.play(position = 1)
        game.play(position = 8)
        Assert.assertEquals(Player.O, game.board[8])
    }

    @Test
    fun `should match nul when nine squares are filled`() {
        Assert.assertEquals("match nul", game.state())
    }

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        game.play(position = 0)
        game.play(position = 3)
        game.play(position = 1)
        game.play(position = 6)
        game.play(position = 2)
        Assert.assertEquals("finished", game.state())
    }

    @Test
    fun `should finished when player has three in row of second horizontal`() {
        game.play(position = 3)
        game.play(position = 0)
        game.play(position = 4)
        game.play(position = 1)
        game.play(position = 5)
        Assert.assertEquals("finished", game.state())
    }

    @Test
    fun `should finished when player has three in row of third horizontal`() {
        game.play(position = 6)
        game.play(position = 0)
        game.play(position = 7)
        game.play(position = 1)
        game.play(position = 8)
        Assert.assertEquals("finished", game.state())
    }

    @Test
    fun `should finished when player has three in row of first vertical`() {
        game.play(position = 0)
        game.play(position = 1)
        game.play(position = 3)
        game.play(position = 2)
        game.play(position = 6)
        Assert.assertEquals("finished", game.state())
    }
}