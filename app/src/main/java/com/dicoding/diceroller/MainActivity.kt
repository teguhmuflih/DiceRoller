package com.dicoding.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        // membuat dadu dengan 6 sisi dan mengocoknya
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //mencari ImageView pada Layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // menentukan mana drawable Resource ID yang digunakan pada pengocokan dadu
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // meng-update ImageView dengan Resource ID yang tepat
        diceImage.setImageResource(drawableResource)

        // mengupdate content description
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(val numSides: Int){
    fun roll(): Int{
        return(1..numSides).random()
    }
}