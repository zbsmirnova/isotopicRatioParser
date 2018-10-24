package zbsmirnova.isotopicRatioParser;

import zbsmirnova.isotopicRatioParser.model.IsotopicPb;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static zbsmirnova.isotopicRatioParser.model.Element.START_SEQ;

public class PbTestData {
    public static final int firstIsPb_ID = START_SEQ;
    public static final int secondIdPb_ID = START_SEQ + 1;
    public static final int thirdIsPb_ID = START_SEQ + 2;

    public static final IsotopicPb firstIsPb = new IsotopicPb(firstIsPb_ID,"firstPb", LocalDate.parse("2015-05-30"), 106.104,
            0.164, 106.107, 0.167, 106.108, 0.168);
    public static final IsotopicPb secondIsPb = new IsotopicPb(secondIdPb_ID,"secondPb", LocalDate.parse("2015-05-30"), 206.204,
            0.264, 206.207, 0.267, 206.208, 0.268);
    public static final IsotopicPb thirdIsPb = new IsotopicPb(thirdIsPb_ID, "thirdPb", LocalDate.parse("2015-05-30"), 306.304,
            0.364, 306.307, 0.367, 306.308, 0.368);

    public static IsotopicPb getNewPb(){
        return new IsotopicPb("newPb", LocalDate.now(), 406.404, 0.464
                , 406.407, 0.467, 406.408, 0.468);
    }

    public static void assertMatch(IsotopicPb actual, IsotopicPb expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<IsotopicPb> actual, IsotopicPb... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<IsotopicPb> actual, Iterable<IsotopicPb> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}
