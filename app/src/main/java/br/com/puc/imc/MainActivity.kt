package br.com.puc.imc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.puc.imc.databinding.ActivityMainBinding
import kotlin.math.pow


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCallImc.setOnClickListener(this)
        binding.etHeight.setOnClickListener(this)
        binding.etWeight.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        if(v!!.id == R.id.btnCallImc) {
                hideSoftKeyboard()
                try {
                    val imc = Person(binding.etHeight.text.toString().toDouble(), binding.etWeight.text.toString().toDouble()).calImc()

                    val intentResult = Intent(this,ResultImcActivity::class.java)
                    intentResult.putExtra("imc_resultado",imc)
                    this.startActivity(intentResult)
                    finish()


                }catch (arg : IllegalArgumentException){
                    Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT)
                        .show()
                }

        } else {
            binding.etHeight.setText("")
            binding.etWeight.setText("")
        }
    }



    private fun hideSoftKeyboard(){
        val softKeyManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        softKeyManager.hideSoftInputFromWindow(binding.btnCallImc.windowToken, 0)
    }

//    private fun navigateResultActivity(){
//        val intent = Intent(this,ResultImcActivity::class.java)
//        startActivity(intent)
//        finish()
//    }

}







