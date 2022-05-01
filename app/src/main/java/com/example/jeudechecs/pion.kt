package com.example.jeudechecs

class pion(nom : String, position : case, couleur : String, var first_step : Boolean): pièce(nom, position, couleur){
    override fun deplacement(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        var direction = 1
        if (couleur == "noir") direction = -1
        if (nouvelleposition.ordonnee == position.ordonnee + (2 * direction)){
            if (liste_de_case[position.absysse][position.ordonnee + direction].libre == true){
                if (nouvelleposition.absysse == position.absysse){
                    if (couleur == "blanc" && position.ordonnee == 1 || couleur == "noir" && position.ordonnee==6){
                        if (nouvelleposition.occupant?.couleur == couleur){
                            return false
                        }
                        else {
                            first_step = false
                            super.deplacement(nouvelleposition, liste_de_case)
                            return true
                        }
                    }
                    else {
                        println("le $nom $couleur ne peut plus avancer de deux cases")
                        return false
                    }
                }else{
                    println("déplacement non autorisé")
                    return false
                }
            }
            else println("pièce dans le chemin")
            return false
        }
        else if (nouvelleposition.ordonnee == position.ordonnee + direction){
            if (nouvelleposition.absysse == position.absysse){
                if (nouvelleposition.libre == true){
                    first_step = false
                    if (nouvelleposition.occupant?.couleur == couleur){
                        return false
                    }
                    else {
                        super.deplacement(nouvelleposition, liste_de_case)
                        return true
                    }
                }
                else {
                    println("$nom $couleur est bloqué par le/la ${nouvelleposition.occupant?.nom} ${nouvelleposition.occupant?.couleur}")
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
                        else {
                            super.deplacement(nouvelleposition, liste_de_case)
                            return true
                        }
                    }
                    else {
                        println("tir allié interdit")
                        return false
                    }
                }
                else {
                    println("deplacement interdit car rien sur la ${nouvelleposition.nom}")
                    return false
                }
            }
        }
        else {
            println("déplacement non autorisé")
            return false
        }
        return false
    }

    override fun deplacement2(nouvelleposition : case, liste_de_case : MutableList<MutableList<case>>): Boolean{
        var direction = 1
        if (couleur == "noir") direction = -1
        if (nouvelleposition.ordonnee == position.ordonnee + (2 * direction)){
            if (liste_de_case[position.absysse][position.ordonnee + direction].libre == true){
                if (nouvelleposition.absysse == position.absysse){
                    if (couleur == "blanc" && position.ordonnee == 1 || couleur == "noir" && position.ordonnee==6){
                        if (nouvelleposition.occupant?.couleur == couleur){
                            return false
                        }
                        else {
                            first_step = false
                            return true
                        }
                    }
                    else {
                        println("le $nom $couleur ne peut plus avancer de deux cases")
                        return false
                    }
                }else{
                    println("déplacement non autorisé")
                    return false
                }
            }
            else println("pièce dans le chemin")
            return false
        }
        else if (nouvelleposition.ordonnee == position.ordonnee + direction){
            if (nouvelleposition.absysse == position.absysse){
                if (nouvelleposition.libre == true){
                    first_step = false
                    if (nouvelleposition.occupant?.couleur == couleur){
                        return false
                    }
                    else {
                        return true
                    }
                }
                else {
                    println("$nom $couleur est bloqué par le/la ${nouvelleposition.occupant?.nom} ${nouvelleposition.occupant?.couleur}")
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
                        else {
                            return true
                        }
                    }
                    else {
                        println("tir allié interdit")
                        return false
                    }
                }
                else {
                    println("deplacement interdit car rien sur la ${nouvelleposition.nom}")
                    return false
                }
            }
        }
        else {
            println("déplacement non autorisé")
            return false
        }
        return false
    }

}