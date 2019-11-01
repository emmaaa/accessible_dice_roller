package com.emmaburton.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1

        diceImage = findViewById(R.id.dice_image)
        diceImage.setImageResource(getDiceDrawable(randomInt))

        // For accessibility
        val talkBackAnnouncement = "Dice rolled a $randomInt"
        diceImage.contentDescription = talkBackAnnouncement
        diceImage.announceForAccessibility(talkBackAnnouncement)
    }

    private fun getDiceDrawable(randomInt: Int) = when (randomInt) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }


}
