package io.github.handler.output

interface OutputHandler {
    fun handle(message: String)

    class First(
        private val output: Output
    ) : OutputHandler {
        override fun handle(message: String) = output.write("안녕하세요 ${message}님")
    }
}