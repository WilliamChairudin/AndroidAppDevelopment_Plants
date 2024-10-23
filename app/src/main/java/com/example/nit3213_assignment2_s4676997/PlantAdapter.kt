package com.example.nit3213_assignment2_s4676997

import android.os.Bundle
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController
import com.example.nit3213_assignment2_s4676997.data.Plant
import javax.inject.Inject

class PlantAdapter (private var plants: List<Plant>) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>(){

    //initialize planviewholder
    class PlantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val commonNameTextView: TextView = view.findViewById(R.id.commonName)
        val scientificNameTextView: TextView = view.findViewById(R.id.scientificName)
        val careLevelTextView: TextView = view.findViewById(R.id.careLevel)
        val lightRequirementTextView: TextView = view.findViewById(R.id.lightRequirement)
        val detailsButton: Button = view.findViewById(R.id.detailsButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_layout, parent, false)
        return PlantViewHolder(view)
    }

    //binding all plants information to the view
    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plants[position]
        holder.scientificNameTextView.text = "Scientific Name: " + plant.scientificName
        holder.commonNameTextView.text = "Common Name: " + plant.commonName
        holder.careLevelTextView.text = "Care Level: " + plant.careLevel
        holder.lightRequirementTextView.text = "Light Requirement: " + plant.lightRequirement

        // Set an OnClickListener to the details button to navigate to PlantDetailsFragment
        holder.detailsButton.setOnClickListener {
            val bundle = Bundle().apply {
                putString("Scientific Name: ", plant.scientificName)
                putString("Common Name: ", plant.commonName)
                putString("Care Level: ", plant.careLevel)
                putString("Light Requirement: ", plant.lightRequirement)
                putString("Description: ", plant.description)
            }

            // Navigate to the PlantDetailsFragment, passing the plant details
            holder.itemView.findNavController().navigate(R.id.Dashboard_to_Details, bundle)
        }
    }

    override fun getItemCount(): Int = plants.size

    private fun showPlantDetails(context: Context, plant: Plant) {
        // Combine all details into a single message
        val detailsMessage = """
            Common Name: ${plant.commonName}
            Care Level: ${plant.careLevel}
            Light Requirement: ${plant.lightRequirement}
            Description: ${plant.description}
        """.trimIndent()

        // Implement a dialog or activity to show the details
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(plant.scientificName)
        dialog.setMessage(detailsMessage)
        dialog.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        dialog.show()
    }

    // Notify the adapter that the data has changed
    fun updateData(newPlants: List<Plant>) {
        plants = newPlants
        notifyDataSetChanged()
    }
}