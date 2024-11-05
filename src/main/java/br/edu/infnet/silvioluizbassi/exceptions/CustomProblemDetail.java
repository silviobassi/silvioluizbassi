package br.edu.infnet.silvioluizbassi.exceptions;

import lombok.Getter;
import org.springframework.http.ProblemDetail;

import java.net.URI;

@Getter
public class CustomProblemDetail extends ProblemDetail {

    private final String typeError;

    public CustomProblemDetail(int statusCode, String title, String detail, String typeError) {
        super(statusCode);
        this.typeError = typeError;
        this.setTitle(formatTitle(title));
        this.setDetail(detail);
        this.setType(URI.create("https://br.edu.infnet.silvioluizbassi/%s".formatted(formatErrorType(typeError))));
    }

    private String formatErrorType(String className) {
        return className
                .replaceAll("([a-z])([A-Z])", "$1-$2")
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
