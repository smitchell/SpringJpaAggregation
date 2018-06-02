package com.nocompany.service.report.projection;

import com.nocompany.service.report.domain.SettlementHistory;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "settlementHistoryView", types = {SettlementHistory.class})

public interface SettlementHistoryView {

  String getId();
  String getOrganizationId();
  String getOrganizationMemberId();
  String getOrganizationName();
  String getFirstName();
  String getLastName();
  String getTransferId();
  BigDecimal getFundedAmount();
  Date getFundDate();
  Date getTransactionDate();
  Date getPlanStatus();

}
