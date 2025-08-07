package com.rossel.android.sdk.mytictactoe

import com.rossel.android.sdk.mytictactoe.domain.entity.VerifierGame
import org.junit.Assert
import org.junit.Test

class VerifierGameTest {
    private val verifier = VerifierGame()

    @Test
    fun `should finished when player has three in row of first horizontal`() {
        Assert.assertEquals("finished", verifier.verify())
    }
}