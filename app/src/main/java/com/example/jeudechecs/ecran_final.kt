package com.example.jeudechecs

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ecran_final.*
import kotlin.concurrent.timerTask

class ecran_final : AppCompatActivity() {
    var score_gagnant: Int? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecran_final)
        timerTask { println("ici") }
        val intent: Intent = intent
        val score_gagnant = intent.getIntExtra("score_gagnant", 0).toString()
        val joueur_gagnant = intent.getStringExtra("joueur_gagnant")
        score.text = "score du joueur: $joueur_gagnant = $score_gagnant"
        retour_acceuil.setOnClickListener{
            val myintent: Intent = Intent(this, menu_acceuil::class.java)
            startActivity(myintent)
        }
    }
}