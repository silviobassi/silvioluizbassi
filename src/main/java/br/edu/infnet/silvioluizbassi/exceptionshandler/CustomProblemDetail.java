package br.edu.infnet.silvioluizbassi.exceptionshandler;

import lombok.Getter;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.time.LocalDateTime;

@Getter
public class CustomProblemDetail extends ProblemDetail {

    public CustomProblemDetail(String title, String detail, int statusCode) {
        super(statusCode);
        setTitle(formatTitle(title));
        setDetail(detail);
        setType(URI.create("https://infnet.com/%s".formatted(formatErrorType(title))));
        setProperty("timestamp", LocalDateTime.now());
    }

    private String formatErrorType(String className) {
        return className
                .replaceAll("([a-z])([A-Z])", "$1-$2")
                .replaceAll("Exception", "")
                .replaceAll("-$", "")
                .toLowerCase()
                .trim();
    }

    private String formatTitle(String className) {
        return className
                .replaceAll("([a-z])([A-Z])", "$1 $2")
                .replaceAll("Exception", "")
                .trim();
    }

}