package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.rossel.android.sdk.mytictactoe.domain.enums.Player

class GameState {
    val board: MutableList<Player> = MutableList(9, { Player.EMPTY })

    fun moveTo(position: Int, player: Player) {
        if (board[position] != Player.EMPTY)
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        board[position] = player
    }

    fun current(): String = if (horizontalRow(player = Player.X)
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
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
    }

    private fun verticalRow(player: Player): Boolean {
        return (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
    }

    private fun diagonalRow(player: Player): Boolean {
        return (board[0] == player && board[4] == player && board[8] == player)
    }

    private fun antidiagonalRow(player: Player): Boolean {
        return (board[2] == player && board[4] == player && board[6] == player)
    }
}