package com.xcompany.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.xcompany.dao.LeadDao;
import com.xcompany.model.Lead;

@WebServlet(urlPatterns = "/LeadServlet", name = "LeadServlet")
public class LeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LeadDao dao;
	@Resource(name = "jdbc/salescrud")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dao = new LeadDao(datasource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}

			switch (command) {
			case "LIST":
				readAllLeads(request, response);
				break;
			case "LOAD":
				loadLead(request, response);
				break;
			default:
				readAllLeads(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				readAllLeads(request, response);
			}
			
			switch (command) {
			case "ADD":
				createLead(request, response);
				break;
			case "UPDATE":
				updateLead(request, response);
				break;
			default:
				readAllLeads(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void createLead(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String leadFirstName = request.getParameter("leadFirstName");
		String leadLastName = request.getParameter("leadLastName");
		String leadMainChannel = request.getParameter("leadMainChannel");
		String leadEmail = request.getParameter("leadEmail");
		String leadWhatsapp = request.getParameter("leadWhatsapp");
		String leadFacebook = request.getParameter("leadFacebook");
		String leadInstagram = request.getParameter("leadInstagram");
		
		Lead lead = new Lead();
		lead.setLeadFirstName(leadFirstName);
		lead.setLeadLastName(leadLastName);
		lead.setLeadMainChannel(leadMainChannel);
		lead.setLeadEmail(leadEmail);
		lead.setLeadWhatsapp(leadWhatsapp);
		lead.setLeadFacebook(leadFacebook);
		lead.setLeadInstagram(leadInstagram);
		
		dao.create(lead);
		readAllLeads(request, response);
	}
	
	private void readAllLeads(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Lead> list = dao.readAll();
		request.setAttribute("leadsList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/leads.jsp");
		rd.forward(request, response);
	}
	
	private void loadLead(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String leadId = request.getParameter("leadId");
		Lead lead = dao.readById(leadId);
		request.setAttribute("lead", lead);
	
		RequestDispatcher rd = request.getRequestDispatcher("/update-lead.jsp");
		rd.forward(request, response);
	}
	
	private void updateLead(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int leadId = Integer.parseInt(request.getParameter("leadId"));
		String leadFirstName = request.getParameter("leadFirstName"); 
		String leadLastName = request.getParameter("leadLastName");
		String leadMainChannel = request.getParameter("leadMainChannel");
		String leadWhatsapp = request.getParameter("leadWhatsapp");
		String leadFacebook = request.getParameter("leadFacebook");
		String leadInstagram = request.getParameter("leadInstagram");
		String leadEmail = request.getParameter("leadEmail");
		
		Lead lead = new Lead();
		lead.setLeadId(leadId);
		lead.setLeadFirstName(leadFirstName);
		lead.setLeadLastName(leadLastName);
		lead.setLeadMainChannel(leadMainChannel);
		lead.setLeadWhatsapp(leadWhatsapp);
		lead.setLeadFacebook(leadFacebook);
		lead.setLeadInstagram(leadInstagram);
		lead.setLeadEmail(leadEmail);
		
		dao.update(lead);
		readAllLeads(request, response);
	}
}