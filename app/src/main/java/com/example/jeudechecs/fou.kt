package com.example.jeudechecs

import android.content.Context
import android.graphics.*

class fou(nom : String, position : case, couleur : String, joueur: Joueur): pièce(nom, position, couleur, joueur){
    override var point = 3
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>, virtuel: Boolean): Boolean{
        if (position.ordonnee-nouvelleposition.ordonnee == position.absysse-nouvelleposition.absysse){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][i-nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    return false
                }
            }
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else if (nouvelleposition.occupant?.nom != "piecetrou"){
                if (virtuel == false){
                    super.deplacement(nouvelleposition, liste_de_case, virtuel)
                }
                return true
            }
        }
        else if (position.ordonnee-nouvelleposition.ordonnee == -(position.absysse-nouvelleposition.absysse)){
            for (i in minOf(position.absysse, nouvelleposition.absysse)+1..maxOf(position.absysse, nouvelleposition.absysse)-1){
                if (liste_de_case[i][-i+nouvelleposition.absysse+nouvelleposition.ordonnee].libre == false){
                    return false
                }
            }
            if (nouvelleposition.occupant?.couleur == couleur){
                return false
            }
            else if (nouvelleposition.occupant?.nom != "piecetrou"){
                if (virtuel == false){
                    super.deplacement(nouvelleposition, liste_de_case, virtuel)
                }
                return true
            }
        }
        else {
            return false
        }
        return false
    }

    override fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context){
        val r = RectF(X1 - 20, Y2, X2, Y1)
        var bitmap: Bitmap

        if (this.couleur == "blanc"){
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.fou_b)
        }
        else {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.fou_n)
        }
        canvas.drawBitmap(bitmap, null, r, null)
    }
}