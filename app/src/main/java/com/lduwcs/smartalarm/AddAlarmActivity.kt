package com.lduwcs.smartalarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast

class AddAlarmActivity : AppCompatActivity() {

    lateinit var timePicker: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_alarm)

        timePicker = findViewById(R.id.time_picker)

        findViewById<Button>(R.id.btn_add).setOnClickListener {

            var hour = timePicker.currentHour
            var minute = timePicker.currentMinute

            Toast.makeText(baseContext, "gio ${hour}, ${minute}", Toast.LENGTH_SHORT).show()

        }

    }
}