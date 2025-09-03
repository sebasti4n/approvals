package com.approvals.controller;

import com.approvals.dto.RequestDto;
import com.approvals.model.ApprovalRequest;
import com.approvals.model.RequestType;
import com.approvals.service.ApprovalRequestService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApprovalRequest> createApproval(@Valid @RequestBody RequestDto dto
    ) {
        // Convierte el DTO a la entidad
        ApprovalRequest request = new ApprovalRequest();
        request.setTitle(dto.getTitle());
        request.setDescription(dto.getDescription());
        request.setRequester(dto.getRequester());
        request.setApprover(dto.getApprover());
        request.setType(dto.getType());
        request.setCurrentState(dto.getCurrentState());

        ApprovalRequest saved = service.save(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/pending")
    public List<ApprovalRequest> getPendingRequests() {
        return service.getPendingRequests();
    }

    @GetMapping
    public List<RequestDto> getAllRequests() {
        return service.getAllRequests();
    }

    @PostMapping("/{id}/approve")
    public RequestDto approve(@PathVariable Long id, @RequestParam String comment) {
    	ApprovalRequest r = service.approveRequest(id, comment);
    	return new RequestDto(r.getId(), r.getTitle(), r.getRequester(), 
        		r.getDescription(), r.getApprover(), r.getType(), r.getCurrentState());
    }

    @PostMapping("/{id}/reject")
    public RequestDto reject(@PathVariable Long id, @RequestParam String comment) {
    	ApprovalRequest r = service.rejectRequest(id, comment);
    	return new RequestDto(r.getId(), r.getTitle(), r.getRequester(), 
        		r.getDescription(), r.getApprover(), r.getType(), r.getCurrentState());
    	
    }
}
