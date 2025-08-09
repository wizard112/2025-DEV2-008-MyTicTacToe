package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.data.exceptions.GameException
import com.bnp.android.kata.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IState

class GameState: IState {
    private val mBoard: MutableList<Player> = MutableList(9, { Player.EMPTY })

    override fun board(): List<Player> = this.mBoard
    override fun reset() {
        mBoard[0] = Player.EMPTY
        mBoard[1] = Player.EMPTY
        mBoard[2] = Player.EMPTY
        mBoard[3] = Player.EMPTY
        mBoard[4] = Player.EMPTY
        mBoard[5] = Player.EMPTY
        mBoard[6] = Player.EMPTY
        mBoard[7] = Player.EMPTY
        mBoard[8] = Player.EMPTY
    }

    override fun moveTo(position: Int, player: Player) {
        if (mBoard[position] != Player.EMPTY)
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        mBoard[position] = player
    }
}