package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

class reine(nom : String, position : case, couleur : String): pièce(nom, position, couleur){
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (position.ordonnee-nouvelleposition.ordonnee == position.absysse-nouvelleposition.absysse){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    println("${liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].occupant?.nom} dans le passage")
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
                    println("${liste_de_case[i][-i+nouvelleposition.absysse+nouvelleposition.ordonnee].occupant?.nom} dans le passage")
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
        else if (nouvelleposition.ordonnee == position.ordonnee){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][position.ordonnee].libre == false){
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
        else if (nouvelleposition.absysse == position.absysse){
            for (i in minOf(position.ordonnee, nouvelleposition.ordonnee)+1..maxOf(position.ordonnee, nouvelleposition.ordonnee)-1){
                if (liste_de_case[position.absysse][i].libre == false){
                    println("${liste_de_case[position.absysse][i].occupant?.nom} dans le passage")
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
            println("La reine ne se déplace pas ainsi")
            return false
        }
    }

    override fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 20, Y1 - 20, X2 - 20, Y2 + 80)
        val r3 = RectF(X1 + 25, Y2 + 25, X1 + 50, Y2 + 50)
        val r4 = RectF(X2 - 25, Y2 + 25, X2 - 50, Y2 + 50)
        val r5 = RectF(X1 + 55, Y2 + 25, X1 + 80, Y2 + 50)
        if (this.couleur == "blanc"){
            paint.color = Color.WHITE
        }
        else {
            paint.color = Color.BLACK
        }
        canvas.drawRect(r2, paint)
        canvas.drawOval(r3, paint)
        canvas.drawOval(r4, paint)
        canvas.drawOval(r5, paint)
    }

    override fun deplacement2(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (position.ordonnee-nouvelleposition.ordonnee == position.absysse-nouvelleposition.absysse){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    println("${liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].occupant?.nom} dans le passage")
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
                    println("${liste_de_case[i][-i+nouvelleposition.absysse+nouvelleposition.ordonnee].occupant?.nom} dans le passage")
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
        else if (nouvelleposition.ordonnee == position.ordonnee){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][position.ordonnee].libre == false){
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
        else if (nouvelleposition.absysse == position.absysse){
            for (i in minOf(position.ordonnee, nouvelleposition.ordonnee)+1..maxOf(position.ordonnee, nouvelleposition.ordonnee)-1){
                if (liste_de_case[position.absysse][i].libre == false){
                    println("${liste_de_case[position.absysse][i].occupant?.nom} dans le passage")
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
            println("La reine ne se déplace pas ainsi")
            return false
        }
    }
}