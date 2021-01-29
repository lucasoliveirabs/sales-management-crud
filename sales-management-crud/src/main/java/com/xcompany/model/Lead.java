package com.xcompany.model;

public class Lead {
	
	private int leadId;
	String leadFirstName, leadLastName, leadMainChannel, leadWhatsapp, 
	leadFacebook, leadInstagram, leadEmail;

	public Lead() {
	}

	public Lead(int leadId, String leadFirstName, String leadLastName, String leadMainChannel, 
			String leadWhatsapp, String leadFacebook, String leadInstagram, String leadEmail) {
		this.leadId = leadId;
		this.leadFirstName = leadFirstName;
		this.leadLastName = leadLastName;
		this.leadMainChannel = leadMainChannel;
		this.leadWhatsapp = leadWhatsapp;
		this.leadFacebook = leadFacebook;
		this.leadInstagram = leadInstagram;
		this.leadEmail = leadEmail;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getLeadFirstName() {
		return leadFirstName;
	}

	public void setLeadFirstName(String leadFirstName) {
		this.leadFirstName = leadFirstName;
	}

	public String getLeadLastName() {
		return leadLastName;
	}

	public void setLeadLastName(String leadLastName) {
		this.leadLastName = leadLastName;
	}

	public String getLeadMainChannel() {
		return leadMainChannel;
	}

	public void setLeadMainChannel(String leadMainChannel) {
		this.leadMainChannel = leadMainChannel;
	}

	public String getLeadWhatsapp() {
		return leadWhatsapp;
	}

	public void setLeadWhatsapp(String leadWhatsapp) {
		this.leadWhatsapp = leadWhatsapp;
	}

	public String getLeadFacebook() {
		return leadFacebook;
	}

	public void setLeadFacebook(String leadFacebook) {
		this.leadFacebook = leadFacebook;
	}

	public String getLeadInstagram() {
		return leadInstagram;
	}

	public void setLeadInstagram(String leadInstagram) {
		this.leadInstagram = leadInstagram;
	}

	public String getLeadEmail() {
		return leadEmail;
	}

	public void setLeadEmail(String leadEmail) {
		this.leadEmail = leadEmail;
	}

	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", leadFirstName=" + leadFirstName + ", leadLastName=" + leadLastName
				+ ", leadMainChannel=" + leadMainChannel + ", leadWhatsapp=" + leadWhatsapp + ", leadFacebook="
				+ leadFacebook + ", leadInstagram=" + leadInstagram + ", leadEmail=" + leadEmail + "]";
	}
}
