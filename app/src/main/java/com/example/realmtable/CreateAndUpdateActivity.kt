package com.example.realmtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realmtable.model.student
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_create_and_update.*

class CreateAndUpdateActivity : AppCompatActivity() {

   private lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_update)
        initView()

        save_button.setOnClickListener {
            realm.beginTransaction()
            var countId = 0

            realm.where(student::class.java).findAll().let {
                for (i in it){
                    countId++
                }
            }

            var student = realm.createObject(student::class.java)
            student.setId(countId+1)
            student.setNama(name_editText.text.toString())
            student.setNim(nim_editText.text.toString().toInt())
            student.setEmail(email_editText.text.toString())
            student.setAlamat(alamat_editText.text.toString())
            name_editText.setText("")
            nim_editText.setText(null)
            email_editText.setText("")
            alamat_editText.setText("")
            realm.commitTransaction()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
    fun initView(){
        realm = Realm.getDefaultInstance()
    }


}