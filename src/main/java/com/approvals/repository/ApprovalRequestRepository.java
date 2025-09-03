package com.approvals.repository;
import com.approvals.model.ApprovalRequest;
import com.approvals.model.ApprovalState;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the KeWebResources entity.
 */

@Repository
public interface ApprovalRequestRepository extends JpaRepository <ApprovalRequest, Long> {
	
    // Bandeja de pendientes por usuario
    List<ApprovalRequest> findByCurrentState(ApprovalState approvalState);
    
}