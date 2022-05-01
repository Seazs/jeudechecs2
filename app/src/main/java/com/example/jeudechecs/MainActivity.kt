package com.example.jeudechecs

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


public class MainActivity : Activity() {
    init{
        setleContext(this);
        setactivite(this)
    }
    lateinit var drawingView: DrawingView
    var joueur1 : String? = null
    var joueur2 : String? = null
    companion object {

        lateinit var context: Context
        lateinit var mainActivity: MainActivity
        fun setleContext(con: Context) {
            context = con
        }
        fun setactivite(activity: MainActivity){
            mainActivity = activity
        }
    }



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById<DrawingView>(R.id.vMain)

        val intent : Intent = intent
        if(intent.hasExtra("joueur1") && intent.hasExtra("joueur2")){
            joueur1 = intent.getStringExtra("joueur1")
            joueur2 = intent.getStringExtra("joueur2")
        }
        affichage_joueur1.text = joueur1
        affichage_joueur2.text = joueur2
        //val joueurs : ArrayList<String> = Intent.getString("joueurs")

    }



    override fun onPause() {
        super.onPause()
        drawingView.pause()

    }

    override fun onResume() {
        super.onResume()
        drawingView.resume()
    }

}