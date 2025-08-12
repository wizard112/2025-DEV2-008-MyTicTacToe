package com.bnp.android.kata.mytictactoe.presentation

sealed class GameIntents {
    object Starting: GameIntents()
    object Restarting: GameIntents()
    data class Moving(val column: Int, val row: Int): GameIntents()
}