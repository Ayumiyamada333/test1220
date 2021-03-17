package com.example.test1220

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity: AppCompatActivity() {

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val productId = intent.getIntExtra("key_product_id", 1)
        val product = ProductManager.getProduct(productId)

        val name = product.name
        val message = product.message
        val imageUrl = product.imageUrl
        val price = product.price

        nameTextView.text = name
        messageTextView.text = message
        priceTextView.text = "${price}円"
        Picasso.get().load(imageUrl).into(productIconImageView)

        addCardButton.setOnClickListener {
            ProductManager.addCart(productId)
        }
    }
}