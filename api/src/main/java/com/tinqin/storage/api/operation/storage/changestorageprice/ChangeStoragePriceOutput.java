package com.tinqin.storage.api.operation.storage.changestorageprice;

import com.tinqin.storage.api.base.ProcessorOutput;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ChangeStoragePriceOutput implements ProcessorOutput {
    private StorageBaseDTO storageBaseDTO;
}
