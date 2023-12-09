package com.mohd.androidweb.boilerplates.with_client

data class DataModel(val id: Double,val title: String,val price: Double,val description: String,val category: String,val image: String,val rating: Rating) {
    override fun toString(): String {
        return "id=$id, title='$title', price=$price, description='$description', category='$category', image='$image', rating=$rating"
    }
}

data class Rating(val rate: Double,val count: Double)
