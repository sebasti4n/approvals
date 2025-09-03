package com.approvals.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "approval_history")
public class ApprovalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la solicitud
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    private ApprovalRequest request;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ApprovalState state;

    @Column(name = "action_by", nullable = false, length = 100)
    private String actionBy;

    @Column(columnDefinition = "text")
    private String comment;

    @Column(name = "action_at", nullable = false, updatable = false)
    private Instant actionAt;

    @PrePersist
    protected void onCreate() {
        actionAt = Instant.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApprovalRequest getRequest() {
		return request;
	}

	public void setRequest(ApprovalRequest request) {
		this.request = request;
	}

	public ApprovalState getState() {
		return state;
	}

	public void setState(ApprovalState state) {
		this.state = state;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Instant getActionAt() {
		return actionAt;
	}

	public void setActionAt(Instant actionAt) {
		this.actionAt = actionAt;
	}

  
}
