package com.tinqin.storage.persistence.repository;

import com.tinqin.storage.persistence.model.Storage;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, UUID> {
    Optional<Storage> findStorageByItemId(UUID id);
}
