package com.example.nit3213_assignment2_s4676997

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213_assignment2_s4676997.client_interface.PlantsApiService
import com.example.nit3213_assignment2_s4676997.data.PlantResponse
import com.example.nit3213_assignment2_s4676997.data.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    @Inject
    lateinit var plantsApiService: PlantsApiService

    private lateinit var plantAdapter: PlantAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView) // Make sure you have a RecyclerView in your layout
        recyclerView.layoutManager = LinearLayoutManager(context)
        plantAdapter = PlantAdapter(emptyList())
        recyclerView.adapter = plantAdapter

        // Fetch data with coroutines
        fetchPlants()

        return view
    }

    private fun fetchPlants() {
        plantsApiService.getPlants().enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    displayPlants(response.body()!!.entities)
                }
            }

            //Display Error message if fail to get information
            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                Log.e("DashboardFragment", "Error fetching plants", t)
            }
        })
    }

    private fun displayPlants(plants: List<Plant>) {
        // Update the adapter with the new data
        plantAdapter.updateData(plants)
    }
}