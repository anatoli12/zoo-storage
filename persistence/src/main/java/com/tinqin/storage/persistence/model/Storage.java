package com.tinqin.storage.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "storages")
public class Storage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "storage_id")
    private UUID id;

    private UUID itemId;

    private Integer quantity;

    private BigDecimal price;
}
