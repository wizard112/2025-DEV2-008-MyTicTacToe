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
    val verifiers = mutableListOf<IVerifierRow>()
    init {
        verifiers.add(element = VerifierHorizontalRow())
        verifiers.add(element = VerifierVerticalRow())
        verifiers.add(element = VerifierAntidiagonalRow())
        verifiers.add(element = VerifierDiagonalRow())
    }

    override fun verify(board: List<Player>): StateEnum = when {
        verifiers.any { verifier -> verifier.verifierRow(board = board, player = Player.X) || verifier.verifierRow(board = board, player = Player.O)} -> StateEnum.FINISHED
        board.filter { player -> player == Player.X || player == Player.O }.size == 9 -> StateEnum.MATCH_NUL
        else -> StateEnum.NOT_FINISHED
    }
}