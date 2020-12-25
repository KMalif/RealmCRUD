package com.example.realmtable.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.realmtable.R
import com.example.realmtable.model.student
import kotlinx.android.synthetic.main.item_student.view.*

class studentAdapter (private val students: MutableList<student> ) : RecyclerView.Adapter<studentAdapter.studentViewHolder>(){

    inner class studentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): studentViewHolder {
        return studentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun getItemCount() = students.size

    override fun onBindViewHolder(holder: studentViewHolder, position: Int) {
        holder.itemView.apply {
            name_textview.text = students[position].getNama()
            nim_textview.text = students[position].getNim().toString()
            email_textview.text = students[position].getEmail()
            alamat_textview.text = students[position].getAlamat()
        }
    }

    fun setStudent(data:List<student>){
        students.clear()
        students.addAll(data)
        notifyDataSetChanged()
    }

}