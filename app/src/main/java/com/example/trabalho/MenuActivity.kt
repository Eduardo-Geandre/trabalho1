package com.example.trabalho
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonConsultar = findViewById<View>(R.id.buttonConsultar)
        val buttonCadastrar = findViewById<View>(R.id.buttonCadastrar)

        buttonConsultar.setOnClickListener {
            // Lógica para abrir a tela de consulta
            startActivity(Intent(this@MenuActivity, ConsultarActivity::class.java))
        }

        buttonCadastrar.setOnClickListener {
            // Lógica para abrir a tela de cadastro
            startActivity(Intent(this@MenuActivity, CadastrarActivity::class.java))
        }
    }
}
