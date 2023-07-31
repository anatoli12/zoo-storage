package com.tinqin.storage.api.operation.storage.findstoragebyitemid;

import com.tinqin.storage.api.base.ProcessorInput;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@Builder
public class FindStorageByItemIdInput implements ProcessorInput {
    @UUID
    String itemId;
}
