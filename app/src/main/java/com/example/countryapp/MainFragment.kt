package com.example.countryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.countryapp.data.ViewModel


class MainFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        view?.findViewById<Button>(R.id.btnEurope)?.setOnClickListener {
            viewModel.fetchDataForRegion("europe")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }

        view?.findViewById<Button>(R.id.btnAsia)?.setOnClickListener {
            viewModel.fetchDataForRegion("asia")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }
        view?.findViewById<Button>(R.id.btnNa)?.setOnClickListener {
            viewModel.fetchDataForRegion("north_america")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }
        view?.findViewById<Button>(R.id.btnSa)?.setOnClickListener {
            viewModel.fetchDataForRegion("south_america")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }
        view?.findViewById<Button>(R.id.btnAfrica)?.setOnClickListener {
            viewModel.fetchDataForRegion("africa")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }
        view?.findViewById<Button>(R.id.btnAntarctica)?.setOnClickListener {
            viewModel.fetchDataForRegion("antarctica")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }
        view?.findViewById<Button>(R.id.btnAustralia)?.setOnClickListener {
            viewModel.fetchDataForRegion("australia")
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondaryFragment)

        }



    }

}