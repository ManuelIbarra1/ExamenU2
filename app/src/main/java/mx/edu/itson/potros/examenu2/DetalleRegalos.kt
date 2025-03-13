package mx.edu.itson.potros.examenu2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val ivRegaloImagen: ImageView = findViewById(R.id.iv_regalo_imagen)
        val tvRegaloPrecio: TextView = findViewById(R.id.tv_regalo_precio)

        val image = intent.getIntExtra("imagen", 0)
        val precio = intent.getStringExtra("precio")

        ivRegaloImagen.setImageResource(image)
        tvRegaloPrecio.text = precio
    }
}