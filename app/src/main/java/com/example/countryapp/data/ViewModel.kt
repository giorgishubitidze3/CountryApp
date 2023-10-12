    package com.example.countryapp.data

    import android.util.Log
    import android.widget.ProgressBar
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import com.example.countryapp.network.RetrofitInstance
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.launch
    import kotlinx.coroutines.withContext
    import retrofit2.Call
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.countryapp.R
    import com.example.countryapp.SecondaryFragment
    import retrofit2.Retrofit

    class ViewModel: ViewModel() {
        private val _countryList: MutableLiveData<List<Country>> = MutableLiveData(emptyList())
        val countryList: LiveData<List<Country>> = _countryList

        private val _isLoading = MutableLiveData<Boolean>()
        val isLoading: LiveData<Boolean> = _isLoading

        fun fetchDataForRegion(region: String){
            viewModelScope.launch(Dispatchers.IO){
                try{
                    val response = when (region){
                        "europe" -> RetrofitInstance.api.getEurope()
                        "asia" -> RetrofitInstance.api.getAsia()
                        "africa" -> RetrofitInstance.api.getAfrica()
                        "south_america" -> RetrofitInstance.api.getSouthAmerica()
                        "north_america" -> RetrofitInstance.api.getNorthAmerica()
                        "australia" -> RetrofitInstance.api.getAustralia()
                        "antarctica" -> RetrofitInstance.api.getAntarctica()
                        else -> return@launch
                    }
                    _countryList.postValue(response)
                    _isLoading.postValue(false)


                    Log.d("ViewModel", "Fetched data for $region")
                }
                catch (e: Exception){
                    Log.e("ViewModel", "Error fetching data: ${e.message}")
                    _isLoading.postValue(false)
                }
            }

        }



    }