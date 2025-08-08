package com.rossel.android.sdk.mytictactoe.domain.usecase

import com.rossel.android.sdk.mytictactoe.domain.entity.GameState
import com.rossel.android.sdk.mytictactoe.domain.entity.Players
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IGameUseCase
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IState

class GameUseCase: IGameUseCase {
    private val players: IPlayer = Players()
    private val state: IState = GameState()

    override fun players(): IPlayer = players
    override fun state(): IState = state

    override fun play(position: Int) {
        players.turnTo()
        state.moveTo(position = position, player = players.currentPlayer())
    }
}