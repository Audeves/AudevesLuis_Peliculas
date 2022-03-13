package audeves.luis.peliculas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import audeves.luis.peliculas.AdaptadorPeliculas
import audeves.luis.peliculas.Pelicula
import audeves.luis.peliculas.R
import audeves.luis.peliculas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var peliculas: ArrayList<Pelicula> = ArrayList()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}
        llenar_peliculas()
        var adaptador = AdaptadorPeliculas(root.context, peliculas)
        var listview: ListView = binding.listviewPeliculas
        listview.adapter = adaptador
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenar_peliculas(){
        var pelicula1 = Pelicula(1, getString(R.string.peli1), getString(R.string.peli1_sinop), 117, R.drawable.blade_runner)
        peliculas.add(pelicula1)

        val pelicula2 = Pelicula(2,getString(R.string.peli2),getString(R.string.peli2_sinop),178, R.drawable.corazon_valiente)
        peliculas.add(pelicula2)

        val pelicula3 = Pelicula(3,getString(R.string.peli3),getString(R.string.peli3_sinop),175, R.drawable.el_padrino)
        peliculas.add(pelicula3)

        val pelicula4 = Pelicula(4,getString(R.string.peli4),getString(R.string.peli4_sinop),146, R.drawable.el_resplandor)
        peliculas.add(pelicula4)

        val pelicula5 = Pelicula(5,getString(R.string.peli5),getString(R.string.peli5_sinop),114, R.drawable.taxi_driver)
        peliculas.add(pelicula5)
    }
}