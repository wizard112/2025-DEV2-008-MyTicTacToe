package com.bnp.android.kata.mytictactoe

import com.bnp.android.kata.mytictactoe.domain.entity.VerifierHorizontalRow
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.enums.StateEnum
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VerifiersTest {
    private val boardOnlyRow: HashMap<Int, MutableList<Player>> = hashMapOf()
    private val verifierHorizontalRow: IVerifierRow = VerifierHorizontalRow()

    @Before
    fun setup() {
        boardOnlyRow.put(0, mutableListOf(Player.X, Player.X, Player.X))
        boardOnlyRow.put(1, mutableListOf(Player.X, Player.O, Player.EMPTY))
        boardOnlyRow.put(2, mutableListOf(Player.X, Player.X, Player.X))
    }

    @Test
    fun `should has 1 2 3 when try to get first row of the map`() {
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow, player = Player.X)
        Assert.assertEquals(true, state)
    }
}