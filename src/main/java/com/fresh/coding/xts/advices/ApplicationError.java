package com.fresh.coding.xts.advices;

import java.time.LocalDate;

public record ApplicationError<T>(
    T messages,
    LocalDate dateError,
    int Status
) { }
