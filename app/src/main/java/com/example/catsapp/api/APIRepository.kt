package com.example.catsapp.api

import com.example.catsapp.models.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class APIRepository() {
    private var apiService = APIClient().apiService
    private val defaultHeaders = NetworkRequestHeaders().getDefaultHeaders()

    // Breeds
    suspend fun listCatBreeds(attachBreed: Int = 0, page: Int?, limit: Int?): Result<List<Breed>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.listCatBreeds(
                    headers = defaultHeaders,
                    attachBreed = attachBreed,
                    page = page,
                    limit = limit
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun searchBreed(queryString: String?): Result<List<Breed>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.searchBreed(
                    headers = defaultHeaders,
                    q = queryString
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    // Categories
    suspend fun listCategories(limit: Int?, page: Int?): Result<List<CategoryResponse>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.listCategories(
                    headers = defaultHeaders,
                    limit = limit,
                    page = page
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getVotes(subId: String?, limit: Int?, page: Int?): Result<List<Vote>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.getVotes(
                    headers = defaultHeaders,
                    subId = subId,
                    limit = limit,
                    page = page
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun createVote(createVoteRequest: VoteRequest): Result<VoteResponse> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.createVote(
                    headers = defaultHeaders,
                    body = createVoteRequest
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getVote(voteId: String): Result<Vote> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.getVote(
                    headers = defaultHeaders,
                    voteId = voteId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun deleteVote(voteId: String): Result<HttpResponse> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.deleteVote(
                    headers = defaultHeaders,
                    voteId = voteId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    // Favourites
    suspend fun getFavourites(subId: String?, limit: Int?, page: Int?): Result<List<Favourite>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.getFavourites(
                    headers = defaultHeaders,
                    subId = subId,
                    limit = limit,
                    page = page
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getFavourite(favouriteId: String): Result<Favourite> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.getFavourite(
                    headers = defaultHeaders,
                    favouriteId = favouriteId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun deleteFavourite(favouriteId: String): Result<HttpResponse> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.deleteFavourite(
                    headers = defaultHeaders,
                    favouriteId = favouriteId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun selectFavourite(selectFavouriteRequest: FavouriteRequest): Result<FavouriteResponse> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.selectFavourite(
                    headers = defaultHeaders,
                    body = selectFavouriteRequest
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    // Images
    suspend fun listPublicImages(
        size: String = "full",
        mimeTypes: List<String>?,
        order: String = "ASC",
        limit: Int = 1,
        page: Int = 0,
        categoryIds: List<Int>?,
        format: String = "json",
        breedId: String?
    ): Result<List<ImageFull>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.listPublicImages(
                    headers = defaultHeaders,
                    size = size,
                    mimeTypes = mimeTypes,
                    order = order,
                    limit = limit,
                    page = page,
                    categoryIds = categoryIds,
                    format = format,
                    breedId = breedId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun listPrivateImages(
        limit: Int = 1,
        page: Int = 1,
        order: String = "ASC",
        subId: String = "",
        breedIds: List<String>?,
        categoryIds: List<String>?,
        originalFilename: String = "",
        format: String = "json",
        includeVote: Int = 0,
        includeFavourite: Int = 0
    ): Result<List<ImageFull>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.listPrivateImages(
                    headers = defaultHeaders,
                    limit = limit,
                    page = page,
                    order = order,
                    subId = subId,
                    breedIds = breedIds,
                    categoryIds = categoryIds,
                    originalFilename = originalFilename,
                    format = format,
                    includeVote = includeVote,
                    includeFavourite = includeFavourite
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun uploadImage(): Result<HttpResponse> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.uploadImage(headers = defaultHeaders)
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getImage(imageId: String): Result<ImageFull> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.getImage(
                    headers = defaultHeaders,
                    imageId = imageId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun deleteImage(imageId: String): Result<HttpResponse> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.deleteImage(
                    headers = defaultHeaders,
                    imageId = imageId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getImageAnalysis(imageId: String): Result<List<ImageAnalysis>> = withContext(Dispatchers.IO) {
        try {
            Success(
                apiService.getImageAnalysis(
                    headers = defaultHeaders,
                    imageId = imageId
                )
            )
        } catch (e: Exception) {
            Error(e)
        }
    }
}