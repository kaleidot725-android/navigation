package jp.kaleidot725.navgraph.model

object Counter {
    var count: Int = 0
        private set

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }
}