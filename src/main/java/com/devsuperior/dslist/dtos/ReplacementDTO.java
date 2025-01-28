package com.devsuperior.dslist.dtos;

public class ReplacementDTO {

	private Integer sourceIndex;
	private Integer targetIndex;
	
	public ReplacementDTO() {
		
	}
			
	public ReplacementDTO(Integer sourceIndex, Integer targetIndex) {
		this.sourceIndex = sourceIndex;
		this.targetIndex = targetIndex;
	}

	public Integer getSourceIndex() {
		return sourceIndex;
	}

	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

	public Integer getTargetIndex() {
		return targetIndex;
	}

	public void setTargetIndex(Integer targetIndex) {
		this.targetIndex = targetIndex;
	}

}
