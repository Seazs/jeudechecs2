package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class fou(nom : String, position : case, couleur : String): pièce(nom, position, couleur){
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (position.ordonnee-nouvelleposition.ordonnee == position.absysse-nouvelleposition.absysse){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    println("${liste_de_case[i][position.ordonnee].occupant?.nom} dans le passage")
                    return false
                }
            }
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else {
                super.deplacement(nouvelleposition, liste_de_case)
                return true
            }
        }
        else if (position.ordonnee-nouvelleposition.ordonnee == -(position.absysse-nouvelleposition.absysse)){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][-i+nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    println("${liste_de_case[i][position.ordonnee].occupant?.nom} dans le passage")
                    return false
                }
            }
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else {
                super.deplacement(nouvelleposition, liste_de_case)
                return true
            }
        }
        else {
            println("Le fou ne se déplace qu'en diagonale")
            return false
        }
    }

    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 20, Y1 - 20, X2 - 20, Y2 + 80)
        val r3 = RectF(X1 + 45, Y2 + 25, X1 + 90, Y2 + 70)
        if (this.couleur == "blanc"){
            paint.color = Color.WHITE
        }
        else {
            paint.color = Color.BLACK
        }
        canvas.drawOval(r2, paint)
        canvas.drawOval(r3, paint)
    }

    override fun deplacement2(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (position.ordonnee-nouvelleposition.ordonnee == position.absysse-nouvelleposition.absysse){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    println("${liste_de_case[i][position.ordonnee].occupant?.nom} dans le passage")
                    return false
                }
            }
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else {
                return true
            }
        }
        else if (position.ordonnee-nouvelleposition.ordonnee == -(position.absysse-nouvelleposition.absysse)){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][-i+nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    println("${liste_de_case[i][position.ordonnee].occupant?.nom} dans le passage")
                    return false
                }
            }
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else {
                return true
            }
        }
        else {
            println("Le fou ne se déplace qu'en diagonale")
            return false
        }
    }
}