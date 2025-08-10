package com.bnp.android.kata.mytictactoe

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.bnp.android.kata.mytictactoe.presentation.GameIntents
import com.bnp.android.kata.mytictactoe.presentation.GameScreen
import com.bnp.android.kata.mytictactoe.presentation.GameViewModel
import org.junit.Rule
import org.junit.Test

class GameScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val gameViewModel = GameViewModel()

    @Test
    fun testGameScreenComposable() {
        gameViewModel.handleIntents(intent = GameIntents.Starting)
        // Start the app
        composeTestRule.setContent {
            GameScreen(viewModel = gameViewModel)
        }

        composeTestRule.onNode(hasText("X is your turn"))
        composeTestRule.onNode(hasTestTag(testTag = "cell_1")).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(testTag = "cell_1")).assertHasClickAction()
        composeTestRule.onNode(hasTestTag(testTag = "cell_1")).performClick()
        composeTestRule.onNode(hasTestTag(testTag = "cell_1")).assertTextEquals("X")
        composeTestRule.onNode(hasText("O is your turn"))
    }
}