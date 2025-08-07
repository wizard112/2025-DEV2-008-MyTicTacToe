package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IState

class GameState: IState {
    private val mBoard: MutableList<Player> = MutableList(9, { Player.EMPTY })
    val verifier: VerifierGame = VerifierGame()

    override fun board(): List<Player> = this.mBoard

    override fun verifier(): VerifierGame = this.verifier

    override fun moveTo(position: Int, player: Player) {
        if (mBoard[position] != Player.EMPTY)
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        mBoard[position] = player
    }
}