package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierDiagonalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean =
        false //(board[0] == player && board[4] == player && board[8] == player)
}