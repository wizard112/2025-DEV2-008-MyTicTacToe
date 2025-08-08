package com.rossel.android.sdk.mytictactoe.domain.interfaces

import com.rossel.android.sdk.mytictactoe.domain.enums.Player

interface IVerifierRow {
    fun verifierRow(board: List<Player>, player: Player): Boolean
}