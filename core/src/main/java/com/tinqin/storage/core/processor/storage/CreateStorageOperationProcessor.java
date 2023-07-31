package com.tinqin.storage.core.processor.storage;

import com.tinqin.restexport.ZooStoreRestExport;
import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import com.tinqin.storage.api.operation.storage.createstorage.CreateStorageInput;
import com.tinqin.storage.api.operation.storage.createstorage.CreateStorageOperation;
import com.tinqin.storage.api.operation.storage.createstorage.CreateStorageOutput;
import com.tinqin.storage.persistence.model.Storage;
import com.tinqin.storage.persistence.repository.StorageRepository;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStorageOperationProcessor implements CreateStorageOperation {

  private final StorageRepository storageRepository;
  private final ZooStoreRestExport zooStoreRestExport;

  @Override
  public CreateStorageOutput process(CreateStorageInput input) {
    System.out.println(zooStoreRestExport.findItemById(input.getItemId()));
    Storage storage =
        Storage.builder()
            .price(BigDecimal.valueOf(input.getPrice()))
            .quantity(0)
            .itemId(UUID.fromString(input.getItemId()))
            .build();
    storageRepository.save(storage);
    return CreateStorageOutput.builder()
        .storageBaseDTO(
            StorageBaseDTO.builder()
                .id(String.valueOf(storage.getId()))
                .quantity(storage.getQuantity())
                .itemId(String.valueOf(storage.getItemId()))
                .price(String.valueOf(storage.getPrice()))
                .build())
        .build();
  }
}
