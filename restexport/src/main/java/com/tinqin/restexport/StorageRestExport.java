package com.tinqin.restexport;

import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageOutput;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Headers({"Content-Type: application/json"})
public interface StorageRestExport {

    @RequestLine("GET /storage")
    FindAllStorageOutput findAll();

    @RequestLine("GET /storage/{id}")
    FindStorageByItemIdOutput findByItemId(@Param("id")  String id);
}

