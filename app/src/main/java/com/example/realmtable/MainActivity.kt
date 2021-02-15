package com.example.realmtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realmtable.adapter.studentAdapter
import com.example.realmtable.model.student
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var studentAdapter : studentAdapter
    lateinit var realm : Realm
    val lm = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        fab.setOnClickListener {
            startActivity(Intent(this, CreateAndUpdateActivity::class.java))
            finish()
        }

    }
    fun initView(){
        rvMhs.layoutManager = lm
        studentAdapter = studentAdapter( mutableListOf(), object : studentAdapter.OnAdapterListener{
            override fun onClick(student: student) {
                startActivity(Intent(this@MainActivity, CreateAndUpdateActivity::class.java)
                        .putExtra("name", student.getNama())
                        .putExtra("nim", student.getNim())
                        .putExtra("email", student.getEmail())
                        .putExtra("alamat", student.getAlamat())
                )
            }
        })
        rvMhs.adapter = studentAdapter
        realm = Realm.getDefaultInstance()
        realm.where(student::class.java).findAll().let {
            studentAdapter.setStudent(it)
        }
    }
}