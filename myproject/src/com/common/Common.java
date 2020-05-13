package com.common;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.models.User;

public class Common {
	public static final int PENDING = 0;
	public static final int COMPLETED = 1;
	public static final int REJECTED = 2;
	public static final int CANCELLED = 3;

	public static String getRandomString() {
		return new Date().hashCode() + "";
	}

	public static String getExtension(String name) {
		int index = name.lastIndexOf(".");
		if (name == null || index == -1) {
			return "";
		}
		return name.substring(index);
	}

	public static String uploadImage(HttpSession session, MultipartFile imgFile, String uploadDir) {
		String uploaded = session.getServletContext().getRealPath("/uploaded/");
		String fileName = uploadDir + "/" + getRandomString() + getExtension(imgFile.getOriginalFilename());
		String destination = uploaded + fileName;
		try {
			FileCopyUtils.copy(imgFile.getBytes(), new File(destination));
			return fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isLoggedIn(HttpSession session) {
		return getLoggedUser(session) != null;
	}

	public static User getLoggedUser(HttpSession hsession) {
		User user = (User) hsession.getAttribute("logged_user");
		return user;
	}

	public static int getRandomId() {
		return new Random(8).nextInt();
	}

}
