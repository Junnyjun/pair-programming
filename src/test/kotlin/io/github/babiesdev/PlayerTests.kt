package io.github.babiesdev

import io.github.babiesdev.Participant.Player
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


@DisplayName("Player는")
class PlayerTests {
    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `한번에 최대 10칸 이내로 왼쪽으로 움직일 수 있다`(moveCount: Int) {
        val player: Participant = Player(Position(10))

        val movedPlayer = player.leftMove(moveCount)
        assertThat(movedPlayer.position).isEqualTo(Position(10 - moveCount))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `한번에 최대 10칸 이내로 오른쪽으로 움직일 수 있다`(moveCount: Int) {
        val player: Participant = Player(Position(0))

        val movedRabbit = player.rightMove(moveCount)

        assertThat(movedRabbit.position).isEqualTo(Position(moveCount))
    }

    @Test
    fun `한번에 10칸을 초과해서 오른쪽으로 이동할 경우 예외가 발생한다`() {
        val moveCount = 11
        val rabbit: Participant = Player(Position(0))

        assertThrows<IllegalArgumentException> { rabbit.leftMove(moveCount) }
            .apply { assertThat(message).isEqualTo("한번에 10칸을 초과해서 이동할 수 없습니다. (현재: ${moveCount})") }
    }

    @Test
    fun `한번에 10칸을 초과해서 왼쪽으로 이동할 경우 예외가 발생한다`() {
        val moveCount = 11
        val rabbit: Participant = Player(Position(0))

        assertThrows<IllegalArgumentException> { rabbit.rightMove(moveCount) }
            .apply { assertThat(message).isEqualTo("한번에 10칸을 초과해서 이동할 수 없습니다. (현재: ${moveCount})") }
    }
}
