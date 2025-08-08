package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.enums.StateEnum

interface IVerifierUseCase {
    fun verify(board: List<Player>): StateEnum
}