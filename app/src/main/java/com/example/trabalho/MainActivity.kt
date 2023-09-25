package com.example.trabalho
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCnpj = findViewById<EditText>(R.id.editTextCnpj)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener(View.OnClickListener {
            val cnpj = editTextCnpj.text.toString()
            val password = editTextPassword.text.toString()

            // Verifica o CNPJ e a senha fixa
            if (cnpj == "132" && password == "dudu") {
                // Login bem-sucedido
                Toast.makeText(this@MainActivity, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                // Você pode redirecionar para a próxima atividade aqui
                // Após a verificação do login bem-sucedido
                val intent = Intent(this@MainActivity, MenuActivity::class.java)
                startActivity(intent)
                finish()
                finish() // Isso encerra a atividade de login para que o usuário não possa voltar para ela pressionando "Voltar".
// Isso encerra a atividade de login para que o usuário não possa voltar para ela pressionando "Voltar"
            } else {
                // Login falhou
                Toast.makeText(this@MainActivity, "CNPJ ou senha incorretos.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
