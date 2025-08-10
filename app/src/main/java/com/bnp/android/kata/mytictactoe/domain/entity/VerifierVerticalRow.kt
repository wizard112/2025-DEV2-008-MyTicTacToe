package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierVerticalRow: IVerifierRow {
    override fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean {
        val columnOne = board[0]?.last()
        val columnTwo = board[1]?.last()
        val columnThree = board[2]?.last()
        return columnOne == player && columnTwo == player && columnThree == player
    }
}