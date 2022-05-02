package com.example.jeudechecs

import android.content.Context
import android.graphics.*

class cavalier(nom : String, position : case, couleur : String, joueur: Joueur): pièce(nom, position, couleur, joueur){
    override var point = 3
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>, virtuel : Boolean): Boolean{
        if (nouvelleposition.ordonnee == position.ordonnee + 2 || nouvelleposition.ordonnee == position.ordonnee - 2){
            if (nouvelleposition.absysse == position.absysse + 1 || nouvelleposition.absysse == position.absysse - 1){
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
        }
        else if (nouvelleposition.ordonnee == position.ordonnee - 1 || nouvelleposition.ordonnee == position.ordonnee + 1){
            if (nouvelleposition.absysse == position.absysse - 2 || nouvelleposition.absysse == position.absysse + 2){
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
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.cheval_b)
        }
        else {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.cheval_n)
        }
        canvas.drawBitmap(bitmap, null, r, null)
    }
}