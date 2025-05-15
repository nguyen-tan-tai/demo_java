package com.example.designpatterns.creational;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-08 tags: java, design patterns, creational, builder
 */
class BuilderTest {

    public static enum ErrorCode {
        INVALID_ACCOUNT, NOT_FOUND
    }

    public static class ErrorDetail {

        private String subCode;
        private String detail;

        public ErrorDetail(String subCode, String detail) {
            this.subCode = subCode;
            this.detail = detail;
        }

        public String getSubCode() {
            return subCode;
        }

        public void setSubCode(String subCode) {
            this.subCode = subCode;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public static class ErrorMessage {

        private ErrorCode errorCode;
        private String message;
        private List<ErrorDetail> errorDetails;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ErrorCode getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(ErrorCode errorCode) {
            this.errorCode = errorCode;
        }

        public List<ErrorDetail> getErrorDetails() {
            return errorDetails;
        }

        public void setErrorDetails(List<ErrorDetail> errorDetails) {
            this.errorDetails = errorDetails;
        }
    }

    public interface Builder {

        Builder setErrorCode(ErrorCode errorCode);

        Builder setMessage(String message);

        Builder setErrorDetail(List<ErrorDetail> errorDetails);

        Builder appendErrorDetail(ErrorDetail errorDetail);

        Builder appendErrorDetails(List<ErrorDetail> errorDetails);

        ErrorMessage build();
    }

    public static class ErrorMessageBuilder implements Builder {

        private ErrorCode errorCode;
        private String message;
        private List<ErrorDetail> errorDetails = new ArrayList<>();

        @Override
        public ErrorMessageBuilder setErrorCode(ErrorCode errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        @Override
        public ErrorMessageBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public ErrorMessageBuilder setErrorDetail(List<ErrorDetail> errorDetails) {
            if (errorDetails == null) {
                this.errorDetails = new ArrayList<>();
            } else {
                this.errorDetails = errorDetails;
            }
            return this;
        }

        @Override
        public ErrorMessageBuilder appendErrorDetail(ErrorDetail errorDetail) {
            if (this.errorDetails == null) {
                this.errorDetails = new ArrayList<>();
            }
            this.errorDetails.add(errorDetail);
            return this;
        }

        @Override
        public Builder appendErrorDetails(List<ErrorDetail> errorDetails) {
            if (this.errorDetails == null) {
                this.errorDetails = new ArrayList<>();
            }
            this.errorDetails.addAll(errorDetails);
            return null;
        }

        @Override
        public ErrorMessage build() {
            ErrorMessage e = new ErrorMessage();
            e.setMessage(message);
            e.setErrorCode(errorCode);
            e.setErrorDetails(errorDetails);
            return e;
        }
    }

    @Test
    public void test() {
        ErrorMessage e = new ErrorMessageBuilder()
                .setErrorCode(ErrorCode.INVALID_ACCOUNT)
                .setMessage("Invalid account")
                .setErrorDetail(new ArrayList<>(Arrays.asList(new ErrorDetail("190", "Account is inactive"))))
                .appendErrorDetail(new ErrorDetail("180", "Account is pending for deletion"))
                .build();
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ACCOUNT);
        assertThat(e.getMessage()).isEqualTo("Invalid account");
        List<ErrorDetail> errorDetails = e.getErrorDetails();
        assertThat(errorDetails).hasSize(2);
        assertThat(errorDetails.get(0).getSubCode()).isEqualTo("190");
        assertThat(errorDetails.get(1).getSubCode()).isEqualTo("180");

        ErrorMessage emptyMessage = new ErrorMessageBuilder().build();
        assertThat(emptyMessage.getErrorCode()).isNull();
        assertThat(emptyMessage.getMessage()).isNull();
        assertThat(emptyMessage.getErrorDetails()).isEmpty();
    }

    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder("hoge");
        sb.append("fuga");
        assertThat(sb.toString()).isEqualTo("hogefuga");
        sb.setLength(7);
        assertThat(sb.toString()).isEqualTo("hogefug");
        sb.setCharAt(0, 'H');
        assertThat(sb.toString()).isEqualTo("Hogefug");
    }

    @Test
    public void testHttpRequestBuilder() throws URISyntaxException {
        URI uri = new URI("https://example.com/get");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header("hoge", "fuga")
                .timeout(Duration.ofSeconds(10L))
                .build();
        assertThat(request.uri().toString()).isEqualTo(uri.toString());
        assertThat(request.timeout().get().getSeconds()).isEqualTo(10L);
        assertThat(request.headers().firstValue("hoge").get()).isEqualTo("fuga");
    }
}
