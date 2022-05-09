package com.example.jeudechecs

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.media.AudioManager
import android.media.SoundPool

open class objet(val nom : String, var position: casier, val couleur : String){
    val paint = Paint()
    init {
        position.occupant = this
        position.libre = false
    }

    open fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context){
    }

}