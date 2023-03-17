package br.com.puc.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.puc.imc.databinding.ActivityMainBinding
import br.com.puc.imc.databinding.ActivityResultBinding

class ResultImcActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener(this)



        if(intent.hasExtra("imc_resultado")){
            val imc = intent.getDoubleExtra("imc_resultado",0.0)
            binding.etResultImc.text = String.format("%2.f",imc)
            binding.etResultCheckImc.text = checkImc(imc)
        }else finish()




    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.btnBack){
            btnBack()
        }
    }



    private fun checkImc(imc: Double) :String {
        return when(imc) {
            in 0.0..18.49 -> "Muito abaixo do peso"
            in 18.5..24.9 -> "Peso Normal"
            in 25.0..29.9 -> "Excesso de peso"
            in 30.0..34.9 -> "Obsidade classe I"
            in 35.0..39.9 -> "Obesidade classe II"
            else -> {"Obesidade classe III"}
        }
    }


    private fun btnBack() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}