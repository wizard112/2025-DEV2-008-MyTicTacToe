package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierRow

class VerifierAntidiagonalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean =
        (board[2] == player && board[4] == player && board[6] == player)
}