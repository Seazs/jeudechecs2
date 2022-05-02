package com.example.jeudechecs

import android.graphics.Color
import android.graphics.Paint

interface objetpiece {
    fun pionencavalier(casepion: case, casierobjet : casier?, couleur : String): Boolean{
        if (casierobjet?.occupant?.nom =="objcheval" && casepion.occupant?.nom == "pion" && casepion.occupant?.couleur == couleur){
            casepion.occupant = cavalier("pion chevalisé", casepion, couleur, casepion.occupant?.joueur!!)
            return true
        }
        else{
            return false
        }
    }
    fun trou(casepion: case, casierobjet : casier?, couleur : String): Boolean{
        val paint = Paint()
        paint.color = Color.BLACK
        if (casierobjet?.occupant?.nom =="objtrou" && casepion.libre == true){
            casepion.couleur = paint
            casepion.occupant = piecetrou("piecetrou", casepion, "hihihi", Joueur("", 0))
            return true
        }
        else{
            return false
        }
    }
    fun peinture(casepion: case, casierobjet : casier, couleur : String, joueur: Joueur): Boolean{
        if (casierobjet.occupant?.nom =="objpeinture" && casepion.occupant?.nom == "pion"){
            if (casepion.occupant?.couleur != casierobjet.occupant?.couleur){
                if (casepion.occupant?.couleur == "noir"){
                    casepion.occupant = pion("pion", casepion, "blanc", false, joueur)
                }
                else if (casepion.occupant?.couleur == "blanc"){
                    casepion.occupant = pion("pion", casepion, "noir", false, joueur)
                }
                return true
            }
        }
        return false
    }
}