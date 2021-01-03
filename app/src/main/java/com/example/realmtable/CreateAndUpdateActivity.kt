package com.example.realmtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realmtable.adapter.studentAdapter
import com.example.realmtable.model.student
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_create_and_update.*

class CreateAndUpdateActivity : AppCompatActivity() {
    lateinit var studentAdapter: studentAdapter
    lateinit var realm: Realm
    val lm = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_update)

        save_button.setOnClickListener {
            realm.beginTransaction()
            realm.where(student::class.java).findAll()
            var student = realm.createObject(student::class.java)
            student.setNama(name_editText.text.toString().trim())
            student.setNim(nim_editText.text.toString().toInt())
            student.setEmail(email_editText.text.toString().trim())
            student.setAlamat(alamat_editText.text.toString().trim())
            name_editText.setText("")
            nim_editText.setText(0)
            email_editText.setText("")
            alamat_editText.setText("")

            realm.commitTransaction()
            getallStudent()
            startActivity(Intent(this, MainActivity::class.java))

        }

    }

    private fun getallStudent(){
        realm.where(student::class.java).findAll().let {
            studentAdapter.setStudent(it)
        }
    }
}