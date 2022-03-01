//package com.moviebooking.controllers;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/admin")
//@SessionAttributes({"Logininfo"})
//public class Admincontroller {
//
//	@RequestMapping("addMovie")
//	public String AddMovie() {
//		return "AddMovie";
//	}
//	
//	@RequestMapping(value="/addMovietoDB",method=RequestMethod.POST)
//	public String addMovietoDB(@RequestParam("PosterName") CommonsMultipartFile PosterName,Model m,HttpSession s)
//	{
//		
//		System.out.println(PosterName.getName());
//		System.out.println(PosterName.getContentType());
//		return "AdminLoginView";
//	}
//
//}
