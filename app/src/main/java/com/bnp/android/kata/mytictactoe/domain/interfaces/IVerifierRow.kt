package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IVerifierRow {
    fun verifierRow(board: Map<Int, MutableList<Player>>, player: Player): Boolean
}