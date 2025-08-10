package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.domain.usecase.VerifierGameUseCase
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.enums.StateEnum
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VerifierGameTest {
    private val verifier = VerifierGameUseCase()
    val board: HashMap<Int, MutableList<Player>> = hashMapOf()

    @Before
    fun setup() {
        for (i in 0..2) {
            board.put(i, MutableList(size = 3, init = { Player.EMPTY}))
        }
    }

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        board[0]?.let { c -> c[0] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        board[0]?.let { c -> c[1] = Player.X }
        board[2]?.let { c -> c[1] = Player.O }
        board[0]?.let { c -> c[0] = Player.O }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of second horizontal`() {
        board[1]?.let { c -> c[0] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        board[1]?.let { c -> c[1] = Player.X }
        board[2]?.let { c -> c[1] = Player.O }
        board[1]?.let { c -> c[2] = Player.X }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of third horizontal`() {
        board[2]?.let { c -> c[0] = Player.X }
        board[0]?.let { c -> c[2] = Player.O }
        board[2]?.let { c -> c[1] = Player.X }
        board[1]?.let { c -> c[1] = Player.O }
        board[2]?.let { c -> c[2] = Player.X }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of first vertical`() {
        board[0]?.let { c -> c[0] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        board[1]?.let { c -> c[0] = Player.X }
        board[2]?.let { c -> c[1] = Player.O }
        board[2]?.let { c -> c[0] = Player.X }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of second vertical`() {
        board[0]?.let { c -> c[1] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        board[1]?.let { c -> c[1] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        board[0]?.let { c -> c[2] = Player.X }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of third vertical`() {
        board[0]?.let { c -> c[2] = Player.X }
        board[0]?.let { c -> c[1] = Player.O }
        board[1]?.let { c -> c[2] = Player.X }
        board[1]?.let { c -> c[0] = Player.O }
        board[2]?.let { c -> c[2] = Player.X }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in diagonal`() {
        board[1]?.let { c -> c[0] = Player.X }
        board[0]?.let { c -> c[2] = Player.O }
        board[1]?.let { c -> c[0] = Player.X }
        board[1]?.let { c -> c[1] = Player.O }
        board[2]?.let { c -> c[0] = Player.X }
        board[1]?.let { c -> c[0] = Player.O }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in antidiagonal`() {
        board[0]?.let { c -> c[2] = Player.X }
        board[0]?.let { c -> c[0] = Player.O }
        board[0]?.let { c -> c[1] = Player.X }
        board[1]?.let { c -> c[1] = Player.O }
        board[2]?.let { c -> c[0] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should match nul when nine squares are filled`() {
        board[0]?.let { c -> c[0] = Player.X }
        board[0]?.let { c -> c[2] = Player.O }
        board[0]?.let { c -> c[1] = Player.X }
        board[1]?.let { c -> c[0] = Player.O }
        board[1]?.let { c -> c[1] = Player.X }
        board[2]?.let { c -> c[1] = Player.O }
        board[1]?.let { c -> c[2] = Player.X }
        board[2]?.let { c -> c[2] = Player.O }
        board[2]?.let { c -> c[0] = Player.X }
        Assert.assertEquals(StateEnum.MATCH_NUL, verifier.verify(board = board))
    }

    @Test
    fun `should not finished when all the nine squares are not filled`() {
        board[0]?.let { c -> c[0] = Player.X }
        board[0]?.let { c -> c[2] = Player.O }
        Assert.assertEquals(StateEnum.NOT_FINISHED, verifier.verify(board = board))
    }
}