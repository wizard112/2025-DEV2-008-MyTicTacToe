package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.entity.GameState
import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import org.junit.Assert
import org.junit.Test

class StateTest {
    private val state = GameState()

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        state.moveTo(position = 0, player = Player.X)
        state.moveTo(position = 3, player = Player.O)
        state.moveTo(position = 1, player = Player.X)
        state.moveTo(position = 6, player = Player.O)
        state.moveTo(position = 2, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in row of second horizontal`() {
        state.moveTo(position = 3, player = Player.X)
        state.moveTo(position = 0, player = Player.O)
        state.moveTo(position = 4, player = Player.X)
        state.moveTo(position = 1, player = Player.O)
        state.moveTo(position = 5, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in row of third horizontal`() {
        state.moveTo(position = 6, player = Player.X)
        state.moveTo(position = 0, player = Player.O)
        state.moveTo(position = 7, player = Player.X)
        state.moveTo(position = 1, player = Player.O)
        state.moveTo(position = 8, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in row of first vertical`() {
        state.moveTo(position = 0, player = Player.X)
        state.moveTo(position = 1, player = Player.O)
        state.moveTo(position = 3, player = Player.X)
        state.moveTo(position = 2, player = Player.O)
        state.moveTo(position = 6, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in row of second vertical`() {
        state.moveTo(position = 1, player = Player.X)
        state.moveTo(position = 0, player = Player.O)
        state.moveTo(position = 4, player = Player.X)
        state.moveTo(position = 2, player = Player.O)
        state.moveTo(position = 7, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in row of third vertical`() {
        state.moveTo(position = 1, player = Player.X)
        state.moveTo(position = 0, player = Player.O)
        state.moveTo(position = 4, player = Player.X)
        state.moveTo(position = 2, player = Player.O)
        state.moveTo(position = 7, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in diagonal`() {
        state.moveTo(position = 0, player = Player.X)
        state.moveTo(position = 1, player = Player.O)
        state.moveTo(position = 4, player = Player.X)
        state.moveTo(position = 2, player = Player.O)
        state.moveTo(position = 8, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }

    @Test
    fun `should finished when player has three in antidiagonal`() {
        state.moveTo(position = 2, player = Player.X)
        state.moveTo(position = 1, player = Player.O)
        state.moveTo(position = 4, player = Player.X)
        state.moveTo(position = 3, player = Player.O)
        state.moveTo(position = 6, player = Player.X)
        Assert.assertEquals("finished", state.current(player = Player.X))
    }
}