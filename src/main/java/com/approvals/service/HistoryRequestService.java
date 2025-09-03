package com.approvals.service;

import com.approvals.dto.HistoryDto;
import com.approvals.repository.ApprovalHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryRequestService {

    private final ApprovalHistoryRepository historyRepo;

    @Autowired
    public HistoryRequestService(ApprovalHistoryRepository historyRepo) {
   
        this.historyRepo = historyRepo;
    }


    public List<HistoryDto> getAllHistory() {
        return historyRepo.findAll().stream()
                .map(r -> new HistoryDto(r.getId(), r.getRequest().getId(), r.getState(), 
                		r.getActionBy(), r.getComment(), r.getActionAt()))
                .collect(Collectors.toList());
        
        
    }

}
