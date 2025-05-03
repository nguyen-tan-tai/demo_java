package com.example.regex;

import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class EmailRegexTest {

    public boolean isMatch(String pattern, String test) {
        return Pattern.compile(pattern).matcher(test).matches();
    }

    @Test
    public void test() {
        Assertions.assertThat(isMatch("^(.+)@(\\S+)$", "a@b")).isTrue();

        String complexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Assertions.assertThat(isMatch(complexPattern, "a@b.com")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "tantan+tai@domain.com")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "tantantaidomain.com")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "tantantai@domain com")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "+tantantai@domain.com")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "tantantai@domain.com+")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "tantantai@gma+il.com")).isFalse();
        Assertions.assertThat(isMatch(complexPattern, "tantantai@sub.domain.com")).isTrue();
        Assertions.assertThat(isMatch(complexPattern, "tantantai@domain.com")).isTrue();
        Assertions.assertThat(isMatch(complexPattern, "tantan.tai@x.com")).isFalse();

        String gmailPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
        Assertions.assertThat(isMatch(gmailPattern, "tantan+tai@domain.com")).isTrue();
        Assertions.assertThat(isMatch(gmailPattern, "tantan.tai@domain.com")).isTrue();
        Assertions.assertThat(isMatch(gmailPattern, "tantan.tai@sub.domain.com")).isTrue();
        Assertions.assertThat(isMatch(gmailPattern, "tantan.tai@x.com")).isFalse();

        String rf5322Pattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Assertions.assertThat(isMatch(rf5322Pattern, "tantan.tai@x.com")).isTrue();
        Assertions.assertThat(isMatch(rf5322Pattern, "tantan+tai@x.com")).isTrue();
        Assertions.assertThat(isMatch(rf5322Pattern, "tantan-tai@x.com")).isTrue();
    }
}
