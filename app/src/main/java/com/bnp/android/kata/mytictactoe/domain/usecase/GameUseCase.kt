package com.bnp.android.kata.mytictactoe.domain.usecase

import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IGameUseCase

class GameUseCase(private val columns: Int, private val rows: Int): IGameUseCase {
    private val mBoard: HashMap<Int, MutableList<Player>> = hashMapOf()
    init { initialize() }

    private fun initialize() {
        for (i in 0..columns) {
            mBoard.put(i, MutableList(size = rows, init = { Player.EMPTY}))
        }
    }

    override fun reset() {
        initialize()
    }

    override fun board(): Map<Int, MutableList<Player>> = this.mBoard

    override fun play(column: Int, row: Int, player: Player) {
        if (mBoard.contains(key = column) && mBoard.get(key = column) != null) {
            mBoard.get(key = column)?.let {
                if (it[row] != Player.EMPTY)
                    throw GameException(msg = "$FIELD_ALREADY_TAKEN at ($column, $row) by the play ${it[row]}")
            }
        }
        mBoard[column]?.let { c -> c[row] = player }
    }
}