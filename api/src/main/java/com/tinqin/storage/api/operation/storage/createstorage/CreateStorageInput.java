package com.tinqin.storage.api.operation.storage.createstorage;

import com.tinqin.storage.api.base.ProcessorInput;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@Builder
public class CreateStorageInput implements ProcessorInput {
    @UUID
    private String itemId;

    @Positive
    private double price;
}
