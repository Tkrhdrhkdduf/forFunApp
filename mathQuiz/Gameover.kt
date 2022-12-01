package com.example.mathquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Gameover : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameover)
        var scoreText:TextView=findViewById(R.id.gscoreTextView)
        var text:TextView=findViewById(R.id.textView2)
        var btn:Button=findViewById(R.id.finishBtn)
        var i=intent.getIntExtra("key",0)
        if(i==100){
            text.text="Well done"
            btn.text="Exit"
        }
        else{
            text.text="GameOver"
            btn.text="Retry"
        }
        scoreText.text=i.toString()
    }
}