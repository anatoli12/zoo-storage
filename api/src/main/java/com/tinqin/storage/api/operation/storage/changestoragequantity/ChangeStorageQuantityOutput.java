package com.tinqin.storage.api.operation.storage.changestoragequantity;

import com.tinqin.storage.api.base.ProcessorOutput;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeStorageQuantityOutput implements ProcessorOutput {
    private StorageBaseDTO storageBaseDTO;
}
