package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifier


class VerifierHorizontalRow {
    fun horizontalRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
    }
}

class VerifierVerticalRow {
    fun verticalRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
    }
}

class VerifierAntidiagonalRow {
    fun diagonalRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[4] == player && board[8] == player)
    }
}

class VerifierDiagonalRow {
    fun antidiagonalRow(board: List<Player>, player: Player): Boolean {
        return (board[2] == player && board[4] == player && board[6] == player)
    }
}

class VerifierGame: IVerifier {
    private val verifierHorizontalRow = VerifierHorizontalRow()
    private val verifierVerticalRow = VerifierVerticalRow()
    private val verifierAntidiagonalRow = VerifierAntidiagonalRow()
    private val verifierDiagonalRow = VerifierDiagonalRow()

    override fun verify(board: List<Player>): StateEnum = if (verifierHorizontalRow.horizontalRow(board = board, player = Player.X)
        || verifierHorizontalRow.horizontalRow(board = board, player = Player.O)
        || verifierVerticalRow.verticalRow(board = board, player = Player.X)
        || verifierVerticalRow.verticalRow(board = board, player = Player.O)
        || verifierAntidiagonalRow.diagonalRow(board = board, player = Player.X)
        || verifierAntidiagonalRow.diagonalRow(board = board, player = Player.O)
        || verifierDiagonalRow.antidiagonalRow(board = board, player = Player.X)
        || verifierDiagonalRow.antidiagonalRow(board = board, player = Player.O)) {
        StateEnum.FINISHED
    } else StateEnum.MATCH_NUL
}