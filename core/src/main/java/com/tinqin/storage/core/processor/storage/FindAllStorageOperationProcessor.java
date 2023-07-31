package com.tinqin.storage.core.processor.storage;

import com.tinqin.storage.api.operation.storage.StorageBaseDTO;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageInput;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageOperation;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageOutput;
import com.tinqin.storage.persistence.model.Storage;
import com.tinqin.storage.persistence.repository.StorageRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindAllStorageOperationProcessor implements FindAllStorageOperation {

  private final StorageRepository storageRepository;

  @Override
  public FindAllStorageOutput process(FindAllStorageInput input) {
    List<Storage> storages = storageRepository.findAll();
    Set<StorageBaseDTO> storageBaseDTOS =
        storages.stream()
            .map(
                s ->
                    StorageBaseDTO.builder()
                        .id(String.valueOf(s.getId()))
                        .itemId(String.valueOf(s.getItemId()))
                        .quantity(s.getQuantity())
                        .price(String.valueOf(s.getPrice()))
                        .build())
            .collect(Collectors.toSet());
    return FindAllStorageOutput.builder()
            .storageBaseDTOSet(storageBaseDTOS)
            .build();
  }
}
