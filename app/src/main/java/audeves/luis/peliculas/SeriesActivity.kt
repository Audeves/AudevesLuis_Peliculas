package audeves.luis.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SeriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series)
        val tv_img : ImageView = findViewById(R.id.img_serie)
        val tv_nombre: TextView = findViewById(R.id.tv_nombreS)
        val tv_sinop: TextView = findViewById(R.id.tv_sinopS)

        val bundle = intent.extras

        if (bundle != null){
            var nombre: String = bundle.getString("nombre","")
            var sinopsis: String = bundle.getString("sinopsis","")
            val img: Int = bundle.getInt("img")

            tv_nombre.setText(nombre)
            tv_sinop.setText(sinopsis)
            tv_img.setImageResource(img)

        }
    }
}