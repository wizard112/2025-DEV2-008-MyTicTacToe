package com.bnp.android.kata.mytictactoe.presentation

import androidx.compose.runtime.Immutable
import com.bnp.android.kata.mytictactoe.domain.enums.Player

@Immutable
data class GameUiState(
    val loading: Boolean = false,
    val playerName: String = "",
    val matchNul: Boolean = false,
    val winner: Boolean = false,
    val board: Map<Int, List<Player>> = emptyMap()
)