package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer

class Game {
    val players: IPlayer = Players()
    val board: MutableList<Player> = MutableList(9, { Player.EMPTY })

    fun play(position: Int) {
        players.turnTo()
        if (board[position] != Player.EMPTY)
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        board[position] = players.currentPlayer()
    }

    fun state(): String {
        return if (horizontalRow()) {
            "finished"
        } else "match nul"
    }

    private fun horizontalRow(): Boolean {
        return ((board[0] == Player.X && board[1] == Player.X && board[2] == Player.X)
                || (board[0] == Player.O && board[1] == Player.O && board[2] == Player.O)
                || (board[3] == Player.X && board[4] == Player.X && board[5] == Player.X)
                || (board[3] == Player.O && board[4] == Player.O && board[5] == Player.O))
    }
}