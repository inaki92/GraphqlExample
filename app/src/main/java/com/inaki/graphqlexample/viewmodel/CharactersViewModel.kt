package com.inaki.graphqlexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.inaki.graphqlexample.CharactersListQuery
import com.inaki.graphqlexample.repository.Repository
import com.inaki.graphqlexample.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _charactersListLiveData by lazy {
        MutableLiveData<UIState<Response<CharactersListQuery.Data>>>(UIState.Loading())
    }
    val charactersList: LiveData<UIState<Response<CharactersListQuery.Data>>>
        get() = _charactersListLiveData

    fun queryCharacters() {
        _charactersListLiveData.postValue(UIState.Loading())

        viewModelScope.launch {
            try {
                val response = repository.queryCharactersList()
                // here we need to post into the livedata
                _charactersListLiveData.postValue(UIState.Success(response))
            } catch (e: Exception) {
                Log.e("CharactersViewModel", "Failure", e)
                // here I need to post error value to livedata
                _charactersListLiveData.postValue(UIState.Error(e))
            }
        }
    }






}