package com.example.caltrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.caltrack.databinding.FragmentLogMealBinding

class LogMealFragment : Fragment() {
    private val viewModel: CalorieTrackerViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentLogMealBinding.inflate(inflater, container, false)

        // Log a meal when button is clicked
        binding.btnSaveMeal.setOnClickListener {
            val meal = Meal(
                name = binding.etMealName.text.toString(),
                calories = binding.etCalories.text.toString().toIntOrNull() ?: 0,
                imageUrl = "https://example.com/food.jpg"  // Placeholder
            )
            viewModel.addMeal(meal)
            Toast.makeText(requireContext(), "Meal saved!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
