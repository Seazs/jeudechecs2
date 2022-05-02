package com.example.jeudechecs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class piecetrou(nom : String, position : case, couleur : String, joueur: Joueur): pièce(nom, position, couleur, joueur){
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>, virtuel : Boolean): Boolean{
        return false
    }
    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float, context: Context){
        val r2 = RectF(X1 + 30, Y1 - 30, X2 - 30, Y2 + 30)
        paint.color = Color.BLACK
        canvas.drawRect(r2, paint)
    }
}