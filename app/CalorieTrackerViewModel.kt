package com.example.caltrack

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class CalorieTrackerViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private val mealsCollection = firestore.collection("meals")
    private val currentUserId = Firebase.auth.currentUser?.uid ?: ""

    // Add a new meal to Firestore
    fun addMeal(meal: Meal) {
        mealsCollection
            .document(currentUserId)
            .collection("userMeals")
            .add(meal)
            .addOnSuccessListener { Log.d("CalTracker", "Meal logged!") }
    }

    // Get today's total calories
    fun getTodayCalories(callback: (Int) -> Unit) {
        val today = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0) }.time

        mealsCollection
            .document(currentUserId)
            .collection("userMeals")
            .whereGreaterThan("timestamp", Timestamp(today))
            .get()
            .addOnSuccessListener { docs ->
                val total = docs.sumOf { it.toObject(Meal::class.java).calories }
                callback(total)
            }
    }
}
