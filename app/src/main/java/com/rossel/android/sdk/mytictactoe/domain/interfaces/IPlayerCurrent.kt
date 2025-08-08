package com.rossel.android.sdk.mytictactoe.domain.interfaces

import com.rossel.android.sdk.mytictactoe.domain.enums.Player

interface IPlayerCurrent {
    fun currentPlayer(): Player
}