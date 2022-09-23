package com.example.exception;

import java.util.List;
import java.util.Map;

public class ErrorResponse {

	private String errorCode;
	private String errorDesc;
	private List<String> errrors;
	private Map<String, String> maperrrors;

	public ErrorResponse() {

	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public List<String> getErrrors() {
		return errrors;
	}

	public void setErrrors(List<String> errrors) {
		this.errrors = errrors;
	}

	public Map<String, String> getMaperrrors() {
		return maperrrors;
	}

	public void setMaperrrors(Map<String, String> maperrrors) {
		this.maperrrors = maperrrors;
	}

}
