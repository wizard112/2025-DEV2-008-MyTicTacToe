package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer

class Game {
    val players: IPlayer = Players()
    val board: MutableList<Player> = MutableList(9, { Player.EMPTY })

    fun play(position: Int) {
        players.turnTo()
        if (board.get(position) != Player.EMPTY)
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        board.add(index = position, element = players.currentPlayer())
    }
}