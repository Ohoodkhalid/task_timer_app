package com.example.tasktimerapp

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.time.Year
import java.util.*

class NewTask : AppCompatActivity() {
    lateinit var dateBu:Button
    lateinit var spinner: Spinner
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        spinner = findViewById(R.id.spinner)
        setupSpinner()

        val myCanceler = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener {view,year,month,dayOfMonth->
            myCanceler.set(Calendar.YEAR,year)
            myCanceler.set(Calendar.MONTH,month)
            myCanceler.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updatelable(myCanceler)
        }
        dateBu = findViewById(R.id.dateBu)
        dateBu.setOnClickListener{
            DatePickerDialog(this,datePicker,myCanceler.get(Calendar.YEAR),
                myCanceler.get(Calendar.MONTH),myCanceler.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updatelable(myCanceler: Calendar?) {
        val myFormat = "dd,MM,yyy"
        val sdf = SimpleDateFormat(myFormat,Locale.UK)
        dateBu.setText(sdf.format(myCanceler?.time))
    }

    fun setupSpinner(){
        val category = arrayListOf("Daily tasks", "monthly tasks", "Assignment")
        var selected = 0
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, category)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    selected = position

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
    }
