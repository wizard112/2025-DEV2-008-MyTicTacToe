package com.rossel.android.sdk.mytictactoe.presentation

import androidx.lifecycle.ViewModel
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IGameUseCase
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierUseCase
import com.rossel.android.sdk.mytictactoe.domain.usecase.GameUseCase
import com.rossel.android.sdk.mytictactoe.domain.usecase.VerifierGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val gameUseCase: IGameUseCase = GameUseCase()
    private val verifierGameUseCase: IVerifierUseCase = VerifierGameUseCase()

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState.Loading)
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun handleIntents(intent: GameIntents) {
        when(intent) {
            GameIntents.Starting -> manageStarting()
            is GameIntents.Moving -> manageMoving(position = intent.position)
        }
    }

    private fun manageStarting() {
        gameUseCase.players().turnTo()
        _uiState.update { GameUiState.Playing(board = gameUseCase.state().board(), playerName = gameUseCase.players().currentPlayer().name) }
    }

    private fun manageMoving(position: Int) {
        gameUseCase.play(position = position)
        val state = verifierGameUseCase.verify(board = gameUseCase.state().board())
        val playerName = if (state == StateEnum.MATCH_NUL) "" else gameUseCase.players().currentPlayer().name
        when(state) {
            StateEnum.FINISHED -> _uiState.update { GameUiState.Winner(playerName = playerName) }
            StateEnum.NOT_FINISHED -> _uiState.update { GameUiState.Playing(board = gameUseCase.state().board(), playerName = playerName) }
            StateEnum.MATCH_NUL -> _uiState.update { GameUiState.MatchNul }
        }
    }
}