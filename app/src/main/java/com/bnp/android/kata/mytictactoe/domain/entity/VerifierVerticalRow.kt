package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierVerticalRow: IVerifierRow {
    override fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean {
        var found = false
        var column = 0
        while (column < board.size && !found) {
            val list = mutableListOf<Player>()
            for (i in 0..<board.size) {
                board[i]?.let { players -> list.add(element = players[column]) }
            }
            found = list.filter { it == player }.size == board.size
            column++
        }
        return found
    }
}