package mx.edu.itson.potros.examenu2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Regalos : AppCompatActivity() {
    var listaDetalles = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        val tvTitulo: TextView = findViewById(R.id.tv_title)
        val gridView: GridView = findViewById(R.id.gv_regalos)

        val nombre = intent.getStringExtra("nombre") ?: ""
        tvTitulo.setText(nombre)

        when (nombre) {
            "Detalles" -> cargarDetalles()
            "Globos" -> cargarGlobos()
            "Peluches" -> cargarPeluches()
            "Tazas" -> cargarTazas()
            "Regalos" -> cargarRegalos()
            else -> {}
        }

        val adapter = DetallesAdapter(this, listaDetalles)

        var gvRegalos: GridView = findViewById(R.id.gv_regalos)

        gvRegalos.adapter = adapter
    }

    private fun cargarDetalles() {
        listaDetalles.clear()
        listaDetalles.add(Detalles(R.drawable.cumplebotanas, "$280"))
        listaDetalles.add(Detalles(R.drawable.cumplecheve, "$320"))
        listaDetalles.add(Detalles(R.drawable.cumpleescolar, "$330"))
        listaDetalles.add(Detalles(R.drawable.cumplepaletas, "$190"))
        listaDetalles.add(Detalles(R.drawable.cumplesnack, "$150"))
        listaDetalles.add(Detalles(R.drawable.cumplevinos, "$370"))
    }

    private fun cargarGlobos() {
        listaDetalles.clear()
        listaDetalles.add(Detalles(R.drawable.globoamor, "$240"))
        listaDetalles.add(Detalles(R.drawable.globocumple, "$820"))
        listaDetalles.add(Detalles(R.drawable.globofestejo, "$260"))
        listaDetalles.add(Detalles(R.drawable.globonum, "$760"))
        listaDetalles.add(Detalles(R.drawable.globoregalo, "$450"))
        listaDetalles.add(Detalles(R.drawable.globos, "$240"))
    }

    private fun cargarPeluches() {
        listaDetalles.clear()
        listaDetalles.add(Detalles(R.drawable.peluchemario, "$320"))
        listaDetalles.add(Detalles(R.drawable.pelucheminecraft, "$320"))
        listaDetalles.add(Detalles(R.drawable.peluchepeppa, "$290"))
        listaDetalles.add(Detalles(R.drawable.peluches, "$"))
        listaDetalles.add(Detalles(R.drawable.peluchesony, "$330"))
        listaDetalles.add(Detalles(R.drawable.peluchestich, "$280"))
        listaDetalles.add(Detalles(R.drawable.peluchevarios, "$195"))
    }

    private fun cargarRegalos() {
        listaDetalles.clear()
        listaDetalles.add(Detalles(R.drawable.regaloazul, "$80"))
        listaDetalles.add(Detalles(R.drawable.regalobebe, "$290"))
        listaDetalles.add(Detalles(R.drawable.regalocajas, "$140"))
        listaDetalles.add(Detalles(R.drawable.regalocolores, "$85"))
        listaDetalles.add(Detalles(R.drawable.regalos, "$"))
        listaDetalles.add(Detalles(R.drawable.regalovarios, "$75"))
    }

    private fun cargarTazas() {
        listaDetalles.clear()
        listaDetalles.add(Detalles(R.drawable.tazaabuela, "$120"))
        listaDetalles.add(Detalles(R.drawable.tazalove, "$120"))
        listaDetalles.add(Detalles(R.drawable.tazaquiero, "$260"))
        listaDetalles.add(Detalles(R.drawable.tazas, "$280"))
    }

}

class DetallesAdapter: BaseAdapter {

    var listaDetalles = ArrayList<Detalles>()
    var context: Context? = null

    constructor(context: Context, peliculas: ArrayList<Detalles>): super() {
        this.listaDetalles = peliculas
        this.context = context
    }

    override fun getCount(): Int {
        return listaDetalles.size
    }

    override fun getItem(position: Int): Any {
        return listaDetalles[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val detalle = listaDetalles[position]

        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = convertView ?: inflater.inflate(R.layout.detalles, parent, false)

        val image: ImageView = view.findViewById(R.id.imagen_detalle_cell)
        val precio: TextView = view.findViewById(R.id.precio_detalle_cell)

        image.setImageResource(detalle.image)
        precio.text = detalle.precio

        image.setOnClickListener {
            val intent = Intent(context, DetalleRegalos::class.java)
            intent.putExtra("imagen", detalle.image)
            intent.putExtra("precio", detalle.precio)
            context!!.startActivity(intent)
        }

        return view
    }



}