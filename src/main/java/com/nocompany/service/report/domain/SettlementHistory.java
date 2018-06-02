package com.nocompany.service.report.domain;

import com.nocompany.service.report.validation.ValidationRegex;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SettlementHistory extends BaseEntity implements Serializable {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column
  @NotNull
  private String organizationName;

  @Column
  @NotNull
  @Pattern(regexp = ValidationRegex.UUID_PATTERN)
  private String organizationId;

  @Column(nullable = false, updatable = false)
  @Pattern(regexp = ValidationRegex.UUID_PATTERN)
  @NotNull
  private String organizationMemberId;

  @Column
  @NotNull
  private String firstName;

  @Column
  @NotNull
  private String lastName;

  @Column(precision = 7, scale = 2, nullable = false)
  private BigDecimal fundedAmount;

  @Temporal(TemporalType.TIMESTAMP)
  @Column
  @NotNull
  private Date fundDate = new Date();

  @Enumerated(EnumType.STRING)
  @Column
  @NotNull
  private InstallmentPlanStatus planStatus;

}
