package com.rossel.android.sdk.mytictactoe.presentation

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum

sealed class GameUiState {
    object Loading: GameUiState()
    class Playing(val board: List<Player>, val playerName: String, val stateEnum: StateEnum): GameUiState()
}