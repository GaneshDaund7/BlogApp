package com.example.myblogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myblogapp.R.*
import com.example.myblogapp.R.layout.*
import com.google.firebase.database.*
import com.firebase.ui.database.FirebaseRecyclerAdapter as FirebaseRecyclerAdapter1


class MainActivity : AppCompatActivity() {



    val firebaseDatabase=FirebaseDatabase.getInstance()
    val databaseReferenc=firebaseDatabase.getReference("Data")


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val actionBar= supportActionBar
        actionBar?.setTitle("Blog")
        val recyclerview=findViewById(id.recyclerview) as RecyclerView
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager=LinearLayoutManager(this)
        val firebaseRecyclerAdapter= object : FirebaseRecyclerAdapter1<Modell, MainHolder>(
            Modell::class.java,
            row,
            MainHolder::class.java,
            FirebaseDatabase.getInstance().getReference("Data")) {
            override fun populateViewHolder(p0: MainHolder, p1: Modell, p2: Int) {

                p0.setDetails(applicationContext,p1.getTitle(),p1.getDescription(),p1.getImage())

            }
        }

        recyclerview.adapter=firebaseRecyclerAdapter








    }
    override fun onCreateOptionsMenu(menu:Menu): Boolean {





        menuInflater.inflate(R.menu.menu,menu)
        val item:MenuItem=menu.findItem(R.id.search)
        val searchview:SearchView=MenuItemCompat.getActionView(item) as SearchView
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    FirebaseSearch(query)
                }
                return false


            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    FirebaseSearch(newText)
                }
                return false

            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        val id=item.getItemId()
        if(id==R.id.setting){
            return true
        }
        return super.onOptionsItemSelected(item)
    }




    fun FirebaseSearch(searchtext:String) {


        val recyclerview=findViewById(id.recyclerview) as RecyclerView
        var firebaseSearchQuery: Query=databaseReferenc.orderByChild("title").startAt(searchtext).endAt(searchtext + "\uf8ff")
        searchtext.toLowerCase()


        val firebaseRecyclerAdapter=object : FirebaseRecyclerAdapter1<Modell, MainHolder>(
            Modell::class.java,
            row,
            MainHolder::class.java,
            firebaseSearchQuery
        ){
            override fun populateViewHolder(p0: MainHolder?, p1: Modell?, p2: Int) {
                p0!!.setDetails(applicationContext, p1!!.getTitle(),p1.getDescription(),p1.getImage())

            }

        }

        recyclerview.adapter=firebaseRecyclerAdapter



    }





}

