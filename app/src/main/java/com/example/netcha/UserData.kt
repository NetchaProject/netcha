package com.example.netcha

data class UserData(val name: String, val id: String, val pw: String)

object UserDatabase {
    private val users: MutableList<UserData> = mutableListOf(
        UserData("test1", "user1", "password1"),
        UserData("test2", "user2", "password2"),
        UserData("test3", "user3", "password3"),
    )

    fun addUser(name: String, id: String, pw: String) {
        val newUser = UserData(name, id, pw)
        users.add(newUser)
    }

    fun findUserValidation(id:String , pw : String): UserData?{
        return users.find{
            it.id == id
            it.pw == pw
        }
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
}