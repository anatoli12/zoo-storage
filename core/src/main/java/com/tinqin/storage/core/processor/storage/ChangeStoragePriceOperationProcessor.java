package com.tinqin.storage.core.processor.storage;

import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import com.tinqin.storage.api.operation.storage.changestorageprice.ChangeStoragePriceInput;
import com.tinqin.storage.api.operation.storage.changestorageprice.ChangeStoragePriceOperation;
import com.tinqin.storage.api.operation.storage.changestorageprice.ChangeStoragePriceOutput;
import com.tinqin.storage.persistence.model.Storage;
import com.tinqin.storage.persistence.repository.StorageRepository;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ChangeStoragePriceOperationProcessor implements ChangeStoragePriceOperation {
  private final StorageRepository storageRepository;

  @Override
  public ChangeStoragePriceOutput process(ChangeStoragePriceInput input) {
    Storage storage =
        storageRepository
            .findStorageByItemId(UUID.fromString(input.getItemId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    storage.setPrice(BigDecimal.valueOf(input.getPrice()));
    storageRepository.save(storage);

    return ChangeStoragePriceOutput.builder()
        .storageBaseDTO(
            StorageBaseDTO.builder()
                .price(String.valueOf(storage.getPrice()))
                .id(String.valueOf(storage.getId()))
                .itemId(String.valueOf(storage.getItemId()))
                .quantity(storage.getQuantity())
                .build())
        .build();
  }
}
