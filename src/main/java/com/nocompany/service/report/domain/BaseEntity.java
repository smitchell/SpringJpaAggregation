package com.nocompany.service.report.domain;

import com.nocompany.service.report.validation.ValidationRegex;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
abstract class BaseEntity {

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  @Column(nullable = false)
  private Date lastModifiedDate;

  @CreatedBy
  @Column(updatable = false)
  @Pattern(regexp = ValidationRegex.UUID_PATTERN)
  private String createdBy;

  @LastModifiedBy
  @Pattern(regexp = ValidationRegex.UUID_PATTERN)
  private String updatedBy;

}