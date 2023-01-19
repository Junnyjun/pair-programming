package io.github.babiesdev

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Rabbit은")
class RabbitTests {
    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `한번에 최대 5칸 이내로 왼쪽으로 움직일 수 있다`(moveCount: Int) {
        val rabbit: Participant = Rabbit(Position(5))

        val movedRabbit = rabbit.leftMove(moveCount)

        assertThat(movedRabbit.position).isEqualTo(Position(5 - moveCount))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `한번에 최대 5칸 이내로 오른쪽으로 움직일 수 있다`(moveCount: Int) {
        val rabbit: Participant = Rabbit(Position(0))

        val movedRabbit = rabbit.rightMove(moveCount)

        assertThat(movedRabbit.position).isEqualTo(Position(moveCount))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `한번에 5칸을 초과해서 오른쪽으로 이동할 경우 예외가 발생한다`(moveCount: Int) {
        val rabbit: Participant = Rabbit(Position(5))

        assertThrows<IllegalArgumentException> { rabbit.leftMove(moveCount) }
            .apply { assertThat(message).isEqualTo("한번에 5칸을 초과해서 이동할 수 없습니다. (현재: ${moveCount})") }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `한번에 5칸을 초과해서 왼쪽으로 이동할 경우 예외가 발생한다`(moveCount: Int) {
        val rabbit: Participant = Rabbit(Position(0))

        assertThrows<IllegalArgumentException> { rabbit.rightMove(moveCount) }
            .apply { assertThat(message).isEqualTo("한번에 5칸을 초과해서 이동할 수 없습니다. (현재: ${moveCount})") }
    }
}
