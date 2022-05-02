package com.example.jeudechecs

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*


public class MainActivity : Activity() {
    init {
        setleContext(this)
        setactivite(this)
    }

    lateinit var drawingView: DrawingView
    var nomjoueur1: String? = null
    var nomjoueur2: String? = null
    lateinit var joueur1: Joueur
    lateinit var joueur2: Joueur

    companion object {

        lateinit var context: Context
        lateinit var mainActivity: MainActivity
        fun setleContext(con: Context) {
            context = con
        }

        fun setactivite(activity: MainActivity) {
            mainActivity = activity
        }
    }

    lateinit var myHandler : Handler
    private var myRunnable: Runnable = object : Runnable {
        //@SuppressLint("SetTextI18n")
        override fun run() {
            // Code à éxécuter de façon périodique
            affichage_joueur1.text = joueur1.nom + " " + joueur1.score
            affichage_joueur2.text = joueur2.nom + " " + joueur2.score
            myHandler!!.postDelayed(this, 100)

        }
    }
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById<DrawingView>(R.id.vMain)
        myHandler = Handler()
        myHandler.postDelayed(myRunnable,100)

        val intent: Intent = intent
        if (intent.hasExtra("joueur1") && intent.hasExtra("joueur2")) {
            nomjoueur1 = intent.getStringExtra("joueur1")
            nomjoueur2 = intent.getStringExtra("joueur2")
        }
        joueur1 = Joueur(nomjoueur1, 0)
        joueur2 = Joueur(nomjoueur2, 0)

        drawingView.jou1 = joueur1
        drawingView.jou2 = joueur2
    }
    override fun onPause() {
        super.onPause()
        drawingView.pause()
        myHandler?.removeCallbacks(myRunnable)
    }

    override fun onResume() {
        super.onResume()
        drawingView.resume()
    }
}