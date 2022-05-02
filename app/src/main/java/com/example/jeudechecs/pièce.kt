package com.example.jeudechecs
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.media.AudioManager
import android.media.SoundPool
import androidx.core.content.ContextCompat.startActivity


open class pièce(val nom : String, var position: case, val couleur : String, joueur : Joueur){

    open var point: Int =0
    var joueur = joueur
    val paint = Paint()
    val soundPool : SoundPool = SoundPool(2, AudioManager.STREAM_MUSIC, 0 )
    val leson : Int = soundPool.load(MainActivity.Companion.context, R.raw.deplacement, 1)





    init {
        position.occupant = this
        position.libre = false
    }
    open fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>, virtuel : Boolean): Boolean{
        if (nouvelleposition.libre == true){
            position.libre = true
            position.occupant = null
            soundPool.play(leson, 1F, 1F, 1, 0, 1F)
            position = nouvelleposition
            position.libre = false
            position.occupant = this
            return true
        }
        else if (nouvelleposition.occupant?.couleur != couleur){
            position.libre = true
            position.occupant?.joueur?.score = position.occupant?.joueur?.score?.plus(nouvelleposition.occupant?.point!!)!!
            position.occupant = null
            soundPool.play(leson, 1F, 1F, 1, 0, 1F)
            if (nouvelleposition.occupant?.nom =="roi"){
                val monIntent : Intent = Intent(MainActivity.Companion.context, ecran_final::class.java)
                    .putExtra("score_gagnant", joueur.score)
                    .putExtra("joueur_gagnant", joueur.nom)
                startActivity(MainActivity.Companion.context, monIntent, null)
                MainActivity.mainActivity.finish()
            }
            position = nouvelleposition
            position.libre = false
            position.occupant = this
            return true
        }
        else {
            return false
        }
    }

    open fun draw(canvas: Canvas, X1: Float, Y1: Float, X2: Float, Y2: Float, context: Context){
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
