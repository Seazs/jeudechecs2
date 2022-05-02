package com.example.jeudechecs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class plateau(val longueur : Int, val largeur : Int, val x1: Float, val y1: Float, val x2: Float, val y2: Float, joueur1 : Joueur, joueur2 : Joueur){
    var joueur1 = joueur1
    var joueur2 = joueur2

    fun creer_liste_de_case(): MutableList<MutableList<case>>{
        val liste_de_case: MutableList<MutableList<case>> = mutableListOf()
        val paint1 = Paint()
        paint1.color = Color.GRAY
        val paint2 = Paint()
        paint2.color = Color.LTGRAY
        for (j in 0..longueur-1){
            liste_de_case.add(mutableListOf())
            for (i in 0..largeur-1){
                if ((i+j)%2==0){
                    val lacase : case = case("case(${j},${i})", j, i, true, null, paint1)
                    liste_de_case[j].add(lacase)
                }
                else if ((i+j)%2==1){
                    val lacase : case = case("case(${j},${i})", j, i, true, null, paint2)
                    liste_de_case[j].add(lacase)
                }

            }
        }
        for (i in 0..largeur-1){
            liste_de_case[i][1].occupant = pion("pion", liste_de_case[i][1],"blanc", true,joueur1)
            liste_de_case[i][6].occupant = pion("pion", liste_de_case[i][6],"noir", true, joueur2)
            if (i==1 || i==6){
                liste_de_case[i][0].occupant = cavalier("cavalier", liste_de_case[i][0], "blanc", joueur1)
                liste_de_case[i][7].occupant = cavalier("cavalier", liste_de_case[i][7], "noir",joueur2)
            }
            if (i==0 || i==7){
                liste_de_case[i][0].occupant = tour("tour", liste_de_case[i][0], "blanc",joueur1)
                liste_de_case[i][7].occupant = tour("tour", liste_de_case[i][7], "noir",joueur2)
            }
            if (i==2 || i==5){
                liste_de_case[i][0].occupant = fou("fou", liste_de_case[i][0], "blanc",joueur1)
                liste_de_case[i][7].occupant = fou("fou", liste_de_case[i][7], "noir",joueur2)
            }
            if (i==3){
                liste_de_case[i][0].occupant = reine("reine", liste_de_case[i][0], "blanc",joueur1)
                liste_de_case[i][7].occupant = reine("reine", liste_de_case[i][7], "noir",joueur2)
            }
            if (i==4){
                liste_de_case[i][7].occupant = roi("roi", liste_de_case[i][7], "noir",joueur1)
                liste_de_case[i][0].occupant = roi("roi", liste_de_case[i][0], "blanc",joueur2)
            }
        }
        return liste_de_case
    }
    fun draw (canvas: Canvas, liste_de_case: MutableList<MutableList<case>>, context: Context){
        val largeur_case = (x2 - x1)/largeur
        val hauteur_case = (y1 - y2)/longueur
        for (x in 0..largeur-1){
            for (y in 0..longueur-1) {
                liste_de_case[x][y].draw(
                    canvas,
                    x1 + x * largeur_case,
                    y1 + (y - longueur) * hauteur_case,
                    x1 + (x + 1) * largeur_case,
                    y1 + (y - longueur + 1) * hauteur_case,
                    context
                )
            }
        }
    }
}