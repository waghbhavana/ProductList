package com.bhavanawagh.testapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bhavanawagh.testapplication.data.Product


class MainActivity : ComponentActivity() {


    val viewModel: ProductViewModel by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val productList by viewModel.productList.collectAsState()
            ShowProducts(productList = productList)
        }

    }


    @Composable
    fun ShowProducts(productList: List<Product>) {
        LazyRow(contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp)) {
            items(
                items = productList,
                itemContent = {
                    ProductListItem(product = it)
                }
            )
        }
    }

    @Composable
    fun ProductListItem(product: Product) {
        Row(modifier = Modifier.padding(8.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                AsyncImage(
                    model = product.thumbnail,
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
                Text(text = product.title)
            }
        }
    }


}