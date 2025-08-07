package com.rossel.android.sdk.mytictactoe.domain.interfaces

import com.rossel.android.sdk.mytictactoe.domain.entity.VerifierGame

interface IStateVerifier {
    fun verifier(): VerifierGame
}