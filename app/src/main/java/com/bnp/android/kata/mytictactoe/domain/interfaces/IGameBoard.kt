package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IGameBoard {
    fun board(): Map<Int, MutableList<Player>>
}