package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IStateMove {
    fun moveTo(position: Int, player: Player)
}