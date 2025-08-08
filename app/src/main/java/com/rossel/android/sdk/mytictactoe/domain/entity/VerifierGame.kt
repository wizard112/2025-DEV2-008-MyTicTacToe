package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifier

interface IVerifierRow {
    fun verifierRow(board: List<Player>, player: Player): Boolean
}
class VerifierHorizontalRow: IVerifierRow{
    override fun verifierRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
    }
}

class VerifierVerticalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
    }
}

class VerifierAntidiagonalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean {
        return (board[0] == player && board[4] == player && board[8] == player)
    }
}

class VerifierDiagonalRow: IVerifierRow {
    override fun verifierRow(board: List<Player>, player: Player): Boolean {
        return (board[2] == player && board[4] == player && board[6] == player)
    }
}

class VerifierGame: IVerifier {
    private val verifierHorizontalRow: IVerifierRow = VerifierHorizontalRow()
    private val verifierVerticalRow: IVerifierRow = VerifierVerticalRow()
    private val verifierAntidiagonalRow: IVerifierRow = VerifierAntidiagonalRow()
    private val verifierDiagonalRow: IVerifierRow = VerifierDiagonalRow()

    override fun verify(board: List<Player>): StateEnum = if (verifierHorizontalRow.verifierRow(board = board, player = Player.X)
        || verifierHorizontalRow.verifierRow(board = board, player = Player.O)
        || verifierVerticalRow.verifierRow(board = board, player = Player.X)
        || verifierVerticalRow.verifierRow(board = board, player = Player.O)
        || verifierAntidiagonalRow.verifierRow(board = board, player = Player.X)
        || verifierAntidiagonalRow.verifierRow(board = board, player = Player.O)
        || verifierDiagonalRow.verifierRow(board = board, player = Player.X)
        || verifierDiagonalRow.verifierRow(board = board, player = Player.O)) {
        StateEnum.FINISHED
    } else StateEnum.MATCH_NUL
}