package io.github.babiesdev

import io.github.babiesdev.domain.Participant

interface Output {

    class Console : Output {
        override fun write(message: String) = println(message)
        override fun write(message: Participant.Rabbit) = println("PLAYER POSITION :: ${message}")
        override fun write(message: Participant.Player) = println("RABBIT POSITION :: ${message}")
    }

    fun write(message: String)
    fun write(message: Participant.Rabbit)
    fun write(message: Participant.Player)
}