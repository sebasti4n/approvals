package com.approvals.dto;

import com.approvals.model.ApprovalState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class ActionDto {
    @NotNull
    private ApprovalState action;

    @NotBlank
    private String actionBy;

    private String comment;

	public ApprovalState getAction() {
		return action;
	}

	public void setAction(ApprovalState action) {
		this.action = action;
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
}