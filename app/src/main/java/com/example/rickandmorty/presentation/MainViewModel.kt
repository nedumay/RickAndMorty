package com.example.rickandmorty.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.domain.model.InfoRick
import com.example.rickandmorty.domain.usecase.api.GetApiInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getApiInfoUseCase: GetApiInfoUseCase
) : ViewModel() {
    private var _infoListRick = MutableStateFlow<Resource<List<InfoRick>>>(Resource.Loading)
    val infoListRick = _infoListRick.asStateFlow()

    fun loadInfoListRick() {
        viewModelScope.launch {
            try {
                _infoListRick.value = Resource.Loading
                val data = getApiInfoUseCase.invoke()
                _infoListRick.value = Resource.Success(data)
            } catch (e: Exception) {
                _infoListRick.value = Resource.Error(e.message ?: "Unknown error")
            }
            Log.d("GetInfoRick", "ViewModel: ${_infoListRick.value}")
        }
    }
}