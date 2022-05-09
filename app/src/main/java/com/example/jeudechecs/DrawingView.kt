package com.example.jeudechecs

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.core.content.ContextCompat

class DrawingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0, joueur1: Joueur = Joueur("", 0), joueur2: Joueur = Joueur("", 0)): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {

    var jou1 : Joueur = joueur1
    var jou2 : Joueur = joueur2
    lateinit var param_joueur : Joueur
    lateinit var canvas: Canvas
    lateinit var thread: Thread
    val backgroundPaint = Paint()
    var drawing: Boolean = true
    lateinit var plateau1 : plateau
    lateinit var liste_de_case : MutableList<MutableList<case>>
    var case_selec : case? = null
    val selecpaint = Paint()
    var ancientpaint = Paint()
    val truepaint1 = Paint()
    val truepaint2 = Paint()
    var couleur_de_jeu : String = "blanc"
    val couleur_text = Paint()
    lateinit var inventaire1: inventaire
    lateinit var liste_de_casier1 : MutableList<casier>
    lateinit var inventaire2: inventaire
    lateinit var liste_de_casier2 : MutableList<casier>
    var casier_selec : casier? = null
    var ancientpaintcasier = Paint()
    var timeLeft1 = 600000.0
    var timeLeft2 = 600000.0
    var previousFrameTime = System.currentTimeMillis()


    init {
        backgroundPaint.color = Color.WHITE
        selecpaint.color = Color.RED
        truepaint1.color = Color.rgb(168, 50, 50)
        truepaint2.color = Color.rgb(245, 66, 66)
        couleur_text.color = Color.BLACK
        couleur_text.textSize = 50F

    }


    override fun onSizeChanged(w: Int,h: Int,oldw: Int,oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val canvasW = (w).toFloat()
        //val canvasH = (h).toFloat()
        plateau1 = plateau(8, 8, 0f, 0f + 340f, canvasW, canvasW + 340f, jou1, jou2)
        liste_de_case = plateau1.creer_liste_de_case()
        inventaire1 = inventaire(3, 340f, 280f, 730f, 410f, "noir")
        liste_de_casier1 = inventaire1.creer_liste_de_casier()
        inventaire2 = inventaire(3, 340f, 1670f, 730f, 1800f, "blanc")
        liste_de_casier2 = inventaire2.creer_liste_de_casier()
    }

