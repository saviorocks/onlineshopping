package com.niit.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility 
{
	private static final String ABS_PATH = "F:\\Project\\onlineshopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{
		//get real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		//to make sure all directories exist
		if(!new File(ABS_PATH).exists())
		{
			//create directories
			new File(ABS_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists())
		{
			//create directories
			new File(REAL_PATH).mkdirs();
		}
		
		try
		{
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			
			//project dir upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch (IOException e) {
			// TODO: handle exception
		}
	}
}
