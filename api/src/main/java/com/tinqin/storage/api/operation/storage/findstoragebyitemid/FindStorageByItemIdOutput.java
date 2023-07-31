package com.tinqin.storage.api.operation.storage.findstoragebyitemid;

import com.tinqin.storage.api.base.ProcessorOutput;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindStorageByItemIdOutput implements ProcessorOutput {
    private StorageBaseDTO storageBaseDTO;
}
