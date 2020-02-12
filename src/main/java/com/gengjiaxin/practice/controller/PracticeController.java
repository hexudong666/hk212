package com.gengjiaxin.practice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gengjiaxin.practice.domain.Practice;
import com.gengjiaxin.practice.service.PracticeService;

@Controller
public class PracticeController {

	@Autowired
	private PracticeService service;

	@RequestMapping("list")
	public String list(Model model) {
		List<Practice> list = service.list();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping("publish")
	public String publish(Practice practice, @RequestParam("file") MultipartFile file) {
		if (file.getSize() > 0) {
			// 上传图片
			String path = "d:/pic/";
			// 获得上传的文件的名称
			String oleFileName = file.getOriginalFilename();
			// 获得后缀
			String hz = oleFileName.substring(oleFileName.lastIndexOf("."));
			// 获得新的文件的名称
			String newFileName = UUID.randomUUID().toString() + hz;
			// 创建上传的文件
			File fiel2 = new File(path + newFileName);
			try {
				file.transferTo(fiel2);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			practice.setPicture(newFileName);
			int result = service.publisher(practice);
			if (result > 0) {
				return "redirect:list";
			}
		}
		return "redirect:list";
	}

	@ResponseBody
	@RequestMapping("publish1")
	public boolean publish1(Practice practice, @RequestParam("file") MultipartFile file) {
		if (file.getSize() > 0) {
			// 上传图片
			String path = "d:/pic/";
			// 获得上传的文件的名称
			String oleFileName = file.getOriginalFilename();
			// 获得后缀
			String hz = oleFileName.substring(oleFileName.lastIndexOf("."));
			// 获得新的文件的名称
			String newFileName = UUID.randomUUID().toString() + hz;
			// 创建上传的文件
			File fiel2 = new File(path + newFileName);
			try {
				file.transferTo(fiel2);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			practice.setPicture(newFileName);
			int result = service.publisher(practice);
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
