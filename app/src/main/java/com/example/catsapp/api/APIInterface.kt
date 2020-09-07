package com.example.catsapp.api

import com.example.catsapp.models.*

import org.json.JSONObject
import retrofit2.http.*

interface APIInterface {
    // Breeds
    @GET("v1/breeds")
    suspend fun listCatBreeds(
        @Query("attach_breed") attachBreed: Int = 0,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @HeaderMap headers: Map<String, String>?
    ): List<Breed>

    @GET("v1/breeds/search")
    suspend fun searchBreed(
        @Query("q") q: String?,
        @HeaderMap headers: Map<String, String>?
    ): List<Breed>

    // Categories
    @GET("v1/categories")
    suspend fun listCategories(
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
        @HeaderMap headers: Map<String, String>?
    ): List<CategoryResponse>

    // Votes
    @GET("v1/votes")
    suspend fun getVotes(
        @Query("sub_id") subId: String?,
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
        @HeaderMap headers: Map<String, String>?
    ): List<Vote>

    @POST("v1/votes")
    suspend fun createVote(
        @Body body: VoteRequest,
        @HeaderMap headers: Map<String, String>?
    ): VoteResponse

    @GET("v1/votes/{vote_id}")
    suspend fun getVote(
        @Path("vote_id") voteId: String?,
        @HeaderMap headers: Map<String, String>?
    ): Vote

    @DELETE("v1/votes/{vote_id}")
    suspend fun deleteVote(
        @Path("vote_id") voteId: String?,
        @HeaderMap headers: Map<String, String>?
    ): HttpResponse

    // Favourites
    @GET("v1/favourites")
    suspend fun getFavourites(
        @Query("sub_id") subId: String?,
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
        @HeaderMap headers: Map<String, String>?
    ): List<Favourite>

    @GET("v1/favourites/{favourite_id}")
    suspend fun getFavourite(
        @Path("favourite_id") favouriteId: String?,
        @HeaderMap headers: Map<String, String>?
    ): Favourite

    @DELETE("v1/favourites/{favourite_id}")
    suspend fun deleteFavourite(
        @Path("favourite_id") favouriteId: String?,
        @HeaderMap headers: Map<String, String>?
    ): HttpResponse

    @POST("v1/favourites")
    suspend fun selectFavourite(
        @Body body: FavouriteRequest,
        @HeaderMap headers: Map<String, String>?
    ): FavouriteResponse

    // Images
    @GET("v1/images/search")
    suspend fun listPublicImages(
        @Query("size") size: String = "full",
        @Query("mime_types") mimeTypes: List<String>?,
        @Query("order") order: String = "ASC",
        @Query("limit") limit: Int = 1,
        @Query("page") page: Int = 0,
        @Query("category_ids") categoryIds: List<Int>?,
        @Query("format") format: String = "json",
        @Query("breed_id") breedId: String?,
        @HeaderMap headers: Map<String, String>?
    ): List<ImageFull>

    @GET("v1/images/search")
    suspend fun listPrivateImages(
        @Query("limit") limit: Int = 1,
        @Query("page") page: Int = 1,
        @Query("order") order: String = "ASC",
        @Query("sub_id") subId: String = "",
        @Query("breed_ids") breedIds: List<String>?,
        @Query("category_ids") categoryIds: List<String>?,
        @Query("original_filename") originalFilename: String = "",
        @Query("format") format: String = "json",
        @Query("include_vote") includeVote: Int = 0,
        @Query("include_favourite") includeFavourite: Int = 0,
        @HeaderMap headers: Map<String, String>?
    ): List<ImageFull>

    @POST("v1/images/upload")
    suspend fun uploadImage(
        @Body body: JSONObject = JSONObject(),
        @HeaderMap headers: Map<String, String>?
    ): HttpResponse

    @GET("v1/images/{image_id}")
    suspend fun getImage(
        @Path("image_id") imageId: String?,
        @HeaderMap headers: Map<String, String>?
    ): ImageFull

    @DELETE("v1/images/{image_id}")
    suspend fun deleteImage(
        @Path("image_id") imageId: String?,
        @HeaderMap headers: Map<String, String>?
    ): HttpResponse

    @GET("v1/images/{image_id}/analysis")
    suspend fun getImageAnalysis(
        @Path("image_id") imageId: String?,
        @HeaderMap headers: Map<String, String>?
    ): List<ImageAnalysis>
}