package com.approvals.service;

import com.approvals.dto.RequestDto;
import com.approvals.model.ApprovalHistory;
import com.approvals.model.ApprovalRequest;
import com.approvals.model.ApprovalState;
import com.approvals.repository.ApprovalHistoryRepository;
import com.approvals.repository.ApprovalRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalRequestService {

    private final ApprovalRequestRepository repository;
    private final EmailService emailService;
    private final ApprovalHistoryRepository historyRepo;

    @Autowired
    public ApprovalRequestService(ApprovalRequestRepository repository, 
    								EmailService emailService,
    								ApprovalHistoryRepository historyRepo) {
        this.repository = repository;
        this.emailService = emailService;
        this.historyRepo = historyRepo;
    }

    public ApprovalRequest save(ApprovalRequest request) {

    	emailService.sendApprovalNotification(
            "sebastian123mfc@gmail.com", 
            request.getRequester(),
            request.getDescription()
        );
    	ApprovalRequest approvalRequest = repository.save(request);
    	genarateHistory(request, ApprovalState.PENDING, "Creada");
        return approvalRequest;
    }

    public List<ApprovalRequest> getPendingRequests() {
        return repository.findByCurrentState(ApprovalState.PENDING);
    }

    public List<RequestDto> getAllRequests() {
        return repository.findAll().stream()
                .map(r -> new RequestDto(r.getId(), r.getTitle(), r.getRequester(), 
                		r.getDescription(), r.getApprover(), r.getType(), r.getCurrentState()))
                .collect(Collectors.toList());
    }

    public ApprovalRequest approveRequest(Long id, String comment) {
        ApprovalRequest req = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        req.setCurrentState(ApprovalState.APPROVED);
        ApprovalRequest approvalRequest = repository.save(req);
        genarateHistory(req, ApprovalState.APPROVED, comment);
        return approvalRequest;
    }

    public ApprovalRequest rejectRequest(Long id, String comment) {
        ApprovalRequest req = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        req.setCurrentState(ApprovalState.REJECTED);
        ApprovalRequest approvalRequest = repository.save(req);
        genarateHistory(req, ApprovalState.REJECTED, comment);
        return approvalRequest;
    }
    
    private void genarateHistory (ApprovalRequest req, ApprovalState newState, String comment) {
    	ApprovalHistory history = new ApprovalHistory();
    	String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        history.setRequest(req);
        history.setState(newState);
        history.setActionBy(currentUser);
        history.setComment(comment);
        historyRepo.save(history);
    }
}
