package com.approvals.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.approvals.dto.HistoryDto;
import com.approvals.service.HistoryRequestService;

@RestController
@RequestMapping("/api/history")
public class HistoryRequestController {

    private final HistoryRequestService service;

    public HistoryRequestController(HistoryRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistoryDto> getAllRequests() {
        return service.getAllHistory();
    }

}
