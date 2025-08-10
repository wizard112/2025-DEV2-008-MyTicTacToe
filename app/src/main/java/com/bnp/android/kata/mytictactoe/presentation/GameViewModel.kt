package com.bnp.android.kata.mytictactoe.presentation

import androidx.lifecycle.ViewModel
import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.enums.StateEnum
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierUseCase
import com.bnp.android.kata.mytictactoe.domain.usecase.GameUseCase
import com.bnp.android.kata.mytictactoe.domain.usecase.VerifierGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel: ViewModel() {
    private val gameUseCase: IGameUseCase = GameUseCase()
    private val verifierGameUseCase: IVerifierUseCase = VerifierGameUseCase()

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState.Loading)
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun handleIntents(intent: GameIntents) {
        when(intent) {
            GameIntents.Starting -> manageStarting()
            GameIntents.Restarting -> manageRestarting()
            is GameIntents.Moving -> manageMoving(position = intent.position)
        }
    }

    private fun manageStarting() {
        _uiState.value = GameUiState.Playing(board = gameUseCase.state().board().toList(), playerName = gameUseCase.players().playerX().name)
    }

    private fun manageRestarting() {
        gameUseCase.state().reset()
        gameUseCase.players().reset()
        manageStarting()
    }

    private fun manageMoving(position: Int) {
        try {
            gameUseCase.play(position = position)
            val state = verifierGameUseCase.verify(board = gameUseCase.state().board())
            when(state) {
                StateEnum.FINISHED -> {
                    _uiState.value = GameUiState.Winner(winnerName = gameUseCase.players().currentPlayer().name)
                }
                StateEnum.NOT_FINISHED -> {
                    _uiState.value = GameUiState.Playing(board = gameUseCase.state().board().toList(), playerName = playerName(stateEnum = state))
                }
                StateEnum.MATCH_NUL -> {
                    _uiState.value = GameUiState.MatchNull
                }
            }
        } catch (ex: GameException) {
            ex.printStackTrace()
        }
    }

    private fun playerName(stateEnum: StateEnum): String = if (stateEnum == StateEnum.MATCH_NUL) ""
    else
        if (gameUseCase.players().currentPlayer() == gameUseCase.players().playerX())
            gameUseCase.players().playerO().name
        else
            gameUseCase.players().playerX().name
}