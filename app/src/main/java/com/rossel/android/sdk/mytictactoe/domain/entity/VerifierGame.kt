package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifier

class VerifierGame: IVerifier {

    override fun verify(board: List<Player>): String = if (horizontalRow(board = board, player = Player.X)
        || horizontalRow(board = board, player = Player.O)
        || verticalRow(board = board, player = Player.X)
        || verticalRow(board = board, player = Player.O)
        || diagonalRow(board = board, player = Player.X)
        || diagonalRow(board = board, player = Player.O)
        || antidiagonalRow(board = board, player = Player.X)
        || antidiagonalRow(board = board, player = Player.O)) {
        "finished"
    } else "match nul"

    private fun horizontalRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
    }

    private fun verticalRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
    }

    private fun diagonalRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[4] == player && board[8] == player)
    }

    private fun antidiagonalRow(board: List<Player>, player: Player): Boolean {
        return (board[2] == player && board[4] == player && board[6] == player)
    }
}