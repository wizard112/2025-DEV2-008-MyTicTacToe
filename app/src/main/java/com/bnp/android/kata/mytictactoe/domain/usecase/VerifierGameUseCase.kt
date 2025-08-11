package com.bnp.android.kata.mytictactoe.domain.usecase

import com.bnp.android.kata.mytictactoe.domain.entity.VerifierAntidiagonalRow
import com.bnp.android.kata.mytictactoe.domain.entity.VerifierDiagonalRow
import com.bnp.android.kata.mytictactoe.domain.entity.VerifierHorizontalRow
import com.bnp.android.kata.mytictactoe.domain.entity.VerifierVerticalRow
import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.enums.StateEnum
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierUseCase
import com.bnp.android.kata.mytictactoe.domain.interfaces.IVerifierRow

class VerifierGameUseCase: IVerifierUseCase {
    val verifiers = mutableListOf<IVerifierRow>()
    init {
        verifiers.add(element = VerifierHorizontalRow())
        verifiers.add(element = VerifierVerticalRow())
        verifiers.add(element = VerifierAntidiagonalRow())
        verifiers.add(element = VerifierDiagonalRow())
    }

    override fun verify(board: Map<Int, MutableList<Player>>): StateEnum {
        return when {
            verifiers.any { verifier ->
                verifier.verifierRow(board = board, player = Player.X)
                        || verifier.verifierRow(board = board, player = Player.O)
            } -> StateEnum.FINISHED

            board.values.flatMap { it }.filter { player -> player == Player.X || player == Player.O }.size == 9 -> StateEnum.MATCH_NUL
            else -> StateEnum.NOT_FINISHED
        }
    }
}