package com.bnp.android.kata.mytictactoe.presentation

import com.bnp.android.kata.mytictactoe.domain.enums.Player

sealed class GameUiState {
    object Loading: GameUiState()
    data class Playing(val board: List<Player>, val playerName: String): GameUiState()
    data class Winner(val winnerName: String): GameUiState()
}