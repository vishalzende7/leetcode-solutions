package org.example.domain.`kotlin-collection`

import com.vishalzende.navigation.NavComponent


class PartitionAndTransform {
    operator fun invoke(nums: IntArray) {
        println(nums.groupBy { if(it % 2 == 0) 0 else 1 }.toSortedMap().flatMap { it.value.sorted() })

        data class Order(
            val symbol: String,
            val type: String,
            val price: Double,
            val filled: Boolean
        )

        val orders = listOf(
            Order("RELIANCE", "BUY", 2452.0, filled = true),
            Order("INFY", "SELL", 1502.0, filled = false),
            Order("TCS", "BUY", 3800.0, filled = true),
            Order("HDFC", "SELL", 1600.0, filled = false),
            Order("WIPRO", "BUY", 420.0, filled = true)
        )

        println(
            orders
                .groupBy { it.type }
                .mapValues { (_,set)->
                    set.sumOf { it.price }
                }
        )
    }
}

class PartitionAndTransformNav() : NavComponent() {
    override fun render() {
        PartitionAndTransform()(intArrayOf(5, 2, 9, 1, 4, 6, 8, 3))
    }
}