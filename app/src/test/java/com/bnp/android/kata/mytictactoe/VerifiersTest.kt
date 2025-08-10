package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.domain.entity.VerifierHorizontalRow
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow
import org.junit.Assert
import org.junit.Test

class VerifiersTest {
    private val boardOnlyRow: HashMap<Int, MutableList<Player>> = hashMapOf()
    private val verifierHorizontalRow: IVerifierRow = VerifierHorizontalRow()


    @Test
    fun `should be true when try to get first row of the map`() {
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.X, Player.X))
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(true, state)
    }

    @Test
    fun `should be false when try to get first row of the map`() {
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.O, Player.EMPTY))
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(false, state)
    }
}