package com.bnp.android.kata.mytictactoe.presentation

import androidx.lifecycle.ViewModel
import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.constants.NB_COLUMN
import com.bnp.android.kata.mytictactoe.domain.constants.NB_ROW
import com.bnp.android.kata.mytictactoe.domain.enums.StateEnum
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase
import com.bnp.android.kata.mytictactoe.domain.interfaces.IPlayer
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierUseCase
import com.bnp.android.kata.mytictactoe.domain.usecase.GameUseCase
import com.bnp.android.kata.mytictactoe.domain.usecase.PlayersUseCase
import com.bnp.android.kata.mytictactoe.domain.usecase.VerifierGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val gameUseCase: IGameUseCase = GameUseCase(columns = NB_COLUMN, rows = NB_ROW)
    private val verifierGameUseCase: IVerifierUseCase = VerifierGameUseCase()
    private val playersUseCase: IPlayer = PlayersUseCase()

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState(loading = true))
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun handleIntents(intent: GameIntents) {
        when(intent) {
            GameIntents.Starting -> manageStarting()
            GameIntents.Restarting -> {
                gameUseCase.reset()
                gameUseCase.reset()
                manageStarting()
            }
            is GameIntents.Moving -> manageMoving(column = intent.column, row = intent.row)
        }
    }

    private fun manageStarting() {
        playersUseCase.turnTo()
        _uiState.update {
            it.copy(board = gameUseCase.board().toMap(), playerName = playersUseCase.currentPlayer().name, loading = false, matchNul = false, winner = false)
        }
    }

    private fun manageMoving(column: Int, row: Int) {
        try {
            gameUseCase.play(column = column, row = row, player = playersUseCase.currentPlayer())
            val state = verifierGameUseCase.verify(board = gameUseCase.board())
            when(state) {
                StateEnum.FINISHED -> {
                    _uiState.update { it.copy(playerName = playersUseCase.currentPlayer().name, winner = true) }
                }
                StateEnum.NOT_FINISHED -> {
                    playersUseCase.turnTo()
                    _uiState.update { it.copy(board = gameUseCase.board().toMap(), playerName = playersUseCase.currentPlayer().name) }
                }
                StateEnum.MATCH_NUL -> {
                    _uiState.update { it.copy(matchNul = true) }
                }
            }
        } catch (ex: GameException) {
            ex.printStackTrace()
        }
    }
}