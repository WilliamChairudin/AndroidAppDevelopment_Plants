package com.example.nit3213_assignment2_s4676997

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        // Retrieve the plant data passed through Bundle
        val scientificName = arguments?.getString("Scientific Name: ")
        val commonName = arguments?.getString("Common Name: ")
        val careLevel = arguments?.getString("Care Level: ")
        val lightRequirement = arguments?.getString("Light Requirement: ")
        val description = arguments?.getString("Description: ")

        // Populate the UI components
        view.findViewById<TextView>(R.id.scientificName).text = "Scientific Name: $scientificName"
        view.findViewById<TextView>(R.id.commonName).text = "Common Name: $commonName"
        view.findViewById<TextView>(R.id.careLevel).text = "Care Level: $careLevel"
        view.findViewById<TextView>(R.id.lightRequirement).text = "Light Requirement: $lightRequirement"
        view.findViewById<TextView>(R.id.description).text = "Description: $description"

        // Handle the button click to go back to the dashboard
        val dashboardButton = view.findViewById<Button>(R.id.dashboardButton)
        dashboardButton.setOnClickListener {
            findNavController().navigate(R.id.Details_to_Dashboard)
        }

        // Return the view
        return view
    }
}