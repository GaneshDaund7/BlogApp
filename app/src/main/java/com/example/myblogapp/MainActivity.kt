package com.example.myblogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myblogapp.R.*
import com.example.myblogapp.R.layout.*
import com.google.firebase.database.*
import com.firebase.ui.database.FirebaseRecyclerAdapter


class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val actionBar= supportActionBar
        actionBar?.setTitle("Blog")
        val recyclerview=findViewById(id.recyclerview) as RecyclerView
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager=LinearLayoutManager(this)
        val firebaseDatabase=FirebaseDatabase.getInstance()
        val databaseReferenc=firebaseDatabase.getReference("Data")




    }


     override fun onStart() {
        super.onStart()

     val firebaseRecyclerAdapter= object : FirebaseRecyclerAdapter<Modell, MainHolder>(
            Modell::class.java,
            R.layout.row,
            MainHolder::class.java,
            FirebaseDatabase.getInstance().getReference("Data")

        )
        {
            override fun populateViewHolder(p0: MainHolder, p1: Modell, p2: Int) {

                p0.setDetails(applicationContext,p1.getTitle(),p1.getDescription(),p1.getImage())



            }
        }




        }



}
