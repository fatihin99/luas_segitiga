package com.example.luassegitiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HasilAdapter(private val dataSet: MutableList<DataHasil>):
RecyclerView.Adapter<HasilAdapter.HasilHolder>(){
    class HasilHolder(view: View): RecyclerView.ViewHolder(view){
        val bilalas = view.findViewById<TextView>(R.id.bilAlas)
        val biltinggi = view.findViewById<TextView>(R.id.bilTinggi)
        val bilhasil = view.findViewById<TextView>(R.id.THasil)
        val hapus = view.findViewById<Button>(R.id.bthps)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HasilHolder {
       val view = LayoutInflater.from(parent.context).inflate(
           R.layout.adapter_hasil,parent,false
       )
        return HasilHolder(view)
    }

    override fun onBindViewHolder(holder: HasilHolder, position: Int) {
        holder.bilalas.text = dataSet[position].bilanganAlas
        holder.biltinggi.text = dataSet[position].bilanganTinggi
        holder.bilhasil.text = dataSet[position].hasil
        holder.hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}