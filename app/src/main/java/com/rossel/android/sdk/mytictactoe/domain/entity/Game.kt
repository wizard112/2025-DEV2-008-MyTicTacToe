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
        return if (horizontalRow(player = players.playerX())
            || horizontalRow(player = players.playerO())) {
            "finished"
        } else "match nul"
    }

    private fun horizontalRow(player: Player): Boolean {
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
    }
}