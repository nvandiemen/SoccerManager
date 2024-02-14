package com.example.demo.Transfers;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransferRepository extends CrudRepository<Transfer, Integer> {

    List <Transfer> findBytransferId (Integer transferId);
}
