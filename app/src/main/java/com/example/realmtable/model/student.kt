package com.example.realmtable.model

import io.realm.RealmObject
import io.realm.annotations.RealmClass
import kotlinx.android.parcel.Parcelize

@RealmClass
open class student:RealmObject() {
    private var id: Int? = null
    private var nim:Int? = null
    private var nama:String = ""
    private var email:String = ""
    private var alamat:String = ""


    fun setId (id: Int){
        this.id = id
    }
    fun getId ():Int?{
        return id
    }

    fun setNama (nama:String){
        this.nama = nama
    }
    fun getNama (): String {
        return nama
    }
    fun setNim (nim: Int){
        this.nim = nim
    }
    fun getNim (): Int? {
        return nim
    }
    fun setEmail (email:String){
        this.email = email
    }
    fun getEmail (): String {
        return email
    }
    fun setAlamat (alamat:String){
        this.alamat = alamat
    }
    fun getAlamat (): String {
        return alamat
    }
}