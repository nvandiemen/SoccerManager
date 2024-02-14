package com.example.demo.Transfers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepository;

    public Iterable getTransfers(){
        return transferRepository.findAll();
    }



}
