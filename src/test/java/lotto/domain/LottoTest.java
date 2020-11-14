package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 1장 생성")
    void createLotto() {
        Numbers numbers = makeRangeNumbers(0, 7);

        lotto = new Lotto(() -> numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}
