package com.example.catsapp.ui.breed

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.catsapp.R
import com.example.catsapp.api.APIRepository
import com.example.catsapp.api.Error
import com.example.catsapp.api.Success
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsapp.models.Breed
import kotlinx.android.synthetic.main.fragment_breed.*
import java.lang.Exception

class BreedFragment : Fragment() {
    private lateinit var breedViewModel: BreedViewModel
    private lateinit var breedListAdapter: BreedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        breedViewModel =
            ViewModelProviders.of(this).get(BreedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_breed, container, false)
        breedListAdapter = BreedListAdapter(breedViewModel.breedsList) { item ->
            onItemSelected(item)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        breedsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = breedListAdapter
        }
    }

    override fun onStart() {
        super.onStart()

        loadBreedList()
    }

    fun loadBreedList() {
        if (breedViewModel.breedsList.isEmpty()) {
            GlobalScope.launch {
                APIRepository().listCatBreeds(
                    attachBreed = 0,
                    page = null,
                    limit = null
                )
                    .Success { breeds: List<Breed> ->
                        Log.d("Success", breeds.toString())

                        try {
                            Handler(Looper.getMainLooper()).post {
                                breedViewModel.breedsList.addAll(breeds as ArrayList<Breed>)
                                breedListAdapter.notifyDataSetChanged()
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

    fun onItemSelected(breed: Breed) {
        val dialog = Dialog(this.requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.breed_dialog)

        val title = dialog.findViewById(R.id.breed_dialog_title) as TextView
        val origin = dialog.findViewById(R.id.breed_dialog_origin) as TextView
        val lifeSpan = dialog.findViewById(R.id.breed_dialog_life_span) as TextView
        val button = dialog.findViewById(R.id.favourite_item_button) as TextView

        title.text = breed.name
        origin.text = breed.origin
        lifeSpan.text = breed.lifeSpan + " average life span"

        button.text = "OK"
        button.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}