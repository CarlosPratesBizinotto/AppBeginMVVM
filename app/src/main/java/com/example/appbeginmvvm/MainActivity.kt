package com.example.appbeginmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appbeginmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewAModel: MainViewAModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)

        viewAModel = ViewModelProvider(this).get(MainViewAModel::class.java)

        setObserver()

        }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login){
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewAModel.doLogin(email, password)

        }
    }


    //O Observer sempre vai ficar atento a função Welcome, qualquer mudança ele olha e altera, que por sua vez é o LiveData que retorna o textWelcome
    //pois o textWelcome pode ser mutavel
        private fun setObserver(){
            viewAModel.welcome().observe(this, Observer {
                binding.textWelcome.text = it
            })

            viewAModel.login().observe(this, Observer {
                if(it){
                    Toast.makeText(applicationContext, "SUCESSO!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_LONG).show()
                }
            })




    }


}