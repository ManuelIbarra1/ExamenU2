package mx.edu.itson.potros.examenu2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btnDetalles: Button = findViewById(R.id.btn_detalles)
        val btnGlobos: Button = findViewById(R.id.btn_globos)
        val btnPeluches: Button = findViewById(R.id.btn_peluches)
        val btnRegalos: Button = findViewById(R.id.btn_regalos)
        val btnTazas: Button = findViewById(R.id.btn_tazas)

        btnDetalles.setOnClickListener {
            abrirSeccion("Detalles")
        }

        btnGlobos.setOnClickListener {
            abrirSeccion("Globos")
        }

        btnPeluches.setOnClickListener {
            abrirSeccion("Peluches")
        }

        btnRegalos.setOnClickListener {
            abrirSeccion("Regalos")
        }

        btnTazas.setOnClickListener {
            abrirSeccion("Tazas")
        }
    }

    private fun abrirSeccion(nombre: String) {
        val intent = Intent(this, Regalos::class.java)
        intent.putExtra("nombre", nombre)
        startActivity(intent)
    }
}