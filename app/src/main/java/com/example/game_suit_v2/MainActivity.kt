package com.example.game_suit_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView

class MainActivity : AppCompatActivity() {
  private lateinit var computerImageView: AppCompatImageView
  private lateinit var rockImageButton: AppCompatImageView
  private lateinit var scissorsImageButton: AppCompatImageView
  private lateinit var paperImageButton: AppCompatImageView
  private lateinit var resultImageView: AppCompatImageView
  private val viewModel = MainViewModel()

  private fun initComponents() {
    computerImageView = findViewById(R.id.img_computer)
    rockImageButton = findViewById(R.id.img_btn_rock)
    scissorsImageButton = findViewById(R.id.img_btn_scissor)
    paperImageButton = findViewById(R.id.img_btn_paper)
    resultImageView = findViewById(R.id.img_result)
  }

  private fun initListeners() {
    rockImageButton.setOnClickListener { startGame("ROCK") }
    scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
    paperImageButton.setOnClickListener { startGame("PAPER") }
  }

  private fun startGame(option: String) {
    val computerOption = viewModel.pickRandomOption()
    computerImageView.setImageResource(viewModel.pickDrawable(computerOption))

    when {
      viewModel.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
      viewModel.isWin(option, computerOption) == true -> resultImageView.setImageResource(R.drawable.win)
      else -> resultImageView.setImageResource(R.drawable.lose)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initComponents()
    initListeners()
  }
}