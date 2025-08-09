package com.bnp.android.kata.mytictactoe.domain.usecase

import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.bnp.android.kata.mytictactoe.domain.entity.GameState
import com.bnp.android.kata.mytictactoe.domain.entity.Players
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase
import com.bnp.android.kata.mytictactoe.domain.interfaces.IPlayer
import com.bnp.android.kata.mytictactoe.domain.interfaces.IState

class GameUseCase(private val columns: Int, private val rows: Int): IGameUseCase {
    //private val players: IPlayer = Players()
    //private val state: IState = GameState()
    private val mBoard: HashMap<Int, Int> = hashMapOf()
    init { initialize() }

    //override fun players(): IPlayer = players
    //override fun state(): IState = state

    private fun initialize() {
        //TODO
    }

    override fun reset() {
        initialize()
    }

    override fun board(): Map<Int, List<Player>> = this.mBoard

    override fun play(column: Int, row: Int, player: Player) {
        //TODO
    }
}