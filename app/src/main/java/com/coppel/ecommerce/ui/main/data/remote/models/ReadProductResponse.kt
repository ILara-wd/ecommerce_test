package com.coppel.ecommerce.ui.main.data.remote.models

import com.google.gson.annotations.SerializedName

data class ReadProductResponse(
    @SerializedName("products")
    val product: List<ProductResponse>
)

data class ProductResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("image")
    val image: String? = null
)