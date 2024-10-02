package com.example.fundamentals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel: ViewModel() {

    private val _name= MutableLiveData<String>()
    private  val _sirName= MutableLiveData<String>()
    val name: LiveData<String> = _name
    val sirName: LiveData<String> = _sirName
    fun onNameUpdate(newName:String){
        _name.value = newName
    }
    fun onSirNameUpdate(newSirName: String){
        _sirName.value = newSirName
    }
}