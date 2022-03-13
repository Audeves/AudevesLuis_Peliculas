package audeves.luis.peliculas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import audeves.luis.peliculas.AdaptadorPeliculas
import audeves.luis.peliculas.AdaptadorSeries
import audeves.luis.peliculas.R
import audeves.luis.peliculas.databinding.FragmentGalleryBinding
import audeves.luis.peliculas.Series



class GalleryFragment : Fragment() {
    var series: ArrayList<Series> = ArrayList()
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textGallery
        //galleryViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}
        llenarSeries()
        var adaptador = AdaptadorSeries(root.context, series)
        var listView : ListView = binding.listiViewSeries
        listView.adapter = adaptador
        return root
    }
    fun llenarSeries(){
        val serie1 = Series(1,getString(R.string.serie1),getString(R.string.serie_sinop1),R.drawable.the_mandalorian)
        series.add(serie1)
        val serie2 = Series(2,getString(R.string.serie2),getString(R.string.serie_sinop2),R.drawable.cobra_kai)
        series.add(serie2)
        val serie3 = Series(3,getString(R.string.serie3),getString(R.string.serie_sinop3),R.drawable.the_boys)
        series.add(serie3)
        val serie4 = Series(4,getString(R.string.serie4),getString(R.string.serie_sinop4),R.drawable.the_witcher)
        series.add(serie4)
        val serie5 = Series(5,getString(R.string.serie5),getString(R.string.serie_sinop5),R.drawable.invencible)
        series.add(serie5)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}