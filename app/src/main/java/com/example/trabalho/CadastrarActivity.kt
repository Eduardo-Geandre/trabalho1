package com.example.trabalho
import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CadastrarActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1 // Uma constante para o código de solicitação da imagem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val editTextNF = findViewById<EditText>(R.id.editTextNF)
        val editTextCodigoProduto = findViewById<EditText>(R.id.editTextCodigoProduto)
        val buttonAnexarFoto = findViewById<Button>(R.id.buttonAnexarFoto)
        val buttonEnviarPedido = findViewById<Button>(R.id.buttonEnviarPedido)

        buttonAnexarFoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        buttonEnviarPedido.setOnClickListener {
            val nf = editTextNF.text.toString()
            val codigoProduto = editTextCodigoProduto.text.toString()
            val statusPedido = "Aguardando"

            // Recupere a lista de pedidos existente ou crie uma nova lista vazia
            val sharedPreferences = getSharedPreferences("pedidos", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = sharedPreferences.getString("lista_pedidos", null)
            val listaPedidos = if (json != null) {
                gson.fromJson(json, object : TypeToken<List<Pedido>>() {}.type)
            } else {
                mutableListOf<Pedido>()
            }

            // Adicione o novo pedido à lista de pedidos
            val novoPedido = Pedido(nf, codigoProduto, statusPedido)
            listaPedidos.add(novoPedido)

            // Converta a lista de pedidos em JSON e armazene novamente no SharedPreferences
            val editor = sharedPreferences.edit()
            val listaPedidosJson = gson.toJson(listaPedidos)
            editor.putString("lista_pedidos", listaPedidosJson)
            editor.apply()

            // Exemplo de exibição de uma mensagem de sucesso
            Toast.makeText(this@CadastrarActivity, "Pedido enviado com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Manipule a imagem selecionada aqui
            val selectedImageUri = data.data
            // Faça o que você precisa com a imagem
        }
    }

}
