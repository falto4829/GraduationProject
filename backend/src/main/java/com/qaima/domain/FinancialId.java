package com.qaima.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class FinancialId implements Serializable {


    private Long stock;
    private LocalDate reportDate;
    private int version;

    public FinancialId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialId that = (FinancialId) o;
        return version == that.version &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(reportDate, that.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock, reportDate, version);
    }
}
