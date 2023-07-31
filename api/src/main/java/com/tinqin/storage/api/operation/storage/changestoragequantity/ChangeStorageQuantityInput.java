package com.tinqin.storage.api.operation.storage.changestoragequantity;

import com.tinqin.storage.api.base.ProcessorInput;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@Builder
public class ChangeStorageQuantityInput implements ProcessorInput {
    @UUID
    private String itemId;
    private Integer quantity;
}
