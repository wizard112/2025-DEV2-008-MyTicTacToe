package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.usecase.VerifierGameUseCase
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VerifierGameTest {
    private val verifier = VerifierGameUseCase()
    private val board = mutableListOf<Player>()

    @Before
    fun setup() {
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
        board.add(Player.EMPTY)
    }

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        board[0] = Player.X
        board[3] = Player.O
        board[1] = Player.X
        board[6] = Player.O
        board[2] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of second horizontal`() {
        board[3] = Player.X
        board[0] = Player.O
        board[4] = Player.X
        board[1] = Player.O
        board[5] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of third horizontal`() {
        board[6] = Player.X
        board[0] = Player.O
        board[7] = Player.X
        board[1] = Player.O
        board[8] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of first vertical`() {
        board[0] = Player.X
        board[1] = Player.O
        board[3] = Player.X
        board[2] = Player.O
        board[6] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of second vertical`() {
        board[1] = Player.X
        board[0] = Player.O
        board[4] = Player.X
        board[2] = Player.O
        board[7] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in row of third vertical`() {
        board[1] = Player.X
        board[0] = Player.O
        board[4] = Player.X
        board[2] = Player.O
        board[7] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in diagonal`() {
        board[0] = Player.X
        board[1] = Player.O
        board[4] = Player.X
        board[2] = Player.O
        board[8] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should finished when player has three in antidiagonal`() {
        board[2] = Player.X
        board[1] = Player.O
        board[4] = Player.X
        board[3] = Player.O
        board[6] = Player.X
        Assert.assertEquals(StateEnum.FINISHED, verifier.verify(board = board))
    }

    @Test
    fun `should match nul when nine squares are filled`() {
        board[0] = Player.X
        board[2] = Player.O
        board[6] = Player.X
        board[3] = Player.O
        board[8] = Player.X
        board[4] = Player.O
        board[5] = Player.X
        board[7] = Player.O
        board[1] = Player.X
        Assert.assertEquals(StateEnum.MATCH_NUL, verifier.verify(board = board))
    }

    @Test
    fun `should not finished when all the nine squares are not filled`() {
        board[0] = Player.X
        board[2] = Player.O
        Assert.assertEquals(StateEnum.NOT_FINISHED, verifier.verify(board = board))
    }
}