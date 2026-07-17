package org.example.domain.kotlin


class AverageAgeByCities {
    operator fun invoke(people: List<Person>) {
        println(
            people.groupBy { it.city }.map { e -> e.key to e.value.map { it.age }.average() }
        )
    }
}


data class Person(val name: String, val age: Int, val city: String)