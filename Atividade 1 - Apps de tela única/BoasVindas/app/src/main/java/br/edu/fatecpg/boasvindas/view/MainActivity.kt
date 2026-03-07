package br.edu.fatecpg.boasvindas.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.boasvindas.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val campoNomeUsuario = findViewById<EditText>(R.id.edt_nome_usuario)
        val campoIdade = findViewById<EditText>(R.id.edt_idade)

        val textoConfirmacao = findViewById<TextView>(R.id.txv_confirmacao)
        val botaoConfirmar = findViewById<Button>(R.id.btn_confirmar)

        botaoConfirmar.setOnClickListener {
            val nomeUsuario = campoNomeUsuario.text.toString()
            val idade = campoIdade.text.toString().toIntOrNull()

            if (nomeUsuario.isBlank()) {
                campoNomeUsuario.error = "O nome de usuário é obrigatório."
                campoNomeUsuario.requestFocus()
            } else if (idade == null) {
                campoIdade.error = "Insira um número válido."
                campoIdade.requestFocus()
            } else {
                textoConfirmacao.text =
                    getString(R.string.txv_confirmacao, nomeUsuario, idade.toString())
                textoConfirmacao.visibility = View.VISIBLE
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