package br.edu.fatecpg.primeiraleiohm.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.primeiraleiohm.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoCalcular = findViewById<Button>(R.id.btn_calcular)

        val radioCalculo = findViewById<RadioGroup>(R.id.rg_calculo)

        val campoValorUm = findViewById<EditText>(R.id.edt_valor1)
        val campoValorDois = findViewById<EditText>(R.id.edt_valor2)

        val textoResultado = findViewById<TextView>(R.id.txv_resultado)

        botaoCalcular.setOnClickListener {
            val idSelecionado = radioCalculo.checkedRadioButtonId

            if (idSelecionado == -1) {
                return@setOnClickListener
            }

            val str1 = campoValorUm.text.toString()
            val str2 = campoValorDois.text.toString()

            if (str1.isEmpty() || str2.isEmpty()) {
                if (str1.isEmpty()) campoValorUm.error = "Campo obrigatório"
                if (str2.isEmpty()) campoValorDois.error = "Campo obrigatório"
                return@setOnClickListener
            }

            val valor1 = str1.toDouble()
            val valor2 = str2.toDouble()

            when (idSelecionado) {
                R.id.rb_tensao -> {
                    val resultado = valor1 * valor2
                    textoResultado.text = getString(R.string.txv_resultado, "$resultado V")
                    textoResultado.visibility = View.VISIBLE
                }
                R.id.rb_resistencia -> {
                    if (valor2 == 0.0) {
                        campoValorDois.error = "Não pode ser zero"
                    } else {
                        val resultado = valor1 / valor2
                        textoResultado.text = getString(R.string.txv_resultado, "$resultado Ω")
                        textoResultado.visibility = View.VISIBLE
                    }
                }
                R.id.rb_corrente -> {
                    if (valor2 == 0.0) {
                        campoValorDois.error = "Não pode ser zero"
                    } else {
                        val resultado = valor1 / valor2
                        textoResultado.text = getString(R.string.txv_resultado, "$resultado A")
                        textoResultado.visibility = View.VISIBLE
                    }
                }
            }
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}