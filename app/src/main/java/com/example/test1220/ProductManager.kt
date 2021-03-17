package com.example.test1220

object ProductManager {

    val productInCardMap = mutableMapOf<Int, Int>() // productIdをKeyとしてカートに入れたアイテムの個数を持つ

    val product1 = Product().apply {
        id = 1
        name = "おすすめ商品１"
        message = "おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。おすすめ商品１のメッセージです。"
        imageUrl = "https://1.bp.blogspot.com/-b4XGWvTniag/XTPoITs9EkI/AAAAAAABTwU/lxb5GsbYOiQmBtq5z1BpayDBKtBOKlTLwCLcBGAs/s800/food_suigyouza.png"
        price = 1000
    }

    val product2 = Product().apply {
        id = 2
        name = "おすすめ商品２"
        message = "これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。これは商品２ですおすすめですよ。"
        imageUrl = "https://1.bp.blogspot.com/-X-ACt31xexI/XobLb0YareI/AAAAAAABYBw/qXR5Jgz9-IUpMILeGf83MREZk3fM4AKwACNcBGAsYHQ/s1600/kansen_yobou_animal4.png"
        price = 500
    }

    fun getProduct(productId: Int): Product {
        if (productId == 1)
            return product1
        return product2
    }

    fun getAllProducts(): List<Product> {
        return listOf(product1, product2)
    }

    fun addCart(productId: Int) {
        var currentCount = productInCardMap[productId] ?: 0
        currentCount ++
        productInCardMap[productId] = currentCount
    }

    fun removeCart(productId: Int) {
        var currentCount = productInCardMap[productId] ?: 0
        if (currentCount > 0)
            currentCount --
        productInCardMap[productId] = currentCount
    }

    fun resetCart() {
        productInCardMap.clear()
    }
}