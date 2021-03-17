package com.example.test1220

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        initView()

        clearButton.setOnClickListener {
            ProductManager.resetCart()
            initView()
        }
    }

    private fun initView() {
        val product1 = ProductManager.product1
        val product2 = ProductManager.product2
        val productInCardMap = ProductManager.productInCardMap

        val count1 = productInCardMap[1] ?: 0
        val count2 = productInCardMap[2] ?: 0

        updateProductLayout(layoutCartProduct1, product1, count1)
        updateProductLayout(layoutCartProduct2, product2, count2)

        val totalPrice = product1.price * count1 + product2.price * count2

        totalPriceTextView.text = "${totalPrice}円"
    }

    private fun updateProductLayout(view: View, product: Product, count: Int) {
        view.findViewById<TextView>(R.id.nameTextView).text = product.name
        view.findViewById<TextView>(R.id.messageTextView).text = product.message
        view.findViewById<TextView>(R.id.priceTextView).text = "${product.price}円"
        view.findViewById<TextView>(R.id.countTextView).text = "$count"
        Picasso.get().load(product.imageUrl).into(view.findViewById<ImageView>(R.id.productImageView))
    }

}