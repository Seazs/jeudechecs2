package com.example.jeudechecs

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class inventaire(val largeur : Int, val x1: Float, val y1: Float, val x2: Float, val y2: Float, val couleur: String){
    fun creer_liste_de_casier(): MutableList<casier>{
        val liste_de_casier: MutableList<casier> = mutableListOf()
        val paint1 = Paint()
        paint1.color = Color.rgb(125, 132, 189)
        val paint2 = Paint()
        paint2.color = Color.rgb(106, 118, 226)
        for (j in 0..largeur-1){
            if ((j)%2==0){
                val lecasier : casier = casier("casier(${j})", j, true, null, paint1)
                liste_de_casier.add(lecasier)
            }
            else if ((j)%2==1){
                val lecasier : casier = casier("casier(${j})", j, true, null, paint2)
                liste_de_casier.add(lecasier)
            }
        }
        for (i in 0..largeur-1){
            if (i == 0){
                liste_de_casier[i].occupant = objcheval("objcheval", liste_de_casier[i],couleur)
            }
            else if (i == 1){
                liste_de_casier[i].occupant = objtrou("objtrou", liste_de_casier[i],couleur)
            }
            else if (i == 2){
                liste_de_casier[i].occupant = objpeinture("objpeinture", liste_de_casier[i], couleur)
            }
        }
        return liste_de_casier
    }

    fun draw (canvas: Canvas, liste_de_casier: MutableList<casier>){
        val largeur_case = (x2 - x1)/largeur
        val hauteur_case = (y1 - y2)
        for (x in 0..largeur-1){
            liste_de_casier[x].draw(
                canvas,
                x1 + x * largeur_case,
                y1,
                x1 + (x + 1) * largeur_case,
                y1 + 1 * hauteur_case
            )
        }
    }
}