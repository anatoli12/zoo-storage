package com.tinqin.storage.api.operation.storage.createstorage;

import com.tinqin.storage.api.base.ProcessorOutput;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateStorageOutput implements ProcessorOutput {
    private StorageBaseDTO storageBaseDTO;
}
