package com.example.netcha

import android.util.Log

data class UserData(val name: String, val id: String, val pw: String)

object UserDatabase {
    private val users: MutableList<UserData> = mutableListOf()

    fun addUser(name: String, id: String, pw: String) {
        val newUser = UserData(name, id, pw)
        users.add(newUser)
    }

    fun findUserByName(name: String): UserData? {
        return users.find { it.name == name }
    }

    fun findUserById(id: String): UserData? {
        return users.find { it.id == id }
    }

    fun findUserByPw(pw: String) : UserData? {
        return users.find { it.pw == pw }
    }

    fun info(){
        Log.d("jina","users: $users")
    }
}