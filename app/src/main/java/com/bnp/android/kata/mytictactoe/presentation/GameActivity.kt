package com.bnp.android.kata.mytictactoe.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class GameActivity: AppCompatActivity() {
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreen(viewModel = gameViewModel)
        }
        gameViewModel.handleIntents(intent = GameIntents.Starting)
    }
}