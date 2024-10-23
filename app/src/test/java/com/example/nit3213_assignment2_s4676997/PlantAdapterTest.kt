package com.example.nit3213_assignment2_s4676997

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213_assignment2_s4676997.R
import com.example.nit3213_assignment2_s4676997.data.Plant
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class PlantAdapterTest {

    @Mock
    private lateinit var mockContext: Context

    @Mock
    private lateinit var mockViewGroup: ViewGroup

    @Mock
    private lateinit var mockNavController: NavController

    @Mock
    private lateinit var mockView: View


    private val mockPlants = listOf(
        Plant("Scientific Name 1", "Common Name 1", "Care Level 1", "Light Requirement 1", "Description 1"),
        Plant("Scientific Name 2", "Common Name 2", "Care Level 2", "Light Requirement 2", "Description 2")
    )

    @Before
    fun setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this)

        // Initialize the ViewGroup's context mock
        `when`(mockViewGroup.context).thenReturn(mockContext)

        // Mock the detailsButton to return a real View
        mockView = LayoutInflater.from(mockContext).inflate(R.layout.items_layout, mockViewGroup, false)
        `when`(mockView.findViewById<View>(R.id.detailsButton)).thenReturn(mock(View::class.java))

    }

    @Test
    fun testOnBindViewHolder_navigatesOnButtonClick() {
        // Arrange
        `when`(mockViewGroup.context).thenReturn(mockContext) // Mock context for view group

        // Create adapter with mocked plants
        val adapter = PlantAdapter(mockPlants)

        // Create a mock ViewHolder using the mocked view
        val holder = adapter.onCreateViewHolder(mockViewGroup, 0)
        `when`(holder.itemView).thenReturn(mockView)

        // Mock NavController and set it to the view
        Navigation.setViewNavController(mockView, mockNavController)

        // Act - Bind the ViewHolder and simulate button click
        adapter.onBindViewHolder(holder, 0)
        mockView.findViewById<View>(R.id.detailsButton).performClick()

        // Capture the arguments passed to the NavController's navigate method
        val captor = ArgumentCaptor.forClass(Bundle::class.java)
        verify(mockNavController).navigate(eq(R.id.Dashboard_to_Details), captor.capture())

        val bundle = captor.value

        // Assert that the bundle contains correct plant details
        assertEquals("Scientific Name 1", bundle.getString("scientificName"))
        assertEquals("Common Name 1", bundle.getString("commonName"))
        assertEquals("Care Level 1", bundle.getString("careLevel"))
        assertEquals("Light Requirement 1", bundle.getString("lightRequirement"))
        assertEquals("Description 1", bundle.getString("description"))
    }
}