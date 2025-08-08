package com.rossel.android.sdk.mytictactoe.domain.interfaces

import com.rossel.android.sdk.mytictactoe.domain.enums.Player

interface IStateMove {
    fun moveTo(position: Int, player: Player)
}