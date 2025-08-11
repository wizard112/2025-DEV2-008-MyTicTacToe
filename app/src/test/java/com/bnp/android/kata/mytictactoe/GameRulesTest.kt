package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.usecase.GameUseCase
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase
import org.junit.Assert
import org.junit.Test

class GameRulesTest {
    private val game: IGameUseCase = GameUseCase(columns = 3, rows = 3)

    @Test
    fun `should player X when the game starts`() {
        game.play(column = 0, row = 1, player = Player.X)
        val position = game.board()[0]?.get(1)
        val result = game.board().values.filter { list ->
            list.filter { player -> player == Player.X }.size == 1
        }.size
        Assert.assertEquals(Player.X, position)
        Assert.assertEquals(1, result)
    }

    @Test(expected = GameException::class)
    fun `should nothing when the player O tries to play at the same position that player X`() {
        game.play(column = 0, row = 1, player = Player.X)
        game.play(column = 0, row = 1, player = Player.O)
        val position = game.board()[0]?.get(1)
        Assert.assertEquals(Player.X, position)
    }

    @Test
    fun `should players alternate when the board is not filled`() {
        game.play(column = 0, row = 1, player = Player.X)
        game.play(column = 0, row = 2, player = Player.O)
        val positionPlayerX = game.board()[0]?.get(1)
        val positionPlayerO = game.board()[0]?.get(2)
        Assert.assertEquals(Player.X, positionPlayerX)
        Assert.assertEquals(Player.O, positionPlayerO)
    }

    @Test
    fun `should position 1 is filled in the board when player X take the position 1`() {
        game.play(column = 0, row = 1, player = Player.X)
        val position = game.board()[0]?.get(1)
        Assert.assertEquals(Player.X, position)
    }

    @Test
    fun `should position 8 is filled in the board when player O take the position 8`() {
        game.play(column = 0, row = 1, player = Player.X)
        game.play(column = 2, row = 2, player = Player.O)
        val positionPlayerO = game.board()[2]?.get(2)
        Assert.assertEquals(Player.O, positionPlayerO)
    }
}