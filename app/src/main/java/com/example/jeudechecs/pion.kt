package com.example.jeudechecs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.RectF

class pion(nom : String, position : case, couleur : String, var first_step : Boolean, joueur: Joueur): pièce(nom, position, couleur, joueur){
    override var point = 1
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>, virtuel : Boolean): Boolean{
        var direction = 1
        if (couleur == "noir") direction = -1
        if (nouvelleposition.ordonnee == position.ordonnee + (2 * direction)){
            if (liste_de_case[position.absysse][position.ordonnee + direction].libre == true && liste_de_case[position.absysse][position.ordonnee + 2 * direction].libre == true){
                if (nouvelleposition.absysse == position.absysse){
                    if (couleur == "blanc" && position.ordonnee == 1 || couleur == "noir" && position.ordonnee==6){
                        if (nouvelleposition.occupant?.couleur == couleur){
                            return false
                        }
                        else if (nouvelleposition.occupant?.nom != "piecetrou"){
                            first_step = false
                            if (virtuel == false){
                                super.deplacement(nouvelleposition, liste_de_case, virtuel)
                            }
                            return true
                        }
                    }
                    else {
                        return false
                    }
                }else{
                    return false
                }
            }
            return false
        }
        else if (nouvelleposition.ordonnee == position.ordonnee + direction){
            if (nouvelleposition.absysse == position.absysse){
                if (nouvelleposition.libre == true){
                    first_step = false
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
            else if (nouvelleposition.absysse == position.absysse - 1 || nouvelleposition.absysse == position.absysse + 1){
                if (nouvelleposition.libre == false){
                    if (nouvelleposition.occupant?.couleur != couleur){
                        first_step = false
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
            }
        }
        else {
            return false
        }
        return false
    }
    override fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context){
        val r = RectF(X1 - 70, Y2, X2, Y1)
        val bitmap: Bitmap
        if (this.couleur == "blanc"){
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pion_b)
        }
        else {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pion_n)
        }
        canvas.drawBitmap(bitmap, null, r, null)

    }
}