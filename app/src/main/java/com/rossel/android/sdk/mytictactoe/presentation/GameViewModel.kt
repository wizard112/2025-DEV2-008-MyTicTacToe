package com.rossel.android.sdk.mytictactoe.presentation

import androidx.lifecycle.ViewModel
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IGameUseCase
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierUseCase
import com.rossel.android.sdk.mytictactoe.domain.usecase.GameUseCase
import com.rossel.android.sdk.mytictactoe.domain.usecase.VerifierGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val gameUseCase: IGameUseCase = GameUseCase()
    private val verifierGameUseCase: IVerifierUseCase = VerifierGameUseCase()

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState.Playing)
    val uiState: StateFlow<GameUiState> = _uiState


    fun manageGame(position: Int) {
        gameUseCase.play(position = position)
    }
}