package com.example.rickandmortyretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyretrofit.network.ApiClient
import com.example.rickandmortyretrofit.network.Character

class MainViewModel(private val repository: Repository
                    = Repository(ApiClient.apiService)
):ViewModel() {

    private var _charactersLiveData = MutableLiveData<List<Character>>()
    val characterLiveData: LiveData<List<Character>>
    get() = _charactersLiveData
}