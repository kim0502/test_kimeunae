package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ACommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);

}
