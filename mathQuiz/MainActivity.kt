package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.time.temporal.TemporalAdjusters.next

private lateinit var mathTextView:TextView
private lateinit var button1:Button
private lateinit var button2:Button
private lateinit var button3:Button
private lateinit var button4:Button

class MainActivity : AppCompatActivity() {
    var score=0
    var page=0
    private val Mathviewmodel:mathCommonModel by lazy{
        ViewModelProvider(this).get(mathCommonModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mathUpdate()

        button1.setOnClickListener{
            Answer(1)
        }
        button2.setOnClickListener{
            Answer(2)
        }
        button3.setOnClickListener{
            Answer(3)
        }
        button4.setOnClickListener{
            Answer(4)
        }

    }
    fun Answer(Ans:Int){
        var correctAnswer=Mathviewmodel.curAnswer

        var str=""
        var scoreTextView:TextView=findViewById(R.id.scoreTextView)
        if(Ans==correctAnswer){
            str="정답입니다"
            score+=20
            page++
            scoreTextView.text=score.toString()
            Mathviewmodel.nextbtn()
            mathUpdate()
            if(page==5){
                var intent=Intent(this,Gameover::class.java)
                intent.putExtra("key",score)
                startActivity(intent)
            }
        }
        else{
            str="오답입니다"
            var intent=Intent(this,Gameover::class.java)
            intent.putExtra("key",score)
            startActivity(intent)
        }
        Toast.makeText(applicationContext,str,Toast.LENGTH_SHORT).show()

    }
    fun mathUpdate(){
        mathTextView=findViewById(R.id.mathTextView)
        button1=findViewById(R.id.button)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        mathTextView.text=Mathviewmodel.curQuestion
        button1.text=Mathviewmodel.curNumber1
        button2.text=Mathviewmodel.curNumber2
        button3.text=Mathviewmodel.curNumber3
        button4.text=Mathviewmodel.curNumber4

    }
}