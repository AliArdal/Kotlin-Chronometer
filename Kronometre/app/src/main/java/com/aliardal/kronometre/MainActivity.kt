package com.aliardal.kronometre

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    var zamaniDurdur:Long = 0
    fun start(view: View){
        kronometre.base = SystemClock.elapsedRealtime()+zamaniDurdur
        kronometre.start()
        buttonStart.visibility = View.GONE
        buttonPause.visibility = View.VISIBLE
        imageView.setImageDrawable(getDrawable(R.drawable.pause))

    }
    fun pause(view: View) {
        zamaniDurdur = kronometre.base - SystemClock.elapsedRealtime()
        kronometre.stop()
        buttonPause.visibility = View.GONE
        buttonStart.visibility = View.VISIBLE
        imageView.setImageDrawable(getDrawable(R.drawable.start))
    }
    fun reset(view: View) {
        kronometre.base = SystemClock.elapsedRealtime()
        kronometre.stop()
        zamaniDurdur = 0
        buttonPause.visibility = View.GONE
        buttonStart.visibility = View.VISIBLE
        imageView.setImageDrawable(getDrawable(R.drawable.start))
    }
}