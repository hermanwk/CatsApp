package com.example.catsapp.ui.vote

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.catsapp.BuildConfig

import kotlinx.android.synthetic.main.fragment_vote.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import com.example.catsapp.R
import com.example.catsapp.api.APIRepository
import com.example.catsapp.api.Error
import com.example.catsapp.api.Success
import com.example.catsapp.models.*

import com.squareup.picasso.Picasso
import java.lang.Exception

class VoteFragment : Fragment() {
    private lateinit var voteViewModel: VoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        voteViewModel =
            ViewModelProviders.of(this).get(VoteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_vote, container, false)
        val btnLoveIt = root.findViewById<Button>(R.id.button_love)
        val btnNopeIt = root.findViewById<Button>(R.id.button_nope)
        val btnFavourite = root.findViewById<Button>(R.id.button_favourite)
        btnFavourite.text = voteViewModel.favIt

        btnLoveIt?.setOnClickListener()
        {
            onVoteClick(true)
        }

        btnNopeIt?.setOnClickListener()
        {
            onVoteClick(false)
        }

        btnFavourite?.setOnClickListener()
        {
            onFavouriteClick()
        }

        return root
    }

    override fun onStart() {
        super.onStart()

        loadNewImage()
    }

    fun loadNewImage() {
        // Clear favourited image
        voteViewModel.favouriteId = ""

        GlobalScope.launch {
            APIRepository().listPublicImages(
                size = "full",
                mimeTypes = null,
                order = "RANDOM",
                limit = 1,
                page = 0,
                categoryIds = null,
                format = "json",
                breedId = null
            )
                .Success { images: List<ImageFull> ->
                    Log.d("Success", images.toString())

                    if (images.count() > 0 && favourite_image_view != null) {
                        val image = images[0]
                        voteViewModel.currentImageID = image.id

                        try {
                            Handler(Looper.getMainLooper()).post {
                                Picasso.get().load(image.url).into(favourite_image_view)
                            }
                        } catch (e: Exception) {
                            Log.d("Exception", e.localizedMessage)
                        }
                    }
                }.Error {
                    Log.d("Error", it.message)
                }
        }
    }

    fun onVoteClick(upVote: Boolean) {
        val voteRequest = VoteRequest(
            imageId = voteViewModel.currentImageID,
            subId = BuildConfig.CAT_API_USER_ID,
            value = upVote
        )

        GlobalScope.launch {
            APIRepository().createVote(createVoteRequest = voteRequest)
                .Success { response: VoteResponse ->
                    Log.d("Success", response.message)
                    loadNewImage()
                }.Error {
                    Log.d("Error", it.message)
                }
        }
    }

    fun onFavouriteClick() {
        if (voteViewModel.favouriteId.isEmpty()) {
            val favouriteRequest = FavouriteRequest(
                imageId = voteViewModel.currentImageID,
                subId = BuildConfig.CAT_API_USER_ID
            )

            GlobalScope.launch {
                APIRepository().selectFavourite(selectFavouriteRequest = favouriteRequest)
                    .Success { response: FavouriteResponse ->
                        Log.d("Success", response.id.toString())
                        try {
                            Handler(Looper.getMainLooper()).post {
                                voteViewModel.favouriteId = response.id.toString()
                                updateFavouriteButton()
                            }
                        } catch (e: Exception) {
                            Log.d("Exception", e.localizedMessage)
                        }
                    }.Error {
                        Log.d("Error", it.message)
                    }
            }
        } else {
            GlobalScope.launch {
                APIRepository().deleteFavourite(favouriteId = voteViewModel.favouriteId)
                    .Success { response: HttpResponse ->
                        Log.d("Success", response.message)
                        try {
                            Handler(Looper.getMainLooper()).post {
                                voteViewModel.favouriteId = ""
                                updateFavouriteButton()
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

    fun updateFavouriteButton() {
        if (voteViewModel.favouriteId.isEmpty()) {
            button_favourite.text = voteViewModel.favIt
            button_favourite.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_favorite_pink_24dp, 0, 0)
        } else {
            button_favourite.text = voteViewModel.unfavIt
            button_favourite.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_favorite_border_pink_24dp, 0, 0)
        }
    }
}