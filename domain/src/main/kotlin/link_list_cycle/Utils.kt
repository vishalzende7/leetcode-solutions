package org.example.domain.link_list_cycle

fun generateIntersectingLists(
    listA: List<Int>,
    listB: List<Int>,
    skipA: Int,
    skipB: Int
): Pair<ListNode?, ListNode?> {

    val dummyA = ListNode(0)
    var currentA = dummyA
    var intersectionNode: ListNode? = null

    // 1. Build List A entirely
    for ((index, value) in listA.withIndex()) {
        val newNode = ListNode(value)
        currentA.next = newNode
        currentA = newNode

        // Save the reference to the exact node where the intersection should start
        if (index == skipA) {
            intersectionNode = newNode
        }
    }

    // 2. Build the first part of List B (up to the intersection)
    val dummyB = ListNode(0)
    var currentB = dummyB

    for (i in 0 until skipB) {
        val newNode = ListNode(listB[i])
        currentB.next = newNode
        currentB = newNode
    }

    // 3. Point the end of List B's prefix to the exact intersection node from List A
    currentB.next = intersectionNode

    return Pair(dummyA.next, dummyB.next)
}

fun printList(name: String, head: ListNode?) {
    var current = head
    print("$name: ")
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}