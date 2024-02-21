package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class SpringSecurityController {
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/all")
	public String getAll()
	{
		return "akshay";
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/allstring")
	public String getAllString()
	{
		return "akshay Nilawar";
	}
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")

	@GetMapping("/allstring/allObject")
	public String getAllObject()
	{
		return "nilawar";
	}



}
