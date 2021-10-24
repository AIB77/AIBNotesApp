package com.example.aibnotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var RV:RecyclerView
    lateinit var EDT:EditText
    lateinit var BTN:Button
    private lateinit var db: DBHlper
    var usernote=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RV=findViewById(R.id.rv)
        EDT=findViewById(R.id.edt)
        BTN=findViewById(R.id.btn)
        db = DBHlper(this)


        BTN.setOnClickListener {

            if(EDT.text.isNotBlank())
            {
                usernote=EDT.text.toString()

                db.addNote(NoteModel1(0,usernote))
                EDT.text.clear()
                Toast.makeText(this, "The Note Added Successfully", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, "Enter The Note", Toast.LENGTH_LONG).show()
            }

        }
    }


}