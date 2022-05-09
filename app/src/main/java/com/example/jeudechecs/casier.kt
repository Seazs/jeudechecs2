package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.example.jeudechecs.MainActivity.Companion.context

class casier(val nom : String, val absysse : Int, var libre : Boolean, var occupant : objet?, var couleur: Paint): objetpiece {

    lateinit var r : RectF

    fun draw(canvas: Canvas, X1: Float, Y1 : Float, X2 : Float, Y2 : Float) {
        r = RectF(X1, Y1, X2, Y2)
        canvas.drawRect(r, couleur)
        if (libre == false){
            occupant?.draw(canvas, X1, Y1, X2, Y2, context)
        }
    }
}