package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierAntidiagonalRow: IVerifierRow {
    override fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean {
        return board.values.mapIndexed { i,p -> p[i] == player }.filter { it }.size == board.size
    }
}