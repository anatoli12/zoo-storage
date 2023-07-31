package com.tinqin.storage.core.processor.storage;

import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityInput;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityOperation;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityOutput;
import com.tinqin.storage.persistence.model.Storage;
import com.tinqin.storage.persistence.repository.StorageRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ChangeStorageQuantityOperationProcessor implements ChangeStorageQuantityOperation {
  private final StorageRepository storageRepository;

  @Override
  public ChangeStorageQuantityOutput process(ChangeStorageQuantityInput input) {
    Storage storage =
        storageRepository
            .findStorageByItemId(UUID.fromString(input.getItemId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Integer newQuantity = storage.getQuantity() + input.getQuantity();
    if (newQuantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative.");
    }
    storage.setQuantity(newQuantity);
    storageRepository.save(storage);
    return ChangeStorageQuantityOutput.builder()
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
