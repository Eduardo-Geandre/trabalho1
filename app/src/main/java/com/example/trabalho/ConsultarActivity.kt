package com.example.trabalho
import android.content.Context
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConsultarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
        val buttonExibirProdutos = findViewById<Button>(R.id.buttonExibirProdutos)

        buttonExibirProdutos.setOnClickListener {
            // Recupere a lista de pedidos armazenados em SharedPreferences
            val sharedPreferences = getSharedPreferences("pedidos", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = sharedPreferences.getString("lista_pedidos", null)
            val listaPedidos = if (json != null) {
                gson.fromJson(json, object : TypeToken<List<Pedido>>() {}.type)
            } else {
                mutableListOf<Pedido>()
            }

            // Agora você pode exibir a lista de pedidos conforme necessário
            // Por exemplo, você pode exibi-los em um ListView, RecyclerView ou em uma TextView
        }
}