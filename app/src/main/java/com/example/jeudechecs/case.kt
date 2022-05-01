package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class case(val nom : String, val absysse : Int, val ordonnee : Int, var libre : Boolean, var occupant : pièce?, var couleur: Paint){

    lateinit var r : RectF

    fun draw(canvas: Canvas, X1: Float, Y1 : Float, X2 : Float, Y2 : Float) {
        r = RectF(X1, Y1, X2, Y2)
        canvas.drawRect(r, couleur)
        if (libre == false){
            occupant?.draw(canvas, X1, Y1, X2, Y2)
        }
    }

    fun vraicouleur(){
        val paint1 = Paint()
        paint1.color = Color.GRAY
        val paint2 = Paint()
        paint2.color = Color.LTGRAY
        if ((absysse+ordonnee)%2==0){
            couleur = paint1
        }
        else {
            couleur = paint2
        }
    }
}