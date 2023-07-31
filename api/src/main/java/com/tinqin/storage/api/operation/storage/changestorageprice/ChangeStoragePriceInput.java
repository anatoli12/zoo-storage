package com.tinqin.storage.api.operation.storage.changestorageprice;

import com.tinqin.storage.api.base.ProcessorInput;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@Builder
public class ChangeStoragePriceInput implements ProcessorInput {
    @UUID
    private String itemId;
    @Positive
    private Double price;
}
