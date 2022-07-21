package dev.ted.supermarket.adapter.out.discountfetcher;

import dev.ted.supermarket.domain.DiscountRule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DiscountRuleTranslatorTest {

    @Test
    public void translatesRemoteRuleCode_n_ToNoneRule() throws Exception {
        String remoteNone = "n";

        assertThat(DiscountRuleTranslator.toRule(remoteNone))
                .isEqualByComparingTo(DiscountRule.NONE);
    }

    @Test
    public void translateRemoteRuleCode_t_ToTenPercentOffRule() throws Exception {
        String remoteTenPercentOff = "t";

        assertThat(DiscountRuleTranslator.toRule(remoteTenPercentOff))
                .isEqualByComparingTo(DiscountRule.TEN_PERCENT_OFF);

    }

    @Test
    public void translateUnknownRuleCodeToNoneRule() throws Exception {
        String remoteUnknown = "u";

        assertThat(DiscountRuleTranslator.toRule(remoteUnknown))
                .isEqualByComparingTo(DiscountRule.NONE);
    }

}