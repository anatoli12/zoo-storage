//package com.tinqin.processor.storage;
//
//import com.tinqin.storage.persistence.model.Storage;
//import com.tinqin.storage.persistence.repository.StorageRepository;
//import com.tinqin.request.StorageDeleteRequest;
//import com.tinqin.response.BaseResponse;
//import com.tinqin.response.StorageResponse;
//import com.tinqin.operations.storage.deletestorage.StorageDeleteService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class StorageDeleteOperation implements StorageDeleteService {
//    private final StorageRepository storageRepository;
//
//    @Override
//    public StorageResponse process(StorageDeleteRequest input) {
//        Storage entity = storageRepository.findById(UUID.fromString(input.getId()))
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        entity.setDeleted(true);
//        entity.setDeleteAt(LocalDateTime.now());
//        storageRepository.save(entity);
//        return StorageResponse.builder()
//                .itemId(String.valueOf(entity.getItemId()))
//                .quantity(entity.getQuantity())
//                .price(entity.getPrice())
//                .baseResponse(
//                        BaseResponse.builder()
//                                .createAt(entity.getCreateAt())
//                                .deleted(entity.isDeleted())
//                                .deleteAt(entity.getDeleteAt())
//                                .updateAt(entity.getUpdateAt())
//                                .build())
//                .build();
//    }
//}
