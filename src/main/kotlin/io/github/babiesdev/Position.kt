package io.github.babiesdev

data class Position(val value: Int) {
    init {
        if (value > 69) throw IllegalArgumentException("위치는 0 ~ 69 사이를 벗어날 수 없습니다. (현재: ${value})")
        if (value < 0) throw IllegalArgumentException("위치는 0 ~ 69 사이를 벗어날 수 없습니다. (현재: ${value})")
    }

}
