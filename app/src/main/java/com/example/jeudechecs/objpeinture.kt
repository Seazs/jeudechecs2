package com.example.jeudechecs

import android.content.Context
import android.graphics.*

class objpeinture(nom : String, position : casier, couleur : String): objet(nom, position, couleur){
    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float, context: Context){
        val r = RectF(X1 +10, Y2+10, X2-10, Y1-10)
        val bitmap: Bitmap
        if (this.couleur == "blanc"){
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pinceau)
        }
        else {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pinceau)
        }
        canvas.drawBitmap(bitmap, null, r, null)
    }
}