package com.example.rickandmorty.domain.usecase.api

import com.example.rickandmorty.domain.repository.RepositoryApi
import javax.inject.Inject

class GetApiInfoUseCase @Inject constructor(private val repositoryApi: RepositoryApi) {
    suspend operator fun invoke() = repositoryApi.getInfoRick()
}