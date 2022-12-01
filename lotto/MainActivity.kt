package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashSet
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var reset:Button=findViewById(R.id.reset)
        var randomizer:Button=findViewById(R.id.randomizer)
        var lotto:TextView=findViewById(R.id.randomText)
        var lotto2:TextView=findViewById(R.id.randomText2)
        var lotto3:TextView=findViewById(R.id.randomText7)
        var lotto4:TextView=findViewById(R.id.randomText8)
        var lotto5:TextView=findViewById(R.id.randomText9)
        var lotto6:TextView=findViewById(R.id.randomText10)
        var set= mutableSetOf<Int>()
        var rand=Random(System.nanoTime())
        var array= arrayOf<TextView>(lotto,lotto2,lotto3,lotto4,lotto5,lotto6)
        randomizer.setOnClickListener{

            for(i in array.indices){
                var lottoNum=rand.nextInt(45)+1
                set.add(lottoNum)

            }
            set=set.toSortedSet()
            for(i in array.indices){
                array[i].text=" ${set.elementAt(i)}"
            }



        }
        reset.setOnClickListener{
            for (i in array.indices){
                array[i].text=""
                set.clear()

            }
        }

    }
}