package study.lotto.view.dto;

import study.lotto.domain.LottoNumber;
import study.lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequestWinningNumber {

    public static final String NUMBER_DELIMINATOR = ",";
    public static final String PARSE_INT_EXCEPTION = "변환 불가";

    private final List<LottoNumber> winningNumbers;

    public RequestWinningNumber(final String inputWinningNumber) {
        String[] split = inputWinningNumber.split(NUMBER_DELIMINATOR);
        winningNumbers = extractWinningNumbers(split);
    }

    private List<LottoNumber> extractWinningNumbers(final String[] split) {
        return Arrays.stream(split)
                .map(this::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private int parseInt(final String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch(NumberFormatException e) {
            throw new LottoException(PARSE_INT_EXCEPTION);
        }
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(winningNumbers);
    }
}
