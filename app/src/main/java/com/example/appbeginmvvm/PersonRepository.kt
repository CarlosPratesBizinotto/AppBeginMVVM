package com.example.appbeginmvvm

class PersonRepository {

    fun login (email: String, password: String): Boolean{
        return (email != "" && password != null)
    }


}