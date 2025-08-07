package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IState

class GameState: IState {
    private val mBoard: MutableList<Player> = MutableList(9, { Player.EMPTY })

    override fun board(): List<Player> = this.mBoard

    override fun moveTo(position: Int, player: Player) {
        if (mBoard[position] != Player.EMPTY)
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        mBoard[position] = player
    }

    override fun current(): String = if (horizontalRow(player = Player.X)
        || horizontalRow(player = Player.O)
        || verticalRow(player = Player.X)
        || verticalRow(player = Player.O)
        || diagonalRow(player = Player.X)
        || diagonalRow(player = Player.O)
        || antidiagonalRow(player = Player.X)
        || antidiagonalRow(player = Player.O)) {
        "finished"
    } else "match nul"

    private fun horizontalRow(player: Player): Boolean {
        return (mBoard[0] == player && mBoard[1] == player && mBoard[2] == player)
                || (mBoard[3] == player && mBoard[4] == player && mBoard[5] == player)
                || (mBoard[6] == player && mBoard[7] == player && mBoard[8] == player)
    }

    private fun verticalRow(player: Player): Boolean {
        return (mBoard[0] == player && mBoard[3] == player && mBoard[6] == player)
                || (mBoard[1] == player && mBoard[4] == player && mBoard[7] == player)
                || (mBoard[2] == player && mBoard[5] == player && mBoard[8] == player)
    }

    private fun diagonalRow(player: Player): Boolean {
        return (mBoard[0] == player && mBoard[4] == player && mBoard[8] == player)
    }

    private fun antidiagonalRow(player: Player): Boolean {
        return (mBoard[2] == player && mBoard[4] == player && mBoard[6] == player)
    }
}