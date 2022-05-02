package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class objpeinture(nom : String, position : casier, couleur : String): objet(nom, position, couleur){
    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
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