package com.rossel.android.sdk.mytictactoe.presentation

sealed class GameIntents {
    object Starting: GameIntents()
    data class Moving(val position: Int): GameIntents()
}