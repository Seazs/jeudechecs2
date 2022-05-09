package com.example.jeudechecs

import android.content.Context
import android.graphics.*

class objcheval(nom : String, position : casier, couleur : String): objet(nom, position, couleur){

    override fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context){
        val r = RectF(X1 -30 , Y2, X2, Y1)
        var bitmap: Bitmap

        if (this.couleur == "blanc"){
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.cheval_b)
        }
        else {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.cheval_n)
        }
        canvas.drawBitmap(bitmap, null, r, null)
    }
}
