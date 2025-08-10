package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierHorizontalRow: IVerifierRow {
    override fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean {
        var found = false
        var i = 0
        while (i < board.size && !found) {
            found = board[i]?.filter { it == player }?.size == board.size
            i++
        }
        return found
    }
}