package org.example.domain.link_list_cycle

class GetIntersectionNode {
//    operator fun invoke(headA: ListNode?, headB: ListNode?): ListNode? {
//        if (headA == null || headB == null) return null
//        if (headA.next == null || headB.next == null) return null
//
//        val seenNodes = mutableSetOf<ListNode>()
//
//        var first = headA.next
//        var second = headB.next
//
//        while (first != null || second != null) {
//            if (seenNodes.contains(first)) {
//                return first
//            }
//
//            if (seenNodes.contains(second)) {
//                return second
//            }
//            if (first != null) seenNodes.add(first)
//            if (second != null) seenNodes.add(second)
//
//            first = first?.next
//            second = second?.next
//        }
//
//        return null
//    }

    operator fun invoke(headA: ListNode?, headB: ListNode?): ListNode? {
        var ptrA = headA
        var ptrB = headB

        // Using the classic two-pointer technique to find the intersection
        while (ptrA !== ptrB) {
            ptrA = if (ptrA != null) ptrA.next else headB
            ptrB = if (ptrB != null) ptrB.next else headA
        }

        return ptrA
    }
}

fun main() {
    val listAValues = listOf(4, 1, 8, 4, 5)
    val listBValues = listOf(5, 6, 1, 8, 4, 5)
    val skipA = 2
    val skipB = 3

    val (headA, headB) = generateIntersectingLists(listAValues, listBValues, skipA, skipB)
    println(GetIntersectionNode()(headA,headB))
}