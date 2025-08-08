package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IPlayerCurrent {
    fun currentPlayer(): Player
}