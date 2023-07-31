package com.tinqin.storage.api.operation.storage.findallstorages;

import com.tinqin.storage.api.base.ProcessorOutput;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FindAllStorageOutput implements ProcessorOutput {
    private Set<StorageBaseDTO> storageBaseDTOSet;
}
