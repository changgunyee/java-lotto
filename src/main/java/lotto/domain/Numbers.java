package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(Builder builder) {
        this.numbers = builder.numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public static class Builder implements javafx.util.Builder<Numbers> {
        private List<Integer> numbers;

        public Builder(int startInclusive, int endExclusive) {
            numbers = IntStream.range(startInclusive, endExclusive)
                    .boxed()
                    .collect(Collectors.toList());
        }

        public Builder range(int fromIdx, int toIdx) {
            numbers = numbers.subList(fromIdx, toIdx);

            return this;
        }

        public Builder shuffle() {
            Collections.shuffle(numbers);

            return this;
        }

        public Builder sort() {
            Collections.sort(numbers);

            return this;
        }

        @Override
        public Numbers build() {
            return new Numbers(this);
        }
    }
}
