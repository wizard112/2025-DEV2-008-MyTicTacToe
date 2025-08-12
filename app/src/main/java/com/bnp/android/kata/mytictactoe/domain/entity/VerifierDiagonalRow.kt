package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierDiagonalRow: IVerifierRow {
    override fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean {
        val list = mutableListOf<Player>()
        var found = false
        var i = 0
        var j = board.size - 1
        while (i < board.size && !found) {
            board[i]?.let { players ->
                if (j >= 0 && j < board.size && players[j] == player) list.add(element = players[j])
            }
            found = list.size == board.size
            j--
            i++
        }
        return found
    }
}