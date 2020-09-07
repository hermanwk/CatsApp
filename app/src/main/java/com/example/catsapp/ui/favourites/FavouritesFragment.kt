package com.example.catsapp.ui.favourites

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsapp.BuildConfig
import com.example.catsapp.R
import com.example.catsapp.api.APIRepository
import com.example.catsapp.api.Error
import com.example.catsapp.api.Success
import com.example.catsapp.models.Favourite
import com.example.catsapp.models.HttpResponse
import com.example.catsapp.models.ImageFull
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavouritesFragment : Fragment() {
    private lateinit var favouritesViewModel: FavouritesViewModel
    private lateinit var favouritesListAdapter: FavouritesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favouritesViewModel =
            ViewModelProviders.of(this).get(FavouritesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favourites, container, false)
        favouritesListAdapter = FavouritesListAdapter(favouritesViewModel.imagesList) { item ->
            onItemSelected(item)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favouritesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = favouritesListAdapter
        }
    }

    override fun onStart() {
        super.onStart()

        loadFavouritesList()
    }

    fun loadFavouritesList() {
        if (favouritesViewModel.imagesList.isEmpty()) {
            GlobalScope.launch {
                APIRepository().getFavourites(
                    subId = BuildConfig.CAT_API_USER_ID,
                    limit = 0,
                    page = 0
                )
                    .Success { favourites: List<Favourite> ->
                        Log.d("Success", favourites.toString())

                        try {
                            Handler(Looper.getMainLooper()).post {
                                favouritesViewModel.favouritesList.addAll(favourites as ArrayList<Favourite>)

                                favouritesViewModel.favouritesList.forEach {
                                    loadImage(it.imageId)
                                }
                            }
                        } catch (e: Exception) {
                            Log.d("Exception", e.localizedMessage)
                        }
                    }.Error {
                        Log.d("Error", it.message)
                    }
            }
        }
    }

    fun loadImage(imageId: String) {
        if (favouritesViewModel.imagesList.isEmpty()) {
            GlobalScope.launch {
                APIRepository().getImage(imageId = imageId)
                    .Success { item: ImageFull ->
                        Log.d("Success", item.toString())

                        try {
                            Handler(Looper.getMainLooper()).post {
                                favouritesViewModel.imagesList.add(item)
                                favouritesListAdapter.notifyItemInserted(favouritesViewModel.imagesList.count())
                            }
                        } catch (e: Exception) {
                            Log.d("Exception", e.localizedMessage)
                        }
                    }.Error {
                        Log.d("Error", it.message)
                    }
            }
        }
    }

    fun onItemSelected(image: ImageFull) {
        val favourite = favouritesViewModel.favouritesList.find { it.imageId == image.id }

        if (favourite != null) {
            GlobalScope.launch {
                APIRepository().deleteFavourite(favouriteId = favourite.id)
                    .Success { response: HttpResponse ->
                        Log.d("Success", response.toString())

                        try {
                            Handler(Looper.getMainLooper()).post {
                                val itemPosition = favouritesViewModel.imagesList.indexOf(image)
                                favouritesViewModel.imagesList.remove(image)
                                favouritesListAdapter.notifyItemRemoved(itemPosition)
                            }
                        } catch (e: Exception) {
                            Log.d("Exception", e.localizedMessage)
                        }
                    }.Error {
                        Log.d("Error", it.message)
                    }
            }
        }
    }
}