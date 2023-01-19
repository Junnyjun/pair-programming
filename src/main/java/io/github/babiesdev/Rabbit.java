package io.github.babiesdev;

public record Rabbit(Position position) {

    public Rabbit leftMove(int moveCount) {
        validateRange(moveCount);
        return new Rabbit(new Position(positionValue() - moveCount));
    }

    public Rabbit rightMove(int moveCount) {
        validateRange(moveCount);
        return new Rabbit(new Position(positionValue() + moveCount));
    }

    public Position position() {
        return position;
    }

    public int positionValue() {
        return position.value();
    }

    private void validateRange(int value) {
        if(value < 1 || value > 5) {
            throw new IllegalArgumentException(String.format("이동할 수 있는 거리는 1 ~ 5 사이의 값이어야 합니다. (현재: %d)", value));
        }
    }
}