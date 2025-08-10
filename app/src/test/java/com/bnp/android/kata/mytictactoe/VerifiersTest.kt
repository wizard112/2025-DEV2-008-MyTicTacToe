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

    @Test
    fun `should has 1 2 3 when try to get first row of the map`() {
        val state = verifierHorizontalRow.verifierRow(board = boardOnlyRow.get(0)?.toList()!!, player = Player.X)
        Assert.assertEquals(StateEnum.FINISHED, state)
    }
}