package com.rossel.android.sdk.mytictactoe.domain.interfaces

import com.rossel.android.sdk.mytictactoe.domain.enums.Player

interface IStateBoard {
    fun board(): List<Player>
}