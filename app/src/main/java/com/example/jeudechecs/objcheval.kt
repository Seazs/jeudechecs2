package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class objcheval(nom : String, position : casier, couleur : String): objet(nom, position, couleur){
    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 50, Y1 - 20, X2 - 50, Y2 + 20)
        val r3 = RectF(X1 + 55, Y2 + 25, X1 + 100, Y2 + 70)
        val r4 = RectF(X1 + 75, Y2 + 25, X1 + 120, Y2 + 70)
        paint.color = Color.rgb(100, 100, 100)
        canvas.drawRect(r2, paint)
        canvas.drawOval(r3, paint)
        canvas.drawOval(r4, paint)
    }
}