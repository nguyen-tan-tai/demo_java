package com.example.designpatterns.behavioral;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-15<br>
 * tags: java, design patterns, behavioral, template method
 */
class TemplateMethodTest {

    static interface ExtractInterface {
        void doExtract();
    }

    static interface TransferInterface {
        void doTransfer();
    }

    static interface LoadInterface {
        void doLoad();
    }

    static abstract class GeneralEtl implements ExtractInterface, TransferInterface, LoadInterface {

        List<String> result = new ArrayList<>();

        public abstract void doExtract();

        @Override
        public void doLoad() {
            result.add("Loaded");
        }

        public List<String> doEtl() {
            this.doExtract();
            this.doTransfer();
            this.doLoad();
            return result;
        }
    }

    static class GoogleAdsEtl extends GeneralEtl {

        @Override
        public void doExtract() {
            result.add("GoogleExtracted");
        }

        @Override
        public void doTransfer() {
            result.add("GoogleTransfered");
        }
    }

    @Test
    public void test() {
        List<String> result = new GoogleAdsEtl().doEtl();
        assertThat(result).hasSize(3).containsExactly("GoogleExtracted", "GoogleTransfered", "Loaded");
    }
}
