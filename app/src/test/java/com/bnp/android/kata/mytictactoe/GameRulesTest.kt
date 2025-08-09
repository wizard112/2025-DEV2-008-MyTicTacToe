package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.usecase.VerifierGameUseCase
import com.bnp.android.kata.mytictactoe.domain.usecase.GameUseCase
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierUseCase
import org.junit.Assert
import org.junit.Test

class GameRulesTest {

    private val game: IGameUseCase = GameUseCase(columns = 3, rows = 3)
    private val verifier: IVerifierUseCase = VerifierGameUseCase()

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
    /*
    @Test
    fun `should match nul when nine squares are filled`() {
        game.play(position = 0)
        game.play(position = 2)
        game.play(position = 6)
        game.play(position = 3)
        game.play(position = 8)
        game.play(position = 4)
        game.play(position = 5)
        game.play(position = 7)
        game.play(position = 1)
        Assert.assertEquals(StateEnum.MATCH_NUL, verifier.verify(board = game.state().board()))
    }

    /*@Test
    fun `should finished when player has three in row of first horizontal`() {
        game.play(position = 0)
        game.play(position = 3)
        game.play(position = 1)
        game.play(position = 6)
        game.play(position = 2)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in row of second horizontal`() {
        game.play(position = 3)
        game.play(position = 0)
        game.play(position = 4)
        game.play(position = 1)
        game.play(position = 5)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in row of third horizontal`() {
        game.play(position = 6)
        game.play(position = 0)
        game.play(position = 7)
        game.play(position = 1)
        game.play(position = 8)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in row of first vertical`() {
        game.play(position = 0)
        game.play(position = 1)
        game.play(position = 3)
        game.play(position = 2)
        game.play(position = 6)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in row of second vertical`() {
        game.play(position = 1)
        game.play(position = 0)
        game.play(position = 4)
        game.play(position = 2)
        game.play(position = 7)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in row of third vertical`() {
        game.play(position = 1)
        game.play(position = 0)
        game.play(position = 4)
        game.play(position = 2)
        game.play(position = 7)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in diagonal`() {
        game.play(position = 0)
        game.play(position = 1)
        game.play(position = 4)
        game.play(position = 2)
        game.play(position = 8)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }

    @Test
    fun `should finished when player has three in antidiagonal`() {
        game.play(position = 2)
        game.play(position = 1)
        game.play(position = 4)
        game.play(position = 3)
        game.play(position = 6)
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = game.state().board()))
    }
     */