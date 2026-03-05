package br.edu.fatecpg.cadastrolivro.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.cadastrolivro.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botaoCadastro = findViewById<Button>(R.id.botao_cadastro)

        botaoCadastro.setOnClickListener {
            val campoTitulo = findViewById<EditText>(R.id.campo_livro_titulo)
            val campoAutor = findViewById<EditText>(R.id.campo_livro_autor)

            val titulo = campoTitulo.text.toString()
            val autor = campoAutor.text.toString()

            if (titulo.isBlank()) {
                campoTitulo.error = "O título do livro é obrigatório"
                campoTitulo.requestFocus()
            } else if (autor.isBlank()) {
                campoAutor.error = "O nome do autor é obrigatório"
                campoAutor.requestFocus()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("livro_titulo", titulo)
                intent.putExtra("livro_autor", autor)
                startActivity(intent)
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