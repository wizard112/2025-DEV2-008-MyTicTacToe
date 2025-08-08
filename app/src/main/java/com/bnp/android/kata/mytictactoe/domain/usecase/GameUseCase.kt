package com.bnp.android.kata.mytictactoe.domain.usecase

import com.bnp.android.kata.mytictactoe.domain.entity.GameState
import com.bnp.android.kata.mytictactoe.domain.entity.Players
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase
import com.bnp.android.kata.mytictactoe.domain.interfaces.IPlayer
import com.bnp.android.kata.mytictactoe.domain.interfaces.IState

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