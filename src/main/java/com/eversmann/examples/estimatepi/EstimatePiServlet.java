package com.eversmann.examples.estimatepi;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/EstimatePi")
public class EstimatePiServlet extends HttpServlet {
		
	@Inject
	EstimatePiService estimatePiService;

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("EstimatePiServlet.doGet");
		int numTrials = 0;
		int maxNumber = 0;
		double result = 0.0;
		boolean success = false;
		try {
			numTrials = Integer.parseInt(request.getParameter("numTrials"));
			maxNumber = Integer.parseInt(request.getParameter("maxNumber"));
			result = estimatePiService.estimatePi(numTrials, maxNumber);
			success = true;
		}
		catch (NumberFormatException e) {
			success = false;
		}
		response.getWriter().append("<html><title>Estimate Pi</title><body><h2>Estimate Pi</h2><form>");
		response.getWriter().append("Number of Trials:<input name='numTrials' value='"+(success?numTrials:"")+"' /><br />");
		response.getWriter().append("Max Random Number:<input name='maxNumber' value='"+(success?maxNumber:"")+"' /><br />");
		
		response.getWriter().append("<input type='submit' /><br />");
		response.getWriter().append("Pi Estimate: " + (success?result:"") + "<br />");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