    fun pause() {
        drawing = false
        thread.join()
    }
    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()

    }

    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0F, 0F, canvas.getWidth()*1F,
                canvas.getHeight()*1F, backgroundPaint)
            plateau1.draw(canvas, liste_de_case, context)
            inventaire1.draw(canvas, liste_de_casier1)
            inventaire2.draw(canvas, liste_de_casier2)
            val secondsLeft1 = ((timeLeft1/1000) % 60).toInt()
            val minutesLeft1 = ((timeLeft1/1000) / 60).toInt()
            val secondsLeft2 = ((timeLeft2/1000) % 60).toInt()
            val minutesLeft2 = ((timeLeft2/1000) / 60).toInt()
            canvas.drawText("CHRONO :", 750F, 1570F, couleur_text)
            canvas.drawText("CHRONO :", 750F, 180F, couleur_text)
            canvas.drawText("$minutesLeft1 : $secondsLeft1 ", 750f, 1640f, couleur_text)
            canvas.drawText("$minutesLeft2 : $secondsLeft2", 750f, 250f, couleur_text)

            holder.unlockCanvasAndPost(canvas)

        }
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                val x = e.rawX.toInt() - 0
                val y = e.rawY.toInt() - 100
                if (case_selec == null && casier_selec == null){
                    for (i in liste_de_case){
                        for (j in i){
                            if (j.r.top > y && j.r.bottom < y){
                                if (j.r.left < x && j.r.right > x){
                                    if (j.libre == false && j.occupant?.couleur == couleur_de_jeu) {
                                        case_selec = j
                                        casier_selec = null
                                        ancientpaint = j.couleur
                                        j.couleur = selecpaint
                                        for (k in liste_de_case){
                                            for (l in k){
                                                if (case_selec?.occupant?.deplacement(l, liste_de_case, true) == true){
                                                    if ((l.absysse+l.ordonnee)%2==0){
                                                        l.couleur = truepaint1
                                                    }
                                                    else {
                                                        l.couleur = truepaint2
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (case_selec == null){
                        for (m in liste_de_casier1 + liste_de_casier2){
                            if (m.r.top > y && m.r.bottom < y){
                                if (m.r.left < x && m.r.right > x){
                                    if (m.libre == false && m.occupant?.couleur == couleur_de_jeu) {
                                        casier_selec = m
                                        ancientpaintcasier = m.couleur
                                        m.couleur = selecpaint
                                    }
                                }
                            }
                        }
                    }
                }
                else if (case_selec != null){
                    for (i in liste_de_case){
                        for (j in i){
                            j.vraicouleur()
                            if (j.r.top > y && j.r.bottom < y){
                                if (j.r.left < x && j.r.right > x){
                                    if (case_selec?.occupant?.deplacement(j, liste_de_case, false) == true){
                                        if (couleur_de_jeu == "blanc"){
                                            couleur_de_jeu = "noir"
                                        }
                                        else if (couleur_de_jeu == "noir"){
                                            couleur_de_jeu = "blanc"
                                        }
                                    }
                                    case_selec?.occupant?.deplacement(j, liste_de_case, false)
                                    case_selec?.couleur = ancientpaint
                                    case_selec = null
                                    for (n in 0..7){
                                        liste_de_case[n][0].pionendame(jou1)
                                        liste_de_case[n][7].pionendame(jou2)
                                    }
                                }
                            }
                        }
                    }
                }
                else if (casier_selec != null){
                    for (i in liste_de_case){
                        for (j in i){
                            if (j.r.top > y && j.r.bottom < y){
                                if (j.r.left < x && j.r.right > x){
                                    if (couleur_de_jeu == "blanc"){
                                        param_joueur = jou1
                                    }else{
                                        param_joueur = jou2
                                    }
                                    if (casier_selec?.pionencavalier(j, casier_selec, couleur_de_jeu) == true ||
                                        casier_selec?.trou(j, casier_selec, couleur_de_jeu) == true ||
                                        casier_selec?.peinture(j, casier_selec!!, couleur_de_jeu, param_joueur) == true){
                                        casier_selec?.occupant = null
                                        if (couleur_de_jeu == "blanc"){
                                            couleur_de_jeu = "noir"
                                        }
                                        else if (couleur_de_jeu == "noir"){
                                            couleur_de_jeu = "blanc"
                                        }
                                    }
                                    casier_selec?.couleur = ancientpaintcasier
                                    casier_selec = null

                                }
                            }
                        }
                    }
                }
            }
        }
        return true
    }

    fun updatetemps(elapsedTimeMS: Double) {
        if (couleur_de_jeu == "blanc"){
            timeLeft1 -= elapsedTimeMS
        } else {
            timeLeft2 -= elapsedTimeMS
        }
        if (timeLeft1 <= 0.0) {
            timeLeft1 = 0.0
            val monIntent : Intent = Intent(MainActivity.context, ecran_final::class.java)
                .putExtra("score_gagnant", jou1.score)
                .putExtra("joueur_gagnant", jou1.nom)
            ContextCompat.startActivity(MainActivity.context, monIntent, null)
            MainActivity.mainActivity.finish()
            drawing = false
        }
        else if (timeLeft2 <= 0.0) {
            timeLeft2 = 0.0
            val monIntent : Intent = Intent(MainActivity.context, ecran_final::class.java)
                .putExtra("score_gagnant", jou2.score)
                .putExtra("joueur_gagnant", jou2.nom)
            ContextCompat.startActivity(MainActivity.context, monIntent, null)
            MainActivity.mainActivity.finish()
            drawing = false
        }
    }

    override fun run() {
        while (drawing) {
            val currentTime = System.currentTimeMillis()
            var elapsedTimeMS:Double = (currentTime-previousFrameTime).toDouble()
            previousFrameTime = currentTime
            updatetemps(elapsedTimeMS)
            draw()
        }
    }

    override fun surfaceChanged(
        holder: SurfaceHolder, format: Int,
        width: Int, height: Int) {
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        thread = Thread(this)
        thread.start()
    }
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        thread.join()
    }

}