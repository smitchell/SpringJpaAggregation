package com.nocompany.service.report.repository;

import com.nocompany.service.report.domain.SettlementHistory;
import com.nocompany.service.report.dto.CategoryAmountSummary;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

public interface SettlementHistoryRepository extends JpaRepository<SettlementHistory, String> {

  Page<SettlementHistory> findAllByFundDateIsBetweenOrderByFundDate(
      @Param("rangeStart") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm'Z'") Date rangeStart,
      @Param("rangeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm'Z'") Date rangeEnd,
      Pageable pageable
  );

  @Query("SELECT new com.nocompany.service.report.dto.CategoryAmountSummary(h.organizationName, count(h.id), sum(h.fundedAmount)) FROM SettlementHistory h WHERE h.fundDate BETWEEN :rangeStart AND :rangeEnd GROUP BY h.organizationName ORDER BY h.organizationName")
  List<CategoryAmountSummary> summarizeFundedAmountByOrganizationWhereFundDateIsBetweenOrderByFundDate(
      @Param("rangeStart") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm'Z'") Date rangeStart,
      @Param("rangeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm'Z'") Date rangeEnd
  );

}
