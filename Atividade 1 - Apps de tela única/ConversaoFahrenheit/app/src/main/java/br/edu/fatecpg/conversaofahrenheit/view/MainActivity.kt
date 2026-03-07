package br.edu.fatecpg.conversaofahrenheit.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.conversaofahrenheit.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val campoGrausCelsius = findViewById<EditText>(R.id.edt_graus_celsius)
        val textoConversao = findViewById<TextView>(R.id.txv_conversao)

        val botaoConverter = findViewById<Button>(R.id.btn_converter)

        botaoConverter.setOnClickListener {
            val grausCelsius = campoGrausCelsius.text.toString().toDoubleOrNull()

            if(grausCelsius == null) {
                campoGrausCelsius.error = "Insira um número válido."
                campoGrausCelsius.requestFocus()
            } else {
                val grausFahrenheit = (grausCelsius * 1.8) + 32
                textoConversao.text = getString(R.string.txv_conversao, "$grausFahrenheit°F")
                textoConversao.visibility = View.VISIBLE
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