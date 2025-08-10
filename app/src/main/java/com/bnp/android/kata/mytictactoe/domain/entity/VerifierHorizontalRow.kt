package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierHorizontalRow: IVerifierRow {
    override fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean {
        val rowOne = board[0]
        val rowTwo = board[1]
        val rowThree = board[0]
        return rowOne?.filter { it == player }?.size == 3
                || rowTwo?.filter { it == player }?.size == 3
                || rowThree?.filter { it == player }?.size == 3
    }
}