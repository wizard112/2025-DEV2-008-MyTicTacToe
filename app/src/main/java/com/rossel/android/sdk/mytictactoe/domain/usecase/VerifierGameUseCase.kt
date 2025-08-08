package com.rossel.android.sdk.mytictactoe.domain.usecase

import com.rossel.android.sdk.mytictactoe.domain.entity.VerifierAntidiagonalRow
import com.rossel.android.sdk.mytictactoe.domain.entity.VerifierDiagonalRow
import com.rossel.android.sdk.mytictactoe.domain.entity.VerifierHorizontalRow
import com.rossel.android.sdk.mytictactoe.domain.entity.VerifierVerticalRow
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierUseCase
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IVerifierRow

class VerifierGameUseCase: IVerifierUseCase {
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