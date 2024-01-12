package com.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

		@RequestMapping("/")
		public String index() {
			return "index";
		}
		

		
}
