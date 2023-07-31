package com.tinqin.storage.controller;

import com.tinqin.storage.api.operation.storage.changestorageprice.ChangeStoragePriceInput;
import com.tinqin.storage.api.operation.storage.changestorageprice.ChangeStoragePriceOperation;
import com.tinqin.storage.api.operation.storage.changestorageprice.ChangeStoragePriceOutput;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityInput;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityOperation;
import com.tinqin.storage.api.operation.storage.changestoragequantity.ChangeStorageQuantityOutput;
import com.tinqin.storage.api.operation.storage.createstorage.CreateStorageInput;
import com.tinqin.storage.api.operation.storage.createstorage.CreateStorageOperation;
import com.tinqin.storage.api.operation.storage.createstorage.CreateStorageOutput;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageInput;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageOperation;
import com.tinqin.storage.api.operation.storage.findallstorages.FindAllStorageOutput;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdInput;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdOperation;
import com.tinqin.storage.api.operation.storage.findstoragebyitemid.FindStorageByItemIdOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage")
public class StorageController {
  private final CreateStorageOperation storageUpsertService;
  private final FindAllStorageOperation storageFindAllService;
  private final FindStorageByItemIdOperation findStorageByItemIdOperation;
  private final ChangeStoragePriceOperation storageChangePriceService;
  private final ChangeStorageQuantityOperation storageChangeQuantityService;

  @PostMapping
  public ResponseEntity<CreateStorageOutput> create(@RequestBody CreateStorageInput request) {
    return ResponseEntity.ok(storageUpsertService.process(request));
  }

  @GetMapping
  public ResponseEntity<FindAllStorageOutput> findAll(FindAllStorageInput request) {
    return ResponseEntity.ok(storageFindAllService.process(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<FindStorageByItemIdOutput> findStorageByItemId(@PathVariable String id) {
    return ResponseEntity.ok(
        findStorageByItemIdOperation.process(
            FindStorageByItemIdInput.builder().itemId(id).build()));
  }

  @PatchMapping("/price")
  public ResponseEntity<ChangeStoragePriceOutput> updatePrice(
      @RequestBody ChangeStoragePriceInput request) {
    return ResponseEntity.ok(storageChangePriceService.process(request));
  }

  @PatchMapping("/quantity")
  public ResponseEntity<ChangeStorageQuantityOutput> addQuantity(
      @RequestBody ChangeStorageQuantityInput request) {
    return ResponseEntity.ok(storageChangeQuantityService.process(request));
  }
}
