package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class cavalier(nom : String, position : case, couleur : String): pièce(nom, position, couleur){
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (nouvelleposition.ordonnee == position.ordonnee + 2 || nouvelleposition.ordonnee == position.ordonnee - 2){
            if (nouvelleposition.absysse == position.absysse + 1 || nouvelleposition.absysse == position.absysse - 1){
                if (nouvelleposition.occupant?.couleur == couleur){
                    return false
                }
                else {
                    super.deplacement(nouvelleposition, liste_de_case)
                    return true
                }
            }
            else {
                println("Le cavalier doit se déplacer en L")
                return false
            }
        }
        else if (nouvelleposition.ordonnee == position.ordonnee - 1 || nouvelleposition.ordonnee == position.ordonnee + 1){
            if (nouvelleposition.absysse == position.absysse - 2 || nouvelleposition.absysse == position.absysse + 2){
                if (nouvelleposition.occupant?.couleur == couleur){
                    return false
                }
                else {
                    super.deplacement(nouvelleposition, liste_de_case)
                    return true
                }
            }
            else {
                println("Le cavalier doit se déplacer en L")
                return false
            }
        }
        else {
            println("Le cavalier doit se déplacer en L")
            return false
        }
    }

    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 50, Y1 - 20, X2 - 50, Y2 + 20)
        val r3 = RectF(X1 + 55, Y2 + 25, X1 + 100, Y2 + 70)
        val r4 = RectF(X1 + 75, Y2 + 25, X1 + 120, Y2 + 70)
        if (this.couleur == "blanc"){
            paint.color = Color.WHITE
        }
        else {
            paint.color = Color.BLACK
        }
        canvas.drawRect(r2, paint)
        canvas.drawOval(r3, paint)
        canvas.drawOval(r4, paint)
    }

    override fun deplacement2(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (nouvelleposition.ordonnee == position.ordonnee + 2 || nouvelleposition.ordonnee == position.ordonnee - 2){
            if (nouvelleposition.absysse == position.absysse + 1 || nouvelleposition.absysse == position.absysse - 1){
                if (nouvelleposition.occupant?.couleur == couleur){
                    return false
                }
                else {
                    return true
                }
            }
            else {
                println("Le cavalier doit se déplacer en L")
                return false
            }
        }
        else if (nouvelleposition.ordonnee == position.ordonnee - 1 || nouvelleposition.ordonnee == position.ordonnee + 1){
            if (nouvelleposition.absysse == position.absysse - 2 || nouvelleposition.absysse == position.absysse + 2){
                if (nouvelleposition.occupant?.couleur == couleur){
                    return false
                }
                else {
                    return true
                }
            }
            else {
                println("Le cavalier doit se déplacer en L")
                return false
            }
        }
        else {
            println("Le cavalier doit se déplacer en L")
            return false
        }
    }

}