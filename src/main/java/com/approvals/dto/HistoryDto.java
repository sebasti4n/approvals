// CreateRequestDto.java
package com.approvals.dto;

import java.time.Instant;

import com.approvals.model.ApprovalState;

import jakarta.validation.constraints.NotBlank;

public class HistoryDto {
	
	private Long id;
	
	@NotBlank
    private Long requestId;

    private ApprovalState state;

    @NotBlank
    private String actionBy;

    @NotBlank
    private String comment;

    @NotBlank
    private Instant actionAt;
    
	public HistoryDto(Long id,  Long requestId, ApprovalState state,  String actionBy,
			 String comment,  Instant actionAt) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.state = state;
		this.actionBy = actionBy;
		this.comment = comment;
		this.actionAt = actionAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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


