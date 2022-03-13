package audeves.luis.peliculas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorPeliculas: BaseAdapter {
    lateinit var  context: Context
    var peliculas: ArrayList<Pelicula> = ArrayList()

    constructor(context: Context, peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas = peliculas
    }

    override fun getCount(): Int {
        //indica el numero de objetos en mi lista
        return peliculas.size
    }

    override fun getItem(p0: Int): Any {
        //indica el elemento individual con el cual puedo interactuar
        return peliculas[p0]
    }

    override fun getItemId(p0: Int): Long {
        //pide el id del elemento que estamos trabajando
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //obtener un inflador
        val inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.pelicula_view,null)

        var iv_img: ImageView = vista.findViewById(R.id.img_view)
        var tv_nombre: TextView = vista.findViewById(R.id.tv_nombre)

        var pelicula: Pelicula = peliculas[p0]

        iv_img.setImageResource(pelicula.img)
        tv_nombre.setText(pelicula.nombre)

        vista.setOnClickListener{
            val intent: Intent = Intent(context, PeliculaActivity::class.java)

            intent.putExtra("nombre", pelicula.nombre)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            intent.putExtra("img", pelicula.img)

            context.startActivity(intent)
        }
        return vista
    }


}