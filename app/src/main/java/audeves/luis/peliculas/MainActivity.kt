package audeves.luis.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var peliculas: ArrayList<Pelicula> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenar_peliculas()

        var adaptador = AdaptadorPeliculas(this, peliculas)
        var listview: ListView = findViewById(R.id.listview)

        listview.adapter = adaptador
    }

    fun llenar_peliculas(){
        var pelicula1 = Pelicula(1, getString(R.string.peli1), getString(R.string.peli1_sinop), 117, R.drawable.blade_runner)
        peliculas.add(pelicula1)

        val pelicula2 = Pelicula(2,getString(R.string.peli2),getString(R.string.peli2_sinop),178,R.drawable.corazon_valiente)
        peliculas.add(pelicula2)

        val pelicula3 = Pelicula(3,getString(R.string.peli3),getString(R.string.peli3_sinop),175,R.drawable.el_padrino)
        peliculas.add(pelicula3)

        val pelicula4 = Pelicula(4,getString(R.string.peli4),getString(R.string.peli4_sinop),146,R.drawable.el_resplandor)
        peliculas.add(pelicula4)

        val pelicula5 = Pelicula(5,getString(R.string.peli5),getString(R.string.peli5_sinop),114,R.drawable.taxi_driver)
        peliculas.add(pelicula5)
    }
}