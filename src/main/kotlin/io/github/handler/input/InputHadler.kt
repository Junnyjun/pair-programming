package io.github.handler.input

interface InputHadler {
    fun handle(): Input.InputData

    class Player(
        private val input: Input
    ) : InputHadler {
        override fun handle(): Input.InputData =
            try {
                input.read()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                this.handle()
            }
    }

    class Rabbit(
        private val input: Input
    ) : InputHadler {
        override fun handle(): Input.InputData =
            try {
                input.read()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                this.handle()
            }
    }

}
