package org.example.domain.link_list_cycle

class LinkedListCycle {
    operator fun invoke(head: ListNode?): Boolean {
        if (head == null) return false

        var s = head
        var f = head.next
        while (f != null && f.next != null) {
            s = s?.next
            f = f.next?.next

            if (f == s) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val head = ListNode(3)
    val n2 = ListNode(2)
    val n3 = ListNode(0)
    val n4 = ListNode(-4)
    head.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = head

    var h: ListNode? = head
//    while (h != null) {
//        println(h.`val`)
//        h = h.next
//    }
    println(LinkedListCycle()(head))
}