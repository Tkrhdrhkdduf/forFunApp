package com.example.mathquiz

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class mathCommonModel:ViewModel() {
    private val mathBank= listOf<Math>(
        Math("3+5=?","8","5","1","6",1),
        Math("x^2+5=30, x의 값은?","2","3","4","5",4),
        Math("원의 넓이 공식:","r^3+PI","r^2*PI","r*PI","r+r+r",2),
        Math("x^3+x^2-1 에 대하여 f'(2)? ","15","18","3","21",2),
        Math("Cos 90","0","1/2","1","1/4",3)
    )
    var rand= Random(System.nanoTime())
    var cur=rand.nextInt(mathBank.size)// 현재 인덱스
    val curAnswer:Int
        get() = mathBank[cur].answer
    val curQuestion:String
        get() = mathBank[cur].Question
    val curNumber1:String
        get() = mathBank[cur].num_1
    val curNumber2:String
        get() = mathBank[cur].num_2
    val curNumber3:String
        get() = mathBank[cur].num_3
    val curNumber4:String
        get() = mathBank[cur].num_4
    fun nextbtn(){
        cur=(cur+1)%mathBank.size
    }

}