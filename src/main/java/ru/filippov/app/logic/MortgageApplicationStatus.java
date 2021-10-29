package ru.filippov.app.logic;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum MortgageApplicationStatus {
    PROCESSING, APPROVED, DENIED
}
