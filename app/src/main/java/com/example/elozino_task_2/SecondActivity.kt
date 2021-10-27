package com.example.elozino_task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.pushButton).setOnClickListener {
            ++count
            supportFragmentManager.beginTransaction().add(R.id.frame,
                BaseFragment.newInstance("Fragment $count", ""), "Base Fragment").commit()
        }
    }
}