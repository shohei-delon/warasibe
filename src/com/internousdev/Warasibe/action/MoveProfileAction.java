package com.internousdev.Warasibe.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class MoveProfileAction extends ActionSupport implements SessionAware {

	private AccountDTO accountDTO;
	private Map<String, Object> session;

	public String execute() {
		accountDTO = (AccountDTO) session.get(SessionName.getAccountDto());
		return SUCCESS;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
