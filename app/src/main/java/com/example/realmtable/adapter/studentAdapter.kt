package com.example.realmtable.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realmtable.R
import com.example.realmtable.model.student



class studentAdapter( private val users: MutableList<student> , private val listener: studentAdapter.OnAdapterListener) : RecyclerView.Adapter<studentAdapter.studentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): studentViewHolder {
        return studentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: studentViewHolder, position: Int) {
        holder.bindModel(users[position])
        holder.itemView.setOnClickListener {
            listener.onClick(users[position])
        }
    }

    fun setStudent(data : List<student>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }

    inner class studentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvId :TextView = itemView.findViewById(R.id.id_textview)
        val tvNama :TextView = itemView.findViewById(R.id.name_textview)
        val tvNim :TextView = itemView.findViewById(R.id.nim_textview)
        val tvEmail :TextView = itemView.findViewById(R.id.email_textview)
        val tvAlamat :TextView = itemView.findViewById(R.id.alamat_textview)

        fun bindModel(s: student ){
            tvId.text = s.getId().toString()
            tvNama.text = s.getNama()
            tvNim.text = s.getNim().toString()
            tvEmail.text = s.getEmail()
            tvAlamat.text = s.getAlamat()
        }

    }

    interface OnAdapterListener{
        fun onClick(student : student)
    }

}