package com.example.caltrack

import com.google.firebase.Timestamp

data class Meal(
    val id: String = "",  
    val name: String = "",
    val calories: Int = 0,
    val imageUrl: String = "",  // For Glide loading
    val timestamp: Timestamp = Timestamp.now()  // Firestore timestamp
)
