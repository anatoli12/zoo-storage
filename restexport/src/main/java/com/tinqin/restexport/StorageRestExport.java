package com.tinqin.restexport;

import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityInput;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityOutput;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageOutput;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdOutput;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

@Headers({"Content-Type: application/json"})
public interface StorageRestExport {

    @RequestLine("GET /storage")
    FindAllStorageOutput findAll();

    @RequestLine("GET /storage/{id}")
    FindStorageByItemIdOutput findByItemId(@Param("id") String id);

    @RequestLine("PUT /storage/quantity")
    ChangeStorageQuantityOutput updateStorageQuantity(@RequestBody ChangeStorageQuantityInput input);
}

