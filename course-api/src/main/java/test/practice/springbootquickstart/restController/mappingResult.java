package test.practice.springbootquickstart.restController;

import java.util.List;

public class mappingResult {
	
	private int getFromPos;
	private int getToPos;
	private String getMessage;
	private List<String> getSuggestedReplacements;
	
	public mappingResult() {
		
	}
	
	public mappingResult(int getFromPos, int getToPos, String getMessage, List<String> getSuggestedReplacements) {
		super();
		this.getFromPos = getFromPos;
		this.getToPos = getToPos;
		this.getMessage = getMessage;
		this.getSuggestedReplacements = getSuggestedReplacements;
	}



	public int getGetFromPos() {
		return getFromPos;
	}

	public void setGetFromPos(int getFromPos) {
		this.getFromPos = getFromPos;
	}

	public int getGetToPos() {
		return getToPos;
	}

	public void setGetToPos(int getToPos) {
		this.getToPos = getToPos;
	}

	public String getGetMessage() {
		return getMessage;
	}

	public void setGetMessage(String getMessage) {
		this.getMessage = getMessage;
	}

	public List<String> getGetSuggestedReplacements() {
		return getSuggestedReplacements;
	}

	public void setGetSuggestedReplacements(List<String> getSuggestedReplacements) {
		this.getSuggestedReplacements = getSuggestedReplacements;
	}

	@Override
	public String toString() {
		return "mappingResult [getFromPos=" + getFromPos + ", getToPos=" + getToPos + ", getMessage=" + getMessage
				+ ", getSuggestedReplacements=" + getSuggestedReplacements + "]";
	}
		
}
