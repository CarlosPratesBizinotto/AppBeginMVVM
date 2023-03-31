package com.example.appbeginmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewAModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val personRepository = PersonRepository()

    init {
        textWelcome.value = "Ola teste"
    }

    fun welcome(): LiveData<String> {
        return textWelcome
    }

    fun login(): LiveData<Boolean>{
        return login
    }


    fun doLogin(email: String, password:String){
        //LOGICA RESPOSSAVEL PARA VER SE O EMAIL E SENHA TA CERTA
        //PRIMEIRA COISA É DEFINIR UMA VARIAVEL QUE SERA A  "login" e criar uma LiveData
        //Apos fazer a primeira parte, ir na MainActivty e implementar o viewModel no Observer
        login.value = personRepository.login(email, password)

    }
}