package io.github.babiesdev.domain

import io.github.babiesdev.domain.Participant.Player
import io.github.babiesdev.domain.Participant.Rabbit

val DEFAULT_PLAYER = Player(Position(0))
val DEFAULT_RABBIT = Rabbit(Position(0))

interface Participant {
    fun leftMove(moveCount: Int): Participant
    fun rightMove(moveCount: Int): Participant
    val position: Position

    data class Player(override val position: Position) : Participant {
        override fun leftMove(moveCount: Int): Player = moved(position,-moveCount)
        override fun rightMove(moveCount: Int): Player = moved(position,+moveCount)

        private fun moved(position: Position, moveCount: Int): Player =
            if (Math.abs(moveCount) > 10) throw IllegalArgumentException("한번에 10칸을 초과해서 이동할 수 없습니다. (현재: ${Math.abs(moveCount)})")
            else Player(Position(position.value + moveCount))
    }

    data class Rabbit(override val position: Position) : Participant {
        override fun leftMove(moveCount: Int): Rabbit = moved(position,-moveCount)
        override fun rightMove(moveCount: Int): Rabbit = moved(position,+moveCount)

        private fun moved(position: Position, moveCount: Int): Rabbit =
            if (Math.abs(moveCount) > 5) throw IllegalArgumentException("한번에 5칸을 초과해서 이동할 수 없습니다. (현재: ${Math.abs(moveCount)})")
            else Rabbit(Position(position.value + moveCount))
    }


}