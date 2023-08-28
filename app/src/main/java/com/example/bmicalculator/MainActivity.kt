package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         binding.weightPicker.minValue=30
         binding.weightPicker.maxValue=150
         binding.heightPicker.minValue=100
         binding.heightPicker.maxValue=250

         binding.weightPicker.setOnValueChangedListener{_,_,_ ->
            calculateBMI()
        }
         binding.heightPicker.setOnValueChangedListener{_,_,_ ->
            calculateBMI()
        }
    }


     private fun calculateBMI(){
         val height = binding.heightPicker.value
         val doubleHeight = height.toDouble()/100

         val weight = binding.weightPicker.value

         val BMI = weight.toDouble()/(doubleHeight*doubleHeight)

         binding.result.text=String.format("Your BMI is: %.2f",BMI)
         binding.status.text=String.format("Considered: %s",statusMessage(BMI))

     }

     private fun statusMessage(BMI: Double): String{
         if(BMI <18.5){
             return "Underweight"
         }
         if(BMI<25){
             return "Healthy"
         }
         if(BMI<30){
             return "Overweight"
         }
         else{
             return "Obesse"
         }
     }
}