package io.github.handler.output

interface Output {
    fun write(message: String)

    class Console : Output {
        override fun write(message: String) = println(message)
    }


}