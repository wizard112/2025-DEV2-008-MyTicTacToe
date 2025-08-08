package com.rossel.android.sdk.mytictactoe.presentation

import com.rossel.android.sdk.mytictactoe.domain.enums.Player

sealed class GameUiState {
    object Loading: GameUiState()
    data class Playing(val board: List<Player>, val playerName: String): GameUiState()
    data class Winner(val playerName: String): GameUiState()
    object MatchNul: GameUiState()
}