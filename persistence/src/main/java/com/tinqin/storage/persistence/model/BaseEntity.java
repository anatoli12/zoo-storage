package com.tinqin.storage.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
  @Column(name = "create_at")
  @CreationTimestamp
  private LocalDateTime createAt;

  @Column(name = "update_at")
  @UpdateTimestamp
  private LocalDateTime updateAt;


  @Column private boolean deleted;

  @Column(name = "delete_at")
  private LocalDateTime deleteAt;

}
