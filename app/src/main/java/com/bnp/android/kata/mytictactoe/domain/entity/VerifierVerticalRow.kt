package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierVerticalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean =
        board.filter { it == player }.size == 3
}