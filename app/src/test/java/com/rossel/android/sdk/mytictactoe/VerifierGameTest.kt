package com.rossel.android.sdk.mytictactoe

import org.junit.Assert
import org.junit.Test

class VerifierGameTest {
    @Test
    fun `should finished when player has three in row of first horizontal`() {
        Assert.assertEquals("finished", verifier.verify())
    }
}