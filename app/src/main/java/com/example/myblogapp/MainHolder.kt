package com.example.myblogapp

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainHolder(internal var view: View):RecyclerView.ViewHolder(view) {


    fun setDetails(ctx: Context, title: String, description: String, image: String) {
        val textTitle=view.findViewById(R.id.rtitleTv) as TextView
        val TextDes=view.findViewById(R.id.rDescriptionView) as TextView
        val imageView=view.findViewById(R.id.rimageView) as ImageView
        textTitle.setText(title)
        TextDes.setText(description)
        Picasso.get().load(image).into(imageView);


    }

    init {
        view.setOnClickListener { v: View ->




            val i=Intent(v.context, PaymentGateway::class.java)
            itemView.context.startActivity(i)
        }

    }

}