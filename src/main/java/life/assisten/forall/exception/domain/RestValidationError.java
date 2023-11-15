package life.assisten.forall.exception.domain;

public record RestValidationError(
        Integer code,
        String field,
        String message) {
}
