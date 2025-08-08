package com.bnp.android.kata.mytictactoe.presentation

sealed class GameIntents {
    object Starting: GameIntents()
    data class Moving(val position: Int): GameIntents()
}