package com.example.elozino_task_2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

var count = 0
//var orientation = ""

class MainActivity : AppCompatActivity() {
    var orientation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.activityButton).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        count = savedInstanceState?.getInt("COUNT") ?: count
        orientation = savedInstanceState?.getString("ORIENTATION") ?: orientation
        findViewById<TextView>(R.id.activityStateTextView).text = "onCreate"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("COUNT", count)
        outState.putString("ORIENTATION", orientation)
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ++count
            orientation = "LANDSCAPE"
            findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            ++count
            orientation = "PORTRAIT"
            findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
        }
    }

    override fun onStart() {
        super.onStart()
        findViewById<TextView>(R.id.activityStateTextView).text = "onStart"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.activityStateTextView).text = "onResume"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }

    override fun onPause() {
        super.onPause()
        findViewById<TextView>(R.id.activityStateTextView).text = "onPause"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }

    override fun onStop() {
        super.onStop()
        findViewById<TextView>(R.id.activityStateTextView).text = "onStop"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }

    override fun onRestart() {
        super.onRestart()
        findViewById<TextView>(R.id.activityStateTextView).text = "onRestart"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }

    override fun onDestroy() {
        super.onDestroy()
        findViewById<TextView>(R.id.activityStateTextView).text = "onDestroy"
        findViewById<TextView>(R.id.currentOrientationTextView).text = "$orientation $count"
    }
}