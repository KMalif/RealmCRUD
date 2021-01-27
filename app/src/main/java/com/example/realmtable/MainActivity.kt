package com.example.realmtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        studentAdapter = studentAdapter(this)
        rvMhs.adapter = studentAdapter
        realm = Realm.getDefaultInstance()
        realm.where(student::class.java).findAll().let {
            studentAdapter.setStudent(it)
        }
    }
}