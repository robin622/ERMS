package edu.gwu.com.erms.service.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import edu.gwu.com.erms.DateUtil;
import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.email.Mail;

public class ERMSSendMail {
	private static final String SMTPSERVERADDRESS = "localhost";
	private static final String nextLine = "\r\n";
	private static final String dash_character = "-----------------------";
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public void sendEmail(Request request, User user, String status,Log log) {
		String subject = getSubject(request, status);
		StringBuffer sb = new StringBuffer("");
		addKeyInfo(sb, status,log,request);
		addPlainDetails(sb, request);
		addPlainRegards(sb);
		try {
			Mail.sendMail(SMTPSERVERADDRESS, user.getEmail(), user.getName(),
					request.getOwner(), request.getForward(), subject,
					sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addKeyInfo(StringBuffer sb, String status,Log log,Request request) {
		addLine(sb);
		if ("add".equalsIgnoreCase(status)) {
			sb.append("The request is added!");
		} else if ("delete".equalsIgnoreCase(status)) {
			sb.append("The request is deleted!");
		} else if ("update".equalsIgnoreCase(status)) {
			String staS="";
			int sta=request.getStatus();
			if(sta==2){
				staS="in Progress";
			}else if(sta==3){
				staS="finished";
			}
			sb.append("The request is updated!");
			addLine(sb);
			sb.append(request.getOwner()).append(" spent ")
			.append(log.getTime()).append(" hour(s) on this request, and the status of it is ")
			.append(staS).append(".");
		}
	}

	// get subject
	private String getSubject(Request request, String status) {
		String subject = null;
		if ("add".equalsIgnoreCase(status)) {
			subject = "[ERMS-" + request.getName() + "] [New] ";
		} else if ("delete".equalsIgnoreCase(status)) {
			subject = "[ERMS-" + request.getName() + "] [Delete] ";
		} else if ("update".equalsIgnoreCase(status)) {
			subject = "[ERMS-" + request.getName() + "] [update] ";
		}
		return subject;
	}

	public void addPlainDetails(StringBuffer sb, Request bean) {
		addLine(sb);
		addLine(sb);
		sb.append("Description:");
		addLine(sb);
		sb.append(dash_character);
		addLine(sb);
		sb.append(replaceDetail(bean.getContent()));
		addLine(sb);
		addLine(sb);
		addLine(sb);
		sb.append("Created by: " + bean.getCreator() + "");
		addLine(sb);
		sb.append("Created on: " + format.format(bean.getCreatetime())
				+ " (UTC)");
		addLine(sb);
		if (bean.getEndtime() != null) {
			sb.append("Due date: " + dayFormat.format(bean.getEndtime())
					+ " (UTC)");
		} else {
			sb.append("Due date: "
					+ dayFormat.format(DateUtil.getLocalUTCTime()) + " (UTC)");
		}
		addLine(sb);
		addLine(sb);
		addLine(sb);
	}

	public void addPlainRegards(StringBuffer sb) {
		addLine(sb);
		addLine(sb);
		addLine(sb);
		sb.append("Regards,");
		addLine(sb);
		sb.append("ERMS service Team");
		addLine(sb);
	}

	public void addLine(StringBuffer sb) {
		sb.append(nextLine);
	}

	private String replaceDetail(String detail) {
		detail = detail.replaceAll("<br>", "\n");
		detail = detail.replaceAll("&amp;amp;", "&");
		detail = detail.replaceAll("&amp;", "&");
		detail = detail.replaceAll("&quot;", "\"");
		detail = detail.replaceAll("&nbsp;", " ");
		detail = detail.replaceAll("&copy;", "©");
		detail = detail.replaceAll("&lt;", "<");
		detail = detail.replaceAll("&gt;", ">");
		return detail;
	}

}
