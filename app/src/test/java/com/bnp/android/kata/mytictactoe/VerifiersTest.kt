package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.domain.entity.VerifierAntidiagonalRow
import com.bnp.android.kata.mytictactoe.domain.entity.VerifierDiagonalRow
import com.bnp.android.kata.mytictactoe.domain.entity.VerifierHorizontalRow
import com.bnp.android.kata.mytictactoe.domain.entity.VerifierVerticalRow
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow
import org.junit.Assert
import org.junit.Test

class VerifiersTest {
    private val boardOnlyRow: HashMap<Int, MutableList<Player>> = hashMapOf()
    private val verifierHorizontalRow: IVerifierRow = VerifierHorizontalRow()
    private val verifierVerticalRow: IVerifierRow = VerifierVerticalRow()
    private val verifierDiagonalRow: IVerifierRow = VerifierDiagonalRow()
    private val verifierAntidiagonalRow: IVerifierRow = VerifierAntidiagonalRow()

    @Test
    fun `should be true when there is three aat second row`() {
        boardOnlyRow.put(0, mutableListOf(Player.EMPTY, Player.EMPTY, Player.EMPTY))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.X, Player.X))
        boardOnlyRow.put(2, mutableListOf(Player.EMPTY, Player.EMPTY, Player.EMPTY))
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(true, state)
    }

    @Test
    fun `should be false when there is not three at horizontal`() {
        boardOnlyRow.put(0, mutableListOf(Player.EMPTY, Player.EMPTY, Player.EMPTY))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.O, Player.EMPTY))
        boardOnlyRow.put(2, mutableListOf(Player.EMPTY, Player.EMPTY, Player.EMPTY))
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(false, state)
    }

    @Test
    fun `should be false when there is not three and last row is not completed`() {
        boardOnlyRow.put(0, mutableListOf(Player.EMPTY, Player.EMPTY, Player.EMPTY))
        boardOnlyRow.put(1, mutableListOf(Player.EMPTY, Player.EMPTY, Player.EMPTY))
        boardOnlyRow.put(2, mutableListOf(Player.O))
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(false, state)
    }

    @Test
    fun `should be true when there is three at the last column`() {
        boardOnlyRow.put(0, mutableListOf(Player.EMPTY, Player.EMPTY, Player.O))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.X, Player.O))
        boardOnlyRow.put(2, mutableListOf(Player.EMPTY, Player.EMPTY, Player.O))
        val state = verifierVerticalRow.verifierRow(board = boardOnlyRow, player = Player.O)
        Assert.assertEquals(true, state)
    }

    @Test
    fun `should be false when there is not three at vertical `() {
        boardOnlyRow.put(0, mutableListOf(Player.EMPTY, Player.EMPTY, Player.X))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.X, Player.O))
        boardOnlyRow.put(2, mutableListOf(Player.O, Player.EMPTY, Player.O))
        val state = verifierVerticalRow.verifierRow(board = boardOnlyRow, player = Player.O)
        Assert.assertEquals(false, state)
    }

    @Test
    fun `should be true when there is three in diagonal row`() {
        boardOnlyRow.put(0, mutableListOf(Player.EMPTY, Player.EMPTY, Player.X))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.X, Player.O))
        boardOnlyRow.put(2, mutableListOf(Player.X, Player.EMPTY, Player.O))
        val state = verifierDiagonalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(true, state)
    }

    @Test
    fun `should be true when there is three in anti diagonal row`() {
        boardOnlyRow.put(0, mutableListOf(Player.O, Player.EMPTY, Player.EMPTY))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.O, Player.O))
        boardOnlyRow.put(2, mutableListOf(Player.X, Player.EMPTY, Player.O))
        val state = verifierAntidiagonalRow.verifierRow(board = boardOnlyRow, player = Player.O)
        Assert.assertEquals(true, state)
    }
}