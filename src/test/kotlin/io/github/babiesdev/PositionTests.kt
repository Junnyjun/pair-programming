package io.github.babiesdev

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Position은")
class PositionTests {
    @ParameterizedTest
    @ValueSource(ints = [-1, 70])
    fun `0 ~ 69 사이를 벗어날 경우 예외가 발생한다`(value: Int) {
        assertThrows<IllegalArgumentException> { Position(value) }
            .apply { assertThat(message).isEqualTo("위치는 0 ~ 69 사이를 벗어날 수 없습니다. (현재: ${value})") }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 69])
    fun `0 ~ 69 사이의 위치를 생성할 수 있다`(value: Int) {
        assertDoesNotThrow { Position(value) }
    }
}
