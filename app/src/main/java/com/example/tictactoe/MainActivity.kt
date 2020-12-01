package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonReset: Button

    private val firstPlayer: MutableList<Int> = mutableListOf()
    private val secondPlayer: MutableList<Int> = mutableListOf()

    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0
            var Reset = false

            when(clickedView.id) {
                R.id.Button1 -> buttonNumber = 1
                R.id.Button2 -> buttonNumber = 2
                R.id.Button3 -> buttonNumber = 3
                R.id.Button4 -> buttonNumber = 4
                R.id.Button5 -> buttonNumber = 5
                R.id.Button6 -> buttonNumber = 6
                R.id.Button7 -> buttonNumber = 7
                R.id.Button8 -> buttonNumber = 8
                R.id.Button9 -> buttonNumber = 9
                R.id.ResetButton -> Reset = true
            }

            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView)
            }
            if (Reset == true) {
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer = 1
                enableButtons()
                button1.text = ""
                button1.setBackgroundColor(Color.rgb(98, 0, 238))
                button2.text = ""
                button2.setBackgroundColor(Color.rgb(98, 0, 238))
                button3.text = ""
                button3.setBackgroundColor(Color.rgb(98, 0, 238))
                button4.text = ""
                button4.setBackgroundColor(Color.rgb(98, 0, 238))
                button5.text = ""
                button5.setBackgroundColor(Color.rgb(98, 0, 238))
                button6.text = ""
                button6.setBackgroundColor(Color.rgb(98, 0, 238))
                button7.text = ""
                button7.setBackgroundColor(Color.rgb(98, 0, 238))
                button8.text = ""
                button8.setBackgroundColor(Color.rgb(98, 0, 238))
                button9.text = ""
                button9.setBackgroundColor(Color.rgb(98, 0, 238))
            }

        }

    }

    private fun enableButtons() {
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {

        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.YELLOW)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }

        clickedView.isEnabled = false
        check()
    }


    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X won the game!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "O won the game!", Toast.LENGTH_LONG).show()
            }
            disableButtons()
        }

    }

    private fun disableButtons() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }

    private fun init() {

        button1 = findViewById(R.id.Button1)
        button2 = findViewById(R.id.Button2)
        button3 = findViewById(R.id.Button3)
        button4 = findViewById(R.id.Button4)
        button5 = findViewById(R.id.Button5)
        button6 = findViewById(R.id.Button6)
        button7 = findViewById(R.id.Button7)
        button8 = findViewById(R.id.Button8)
        button9 = findViewById(R.id.Button9)
        buttonReset = findViewById(R.id.ResetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonReset.setOnClickListener(this)
    }
}