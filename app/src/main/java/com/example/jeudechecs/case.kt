package com.example.jeudechecs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class case(val nom : String, val absysse : Int, val ordonnee : Int, var libre : Boolean, var occupant : pièce?, var couleur: Paint): objetpiece{

    lateinit var r : RectF

    fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context) {
        r = RectF(X1, Y1, X2, Y2)
        canvas.drawRect(r, couleur)
        if (libre == false){
            occupant?.draw(canvas, X1, Y1, X2, Y2, context)
        }
    }

    fun vraicouleur(){
        val paint1 = Paint()
        paint1.color = Color.GRAY
        val paint2 = Paint()
        paint2.color = Color.LTGRAY
        if (occupant?.nom != "piecetrou"){
            if ((absysse+ordonnee)%2==0){
                couleur = paint1
            }
            else if((absysse+ordonnee)%2!=0){
                couleur = paint2
            }
        }
    }

    fun pionendame(joueur: Joueur){
        if (occupant?.nom == "pion"){
            if (ordonnee == 7 && occupant?.couleur == "blanc"){
                occupant = reine("reine", this,"blanc", joueur)
            }
            else if (ordonnee == 0 && occupant?.couleur == "noir"){
                occupant = reine("reine", this, "noir", joueur)
            }
        }
    }
}