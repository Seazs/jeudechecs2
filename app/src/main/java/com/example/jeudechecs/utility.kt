package com.example.jeudechecs

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool

open class utility (leContext : Context, mainActivity: MainActivity){
    var mContext : Context = leContext
    var lActivity: MainActivity = mainActivity
    public fun jouerSon(){
        val soundPool : SoundPool = SoundPool(2, AudioManager.STREAM_MUSIC, 0 )
        val leson : Int = soundPool.load(mContext, R.raw.deplacement, 1)
        soundPool.play(leson, 1F, 1F, 1, 0, 1F)
    }
    fun finishActivity(){
        lActivity.finish()
    }
}