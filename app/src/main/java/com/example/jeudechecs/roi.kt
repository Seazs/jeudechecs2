package com.example.jeudechecs

import android.content.Context
import android.graphics.*

class roi(nom : String, position : case, couleur : String, joueur: Joueur): pièce(nom, position, couleur,joueur){
    override var point = 0
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>, virtuel : Boolean): Boolean{
        if (position.absysse-nouvelleposition.absysse < -1 || position.absysse-nouvelleposition.absysse > 1){
            return false
        }
        else if (position.ordonnee-nouvelleposition.ordonnee < -1 || position.ordonnee-nouvelleposition.ordonnee > 1){
            return false
        }
        else {
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
        return false
    }

    override fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context){
        val r = RectF(X1, Y2, X2, Y1)
        var bitmap: Bitmap

        if (this.couleur == "blanc"){
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.roi_b)
        }
        else {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.roi_n)
        }
        canvas.drawBitmap(bitmap, null, r, null)
    }
}