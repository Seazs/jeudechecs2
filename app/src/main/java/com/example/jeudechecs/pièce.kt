package com.example.jeudechecs

import android.app.Activity
import android.app.Application
import android.content.Context

import android.content.ContextWrapper
import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.media.AudioManager
import android.media.SoundPool
import android.view.PointerIcon.load
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.time.Month
import java.util.logging.Logger.global


import kotlin.coroutines.coroutineContext


open class pièce(val nom : String, var position: case, val couleur : String){

    val paint = Paint()
    val soundPool : SoundPool = SoundPool(2, AudioManager.STREAM_MUSIC, 0 )
    val leson : Int = soundPool.load(MainActivity.Companion.context, R.raw.deplacement, 1)
    val monIntent : Intent = Intent(MainActivity.Companion.context, ecran_final::class.java)


    init {
        position.occupant = this
        position.libre = false
    }
    open fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        if (nouvelleposition.libre == true){
            position.libre = true
            position.occupant = null
            println("$nom $couleur va de la ${position.nom} à la ${nouvelleposition.nom}")
            soundPool.play(leson, 1F, 1F, 1, 0, 1F)
            position = nouvelleposition

            position.libre = false
            position.occupant = this

            return true
        }
        else if (nouvelleposition.occupant?.couleur != couleur){
            position.libre = true
            println("prise du ${nouvelleposition.occupant?.nom} ${nouvelleposition.occupant?.couleur} par le ${position.occupant?.nom} ${position.occupant?.couleur}!")
            position.occupant = null
            soundPool.play(leson, 1F, 1F, 1, 0, 1F)
            if (nouvelleposition.occupant?.nom =="roi"){
                startActivity(MainActivity.Companion.context, monIntent, null)
                //MainActivity.mainActivity.finish()


            }
            //mainActivity.jouerSon()
            position = nouvelleposition
            position.libre = false
            position.occupant = this
            return true
        }
        else {
            return false
        }
    }

    open fun deplacement2(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        deplacement(nouvelleposition, liste_de_case)
        return true
    }

    open fun draw(canvas: Canvas, X1:Float, Y1:Float, X2:Float, Y2:Float){
        val r2 = RectF(X1 + 30, Y1 - 30, X2 - 30, Y2 + 30)
        if (this.couleur == "blanc"){
            paint.color = Color.WHITE
        }
        else {
            paint.color = Color.BLACK
        }
        canvas.drawOval(r2, paint)
    }
}
