package com.example.game_suit_v2

import androidx.appcompat.widget.AppCompatImageView
import kotlin.random.Random

class MainViewModel() {
  private val options = listOf("ROCK", "SCISSORS", "PAPER")

  private val rules = mapOf(
    "ROCK-SCISSORS" to true,
    "ROCK-PAPER" to false,
    "SCISSORS-PAPER" to true,
    "SCISSORS-ROCK" to false,
    "PAPER-ROCK" to true,
    "PAPER-SCISSORS" to false,
  )

  private fun optionDrawable(option: String): Int {
    return when (option) {
      "ROCK" -> R.drawable.rock
      "SCISSORS" -> R.drawable.scissor
      "PAPER" -> R.drawable.paper
      else -> R.drawable.question
    }
  }

  fun pickRandomOption(): String = options[Random.nextInt(0, 3)]

  fun pickDrawable(option: String): Int = optionDrawable(option)

  fun isDraw(from: String, to: String): Boolean = from == to

  fun isWin(from: String, to: String): Boolean? = rules["$from-$to"]

}