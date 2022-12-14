package com.example.coroutines.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutines.data.api.ApiHelper
import com.example.coroutines.learn.retrofit.parallel.ParallelNetworkCallsViewModel
import com.example.coroutines.learn.retrofit.series.SeriesNetworkCallsViewModel
import com.example.coroutines.learn.retrofit.single.SingleNetworkCallViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper) as T
        }

        if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
            return SeriesNetworkCallsViewModel(apiHelper) as T
        }

        if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
            return ParallelNetworkCallsViewModel(apiHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}