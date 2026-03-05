package br.edu.fatecpg.cadastrolivro.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.cadastrolivro.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tituloRecebido = intent.getStringExtra("livro_titulo")
        val autorRecebido = intent.getStringExtra("livro_autor")

        val textoTitulo = findViewById<TextView>(R.id.livro_titulo)
        val textoAutor = findViewById<TextView>(R.id.livro_autor)
        val botaoVoltar = findViewById<FloatingActionButton>(R.id.botao_voltar)

        textoTitulo.text = getString(R.string.titulo_livro_formatado, tituloRecebido)
        textoAutor.text = getString(R.string.autor_livro_formatado, autorRecebido)

        botaoVoltar.setOnClickListener {
            finish()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}