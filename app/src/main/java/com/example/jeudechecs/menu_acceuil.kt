package com.example.jeudechecs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_menu_acceuil.*

class menu_acceuil : AppCompatActivity(){
    lateinit var joueur1 : String
    lateinit var joueur2 : String

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var boutonPartie: Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_acceuil)

        //boutonPartie = findViewById(this.Partie.id)
        Partie.setOnClickListener {
            attribuer_joueur()
            lancer_partie()
        }
    }
    fun attribuer_joueur(){
        joueur1 = text_joueur1.text.toString()
        joueur2 = text_joueur2.text.toString()
    }
    fun lancer_partie(){
        val myIntent : Intent = Intent(this , MainActivity::class.java).putExtra("joueur1", joueur1).putExtra("joueur2", joueur2)
        startActivity(myIntent)
        finish()
    }
}

