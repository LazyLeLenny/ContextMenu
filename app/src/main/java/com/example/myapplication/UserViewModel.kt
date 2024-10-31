package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity.Person

class UserViewModel : ViewModel() {
    var list = mutableListOf<Person>()
    val currentList:  MutableLiveData<MutableList<MainActivity.Person>> by lazy { MutableLiveData<MutableList<MainActivity.Person>>() }
}