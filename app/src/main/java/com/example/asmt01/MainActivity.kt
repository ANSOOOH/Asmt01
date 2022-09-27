package com.example.asmt01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import kotlin.random.Random as KotlinRandomRandom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //주요코드 설명 영어로 옮겨서 제출해야 함
        //1번
        val expression = "100 / 0"
        var listEx = expression.split(" ") //Split by whitespaces and save to list
        val first = listEx[0].toInt() //Convert String to Int
        val operator = listEx[1] //Keep String type
        val second = listEx[2].toInt() //Convert String to Int

        //when as expression named result
        val result = when (operator) {
            "+" -> first + second //if "+" condition, result has 'first+second' action
            "-" -> first - second //if "-" condition, result has 'first-second' action
            "*" -> first * second //if "*" condition, result has 'first*second' action
            //Proceed with calculation if not divided by zero
            "/" -> if(second != 0) first / second else "cannot devide by zero"
            "%" -> if(second != 0) first % second else "cannot devide by zero"
            else -> "repeat again"
        }
        Log.d("HW01", "result: $result, (expression: $expression)")


        //2번
        val capacity = 10
        var myArray = IntArray(capacity) //Create an int array with a size of capacity as myArray
        for(i in 0 until capacity){ //Repeat the number by the size of the capacity
            var int_random = Random().nextInt(100)+1 //Random integers ranging from 1 to 100
            while(int_random in myArray){ //If the myArray already has a random number,
                int_random = Random().nextInt(100)+1 //Specify the number at random in int_random again
            }
            myArray[i] = int_random //If there is no duplication, add a value to the corresponding index
        }
        var myUniqueArray = Arrays.toString(myArray) //String return method
        Log.d("HW01", "result: $myUniqueArray, capacity: $capacity")


        //3번
        val strLine = arrayOf<String>("Seoul National University of Science and Technology",
            "Seoul Station",
            "IT Management",
            "Android and Kotlin is not that difficult",
            "Exit")// initialize string array with string line
        for (i in strLine){ //Repeat one sentence in the array
            val st = i.split(" ") //Split by spacing and assign to a new list called 'st'
            //the number of elements in the list is word count
            Log.d("HW01", "The number of words is ${st.size}")
        }

        //4번
        /*var str = arrayOf<String>("I Love Kotlin") // modify this for test
        //Split each character in the array and put it in split_str.
        var split_str = str[0].split("")
        //[, I,  , L, o, v, e,  , K, o, t, l, i, n, ]
        var str2 = mutableListOf<String>()
        for(i in 1..13){ //Range of desired character indexes (from 'I' to 'n')
            val value = split_str[i]
            str2.add(value) //Add an element to the mutablelist
        }
        for(i in 0 until str2.size+1){
            ///Data output format conversion, no separator and start-stop expression
            val strnew = str2.joinToString("")
            Log.d("HW01","$strnew")
            str2.add(str2[0]) //Attach the first element to the end of the list
            str2.removeAt(0) //Delete the first index value
        }*/

        //5번
        val math = 100
        val science = 100
        val english = 90
        val me = Grade(math, science, english)
        //Log.d("HW01","my math: $math, my science: $science, my english: $english")
        //Log.d("HW01","Average is ${me.average()}")

        //6번
        val str = "jinwoo"
        val range = str.length/2 //Do as much as divide by 2
        val last = str.length - 1 //Last Index Value
        val charList = str.toList() //Change String to Char type
        var checkpoint = 0 //Value to check in if-else conditional statement
        var k = 0 //initialize to check charList index
        for(i in 0..range){
            //If the first and last char values are the same
            if(charList[k] == charList[last-k]) {
                k++ //Comparison to the next index
                continue
            }else{
                //If the first and last values are different,
                //change the checkpoint to 1 and break
                checkpoint = 1
                break
            }
        }
        //If the checkpoint is 0 > palindrome
        if(checkpoint == 1){
            Log.d("HW01","$str is Not palindrome!")
        }else if(checkpoint == 0){
            Log.d("HW01","$str is palindrome!")
        }else{
            Log.d("HW01","Error message")
        }


        //7번
        val p = Point(5,5)
        p.x=10
        p.y=20
        p.show()

        val cp = ColorPoint(5, 5, "YELLOW")
        cp.setPoint(10, 20)
        cp.color = "GREEN"
        cp.y=100
        cp.show()




    }
}

//7번
open class Point(open var x: Int, open var y: Int) {
    fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    open fun show(){
        Log.d("HW01","Current Point: ($x, $y)")
    }
}
//making derived class with setting new color parameter('var' to change)
class ColorPoint(x:Int, y: Int, var color: String): Point(x, y){
    override var x = x
    override var y = y
        //get() = field
        set(value) { //custom setter to access the property itself
            field = value
            Log.d("HW01","Y has been changed to $y")
        }
    //Create a setPoint function for new x and y values
    fun setPoint(x:Int, y: Int){
        this.x = x
        this.y = y
    }

    //override function 'show()' of base class and change body part
    override fun show() {
        Log.d("HW01","Color:${color} Current Point: ($x, $y)")
    }
}


//5번임
class Grade(val math: Int, val science: Int, val english: Int){ //Specify parameters
    fun average(): Int { //Return type Int of function
        val result = (math+science+english)/3 //Return after average calculation
        return result
    }
}