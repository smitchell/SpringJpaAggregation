package com.nocompany.service.report.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryAmountSummary implements Serializable {

  public CategoryAmountSummary(final String categoryName, final Long quantity, final Double categoryTotal) {
    this.categoryName = categoryName;
    this.quantity = quantity;
    this.categoryTotal = categoryTotal;
  }

  public CategoryAmountSummary(final String categoryName, final Long quantity, final BigDecimal categoryTotal) {
    this.categoryName = categoryName;
    this.quantity = quantity;
    this.categoryTotal = categoryTotal.doubleValue();
  }
  private String categoryName;

  private Double categoryTotal;

  private Long quantity;

}
