package com.bhavanawagh.testapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavanawagh.testapplication.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val networkApi = RetrofitInstance.service
    private val _productList = MutableStateFlow<List<Product>>(emptyList())
    val productList: StateFlow<List<Product>> = _productList

    init {
        getProducts()
    }

    private fun getProducts() {

        viewModelScope.launch {
            try {
                val result = networkApi.getProducts()
                if (result.isSuccessful) {
                    println("result ${result.body()?.products}")
                    _productList.value = result.body()?.products!!
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}