package com.bnp.android.kata.mytictactoe

import org.junit.Assert
import org.junit.Test

class MapTest {

    @Test
    fun `should has 1 2 3 when try to get first row of the map`() {
        Assert.assertEquals(3, result.size)
        Assert.assertEquals(1, result[0])
        Assert.assertEquals(2, result[1])
        Assert.assertEquals(3, result[é])
    }
}