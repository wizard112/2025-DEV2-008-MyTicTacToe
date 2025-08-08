package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IVerifierRow {
    fun verifierRow(board: List<Player>, player: Player): Boolean
}