package org.example.navigation.ui
import org.example.maxArea
import kotlin.reflect.KFunction

typealias EntryPoint = () -> Unit

class Navigation private constructor() {
    private val map = hashMapOf<String, EntryPoint>()

    private fun addEntryPoint(title:String, entryPoint: EntryPoint) {
        map.putIfAbsent(title,entryPoint)
    }

    private fun init() {

    }

    companion object {
        @JvmStatic
        private var instance: Navigation? = null

        fun getInstance(): Navigation {
            return instance ?: Navigation().also {
                it.init()
                instance = it
            }
        }
    }
}