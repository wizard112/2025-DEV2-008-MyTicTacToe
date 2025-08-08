package com.rossel.android.sdk.mytictactoe.presentation

import androidx.lifecycle.ViewModel
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IGameUseCase
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierUseCase
import com.rossel.android.sdk.mytictactoe.domain.usecase.GameUseCase
import com.rossel.android.sdk.mytictactoe.domain.usecase.VerifierGameUseCase

class GameViewModel: ViewModel() {
    private val gameUseCase: IGameUseCase = GameUseCase()
    private val verifierGameUseCase: IVerifierUseCase = VerifierGameUseCase()

    var state: GameUiState = GameUiState.Started

    fun manageGame(position: Int) {
        gameUseCase.play(position = position)
    }
}