import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    public static String input = "1,2";

    @BeforeEach
    void setUp() {
        input = "1,2";
    }

    @Test
    @DisplayName(",를 기준으로 string input을 숫자로 나누기")
    void from() {
        Expression expression = new Expression(input, new Splitters());

        assertThat(expression.getNumbers()).isEqualTo(new Numbers(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("sum 구하기")
    void sum() {
        Expression expression = new Expression(input, new Splitters());
        int sum = expression.sum();

        assertThat(sum).isEqualTo(3);
    }
}