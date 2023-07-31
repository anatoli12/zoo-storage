package com.tinqin.storage.api.operation.storage.changestoragequantity;

import com.tinqin.storage.api.base.ProcessorOutput;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangeStorageQuantityOutput implements ProcessorOutput {
    private StorageBaseDTO storageBaseDTO;
}
