package com.example.rickandmorty.common

sealed class Resource<out T> {
    class Success<out T>(val data: T) : Resource<T>()
    class Error(val message: String) : Resource<Nothing>()
    data object Loading : Resource<Nothing>()

}