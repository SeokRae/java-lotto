package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> collect = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
        lotto = Lotto.of(collect);
    }

    @DisplayName("로또 생성 및 match 된 숫자 테스트")
    @Test
    void match_로또_번호_생성_및_숫자매칭() {
        // given
        List<LottoNumber> collect = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
        Lotto given = Lotto.of(collect);
        // when
        long match = lotto.match(given);
        // then
        assertThat(match).isEqualTo(6);
    }

}
