package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierRow

class VerifierDiagonalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean =
        (board[0] == player && board[4] == player && board[8] == player)
}