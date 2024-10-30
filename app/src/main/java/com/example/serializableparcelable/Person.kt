package com.example.serializableparcelable

import java.io.Serializable

data class Person(val name: String, val lastName: String, val adress: String, val phone: String) : Serializable