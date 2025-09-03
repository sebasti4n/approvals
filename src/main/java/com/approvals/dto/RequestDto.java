// CreateRequestDto.java
package com.approvals.dto;

import com.approvals.model.ApprovalState;
import com.approvals.model.RequestType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestDto {
	
	private Long id;
	
	@NotBlank
    private String title;

    private String description;

    @NotBlank
    private String requester;

    @NotBlank
    private String approver;

    @NotNull
    private RequestType type;
    
    @NotNull
    private ApprovalState currentState;
    
    public RequestDto(Long id, String title, String requester, String description, String approver, RequestType type, ApprovalState currentState) {
        this.id = id;
        this.title = title;
        this.requester = requester;
        this.description = description;
        this.approver = approver;
        this.type = type;
        this.currentState = currentState;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

	public ApprovalState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ApprovalState currentState) {
		this.currentState = currentState;
	}
}


