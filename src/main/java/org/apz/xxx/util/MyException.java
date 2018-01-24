package org.apz.xxx.util;

public class MyException extends RuntimeException {
	 
		private static final long serialVersionUID = 1L;
	 
		private Integer errCode;
		private String errMsg;
	 
		public Integer getErrCode() {
			return errCode;
		}
	 
		public void setErrCode(Integer errCode) {
			this.errCode = errCode;
		}
	 
		public String getErrMsg() {
			return errMsg;
		}
	 
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
	 
		public MyException(Integer errCode, String errMsg) {
			this.errCode = errCode;
			this.errMsg = errMsg;
		}
	 
	}