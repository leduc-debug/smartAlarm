package com.lduwcs.smartalarm.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lduwcs.smartalarm.AddAlarmActivity
import com.lduwcs.smartalarm.R

class AlarmFragment : Fragment() {


    lateinit var btnAdd: FloatingActionButton
    lateinit var llAlarm: LinearLayout
    lateinit var llQuickAlarm: LinearLayout
    val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context,R.anim.rotate_open) }
    val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context,R.anim.rotate_close) }
    val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context,R.anim.from_bottom) }
    val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context,R.anim.to_bottom) }

    var isClick = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd = view.findViewById(R.id.btn_add)
        llAlarm = view.findViewById(R.id.ll_add_alarm)
        llQuickAlarm = view.findViewById(R.id.ll_add_quick_alarm)
        llAlarm.setOnClickListener {
            Toast.makeText(context, "dmcdkcdck", Toast.LENGTH_SHORT).show()
            var intent = Intent(context,AddAlarmActivity::class.java )
            startActivity(intent)
        }
        btnAdd.setOnClickListener {
            isClick=!isClick
            if(isClick){
                llAlarm.visibility = View.VISIBLE
                llQuickAlarm.visibility = View.VISIBLE
                llAlarm.startAnimation(fromBottom)
                llQuickAlarm.startAnimation(fromBottom)
                btnAdd.startAnimation(rotateOpen)
            }
            else{
                llAlarm.visibility = View.INVISIBLE
                llQuickAlarm.visibility = View.INVISIBLE
                llAlarm.startAnimation(toBottom)
                llQuickAlarm.startAnimation(toBottom)
                btnAdd.startAnimation(rotateClose)
            }

        }
    }

}