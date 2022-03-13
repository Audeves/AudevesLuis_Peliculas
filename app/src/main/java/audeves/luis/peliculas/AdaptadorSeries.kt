package audeves.luis.peliculas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorSeries: BaseAdapter {
    lateinit var context: Context
    var series: ArrayList<Series> = ArrayList()

    constructor(context: Context, series: ArrayList<Series>) {
        this.context = context
        this.series = series
    }

    override fun getCount(): Int {
        //Indica el numero de objetos en la lista
        return series.size
    }

    override fun getItem(p0: Int): Any {
        //Indica el elemento individual con el cual puedo interactuar
        return series[p0]
    }

    override fun getItemId(p0: Int): Long {
        //pide el id del elemnto que estamos trabajando
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //obtener un inflador
        val inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.series_view, null)
        var iv_img: ImageView = vista.findViewById(R.id.img_view2)
        var tv_nombre: TextView = vista.findViewById(R.id.tv_nombre2)

        var serie: Series = series[p0]

        iv_img.setImageResource(serie.img)
        tv_nombre.setText(serie.nombre)

        vista.setOnClickListener {
            val intet: Intent = Intent(context, SeriesActivity::class.java)

            intet.putExtra("nombre", serie.nombre)
            intet.putExtra("sinopsis", serie.sipnosis)
            intet.putExtra("img", serie.img)

            context.startActivity(intet)
        }

        return vista


    }
}