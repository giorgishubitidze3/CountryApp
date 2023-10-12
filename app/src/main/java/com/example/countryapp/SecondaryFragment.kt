package com.example.countryapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp.data.CountryAdapter
import com.example.countryapp.data.ViewModel

class SecondaryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary, container, false)
        val loadingView = view?.findViewById<ProgressBar>(R.id.progressBar)
        loadingView?.visibility = View.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loadingView = view?.findViewById<ProgressBar>(R.id.progressBar)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCountries)

        loadingView?.visibility = View.VISIBLE
        val adapter = CountryAdapter(emptyList())
        recyclerView.adapter = adapter


        viewModel.countryList.observe(viewLifecycleOwner) { countries ->
            Log.d("SecondaryFragment", "Received ${countries.size} countries")
            adapter.updateData(countries)
        }

        viewModel.isLoading.observe(viewLifecycleOwner){isLoading ->
            if(isLoading){
                loadingView?.visibility=View.VISIBLE
            }else{
                loadingView?.visibility=View.GONE
            }
        }




    }


}