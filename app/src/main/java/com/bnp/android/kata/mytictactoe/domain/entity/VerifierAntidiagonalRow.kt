package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierAntidiagonalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean =
        false//(board[2] == player && board[4] == player && board[6] == player)
}