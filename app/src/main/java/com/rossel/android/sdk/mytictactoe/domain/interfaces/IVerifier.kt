package com.rossel.android.sdk.mytictactoe.domain.interfaces

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.enums.StateEnum

interface IVerifier {
    fun verify(board: List<Player>): StateEnum
}