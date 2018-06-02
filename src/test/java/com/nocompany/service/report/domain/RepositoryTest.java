package com.nocompany.service.report.domain;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.nocompany.service.report.dto.CategoryAmountSummary;
import com.nocompany.service.report.repository.SettlementHistoryRepository;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class RepositoryTest {

  @Autowired
  private SettlementHistoryRepository settlementHistoryRepository;

  @Test
  public void testListAll() {
    List<SettlementHistory> all = settlementHistoryRepository.findAll();
    assertNotNull(all);
    assertEquals(10, all.size());
  }

  @Test
  public void testFindAllByFundDateIsBetweenOrderByFundDate() {
    Calendar rangeStart = Calendar.getInstance();
    rangeStart.set(2018,Calendar.MAY, 29);
    Calendar rangeEnd = Calendar.getInstance();
    rangeEnd.set(2018,Calendar.MAY, 31);
    Page<SettlementHistory> results =
        settlementHistoryRepository.findAllByFundDateIsBetweenOrderByFundDate(
            rangeStart.getTime(),
            rangeEnd.getTime(),
            new PageRequest(0, 10));
    assertNotNull(results);
    assertEquals(10, results.getNumberOfElements());

  }

  @Test
  public void testSummarizeFundedAmountByOrganizationWhereFundDateIsBetweenOrderByFundDate() {
    Calendar rangeStart = Calendar.getInstance();
    rangeStart.set(2018,Calendar.MAY, 29);
    Calendar rangeEnd = Calendar.getInstance();
    rangeEnd.set(2018,Calendar.MAY, 31);
    List<CategoryAmountSummary> results =
        settlementHistoryRepository.summarizeFundedAmountByOrganizationWhereFundDateIsBetweenOrderByFundDate(
            rangeStart.getTime(),
            rangeEnd.getTime());
    assertNotNull(results);
    assertEquals(5, results.size());
  }

}
