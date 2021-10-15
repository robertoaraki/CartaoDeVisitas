package com.rtaraki.cartaodevisitas.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.rtaraki.cartaodevisitas.App
import com.rtaraki.cartaodevisitas.R
import com.rtaraki.cartaodevisitas.data.BusinessCard
import com.rtaraki.cartaodevisitas.databinding.ActivityAddBusinessCardBinding
import kotlin.random.Random

class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        gerarNovaCor()
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success,Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnCorMudar.setOnClickListener {
            gerarNovaCor()
        }
    }

    private fun gerarNovaCor() {
        val corNum = getRandomColor()
        val hexColor = String.format("#%06X", -0x1 and corNum)
        binding.tilCor.editText?.setText(hexColor)
        binding.tilAmostraCor.setBackgroundColor(corNum)
    }

    private fun getRandomColor(): Int {
        //val rnd = Random(256)
        //return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        return Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    }

}