package com.example.catsapp.api

sealed class Result<out T : Any>
class Success<out T : Any>(val data: T) : Result<T>()
class Error(private val exception: Throwable, val message: String = exception.localizedMessage) : Result<Nothing>()

inline fun <T : Any> Result<T>.Success(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data)
    return this
}
inline fun <T : Any> Result<T>.Error(action: (Error) -> Unit): Result<T> {
    if (this is Error) action(this)
    return this
}