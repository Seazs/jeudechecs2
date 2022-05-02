package com.example.jeudechecs

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.media.AudioManager
import android.media.SoundPool

open class objet(val nom : String, var position: casier, val couleur : String){
    val paint = Paint()
    init {
        position.occupant = this
        position.libre = false
    }

    open fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 30, Y1 - 30, X2 - 30, Y2 + 30)
        if (this.couleur == "blanc"){
            paint.color = Color.WHITE
        }
        else {
            paint.color = Color.BLACK
        }
        canvas.drawOval(r2, paint)
    }

}