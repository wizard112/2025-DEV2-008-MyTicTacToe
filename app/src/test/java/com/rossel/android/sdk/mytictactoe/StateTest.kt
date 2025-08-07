package com.rossel.android.sdk.mytictactoe

import org.junit.Assert
import org.junit.Test

class StateTest {

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        Assert.assertEquals("finished", state.current())
    }
}