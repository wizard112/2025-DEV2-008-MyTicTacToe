package com.rossel.android.sdk.mytictactoe.presentation

import com.rossel.android.sdk.mytictactoe.domain.enums.Player

sealed class GameUiState {
    class Playing(val board: List<Player>): GameUiState()
}