package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class roi(nom : String, position : case, couleur : String): pièce(nom, position, couleur){
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (position.absysse-nouvelleposition.absysse < -1 || position.absysse-nouvelleposition.absysse > 1){
            println("Le roi ne se déplace pas ainsi")
            return false
        }
        else if (position.ordonnee-nouvelleposition.ordonnee < -1 || position.ordonnee-nouvelleposition.ordonnee > 1){
            println("Le roi ne se déplace pas ainsi")
            return false
        }
        else {
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else {
                super.deplacement(nouvelleposition, liste_de_case)
                return true
            }
        }
    }

    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 20, Y1 - 20, X2 - 20, Y2 + 20)
        val r3 = RectF(X1 + 25, Y1 - 25, X2 - 25, Y2 + 25)
        if (this.couleur == "blanc"){
            paint.color = Color.WHITE
        }
        else {
            paint.color = Color.BLACK
        }
        canvas.drawOval(r2, paint)
        canvas.drawRect(r3, paint)
    }

    override fun deplacement2(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (position.absysse-nouvelleposition.absysse < -1 || position.absysse-nouvelleposition.absysse > 1){
            println("Le roi ne se déplace pas ainsi")
            return false
        }
        else if (position.ordonnee-nouvelleposition.ordonnee < -1 || position.ordonnee-nouvelleposition.ordonnee > 1){
            println("Le roi ne se déplace pas ainsi")
            return false
        }
        else {
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else {
                return true
            }
        }
    }
}