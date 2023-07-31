package com.tinqin.storage.api.operation.storage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StorageBaseDTO {
    private String id;
    private String itemId;
    private String price;
    private Integer quantity;
}
