package com.tinqin.storage.core.processor.storage;

import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdInput;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdOperation;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdOutput;
import com.tinqin.storage.persistence.model.Storage;
import com.tinqin.storage.persistence.repository.StorageRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindStorageByItemIdOperationProcessor implements FindStorageByItemIdOperation {
  private final StorageRepository storageRepository;
  @Override
  public FindStorageByItemIdOutput process(FindStorageByItemIdInput input) {


    Storage storage =
        storageRepository
            .findStorageByItemId(UUID.fromString(input.getItemId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return FindStorageByItemIdOutput.builder()
        .storageBaseDTO(
            StorageBaseDTO.builder()
                .id(String.valueOf(storage.getId()))
                .itemId(String.valueOf(storage.getItemId()))
                .quantity(storage.getQuantity())
                .price(String.valueOf(storage.getPrice()))
                .build())
        .build();
  }
}
