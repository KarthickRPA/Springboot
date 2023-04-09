package com.in28minutes.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/getCards")
	public List<Item> getallCards() {
		return businessService.getallCards();
		 
	}
	
	@GetMapping("/getCards/{id}")
	public ResponseEntity<Item> getcardbyid(@PathVariable(value="id")int id) {
	try {
		Item item = businessService.getcardbyid(id);
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}
	catch(Exception e)
	{
	return new 	ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	@GetMapping("/getCards/getbyModel")
	public ResponseEntity<Item> getcardbyName(@RequestParam(value="model")String model) {
		try {
			Item models = businessService.getcardbyName(model);
			return new ResponseEntity<Item>(models,HttpStatus.OK);
		}
		catch(Exception e)
		{
		return new 	ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteCard/{id}")
	public void deleteCardbyid(@PathVariable(value = "id")int id) {
	
		 businessService.getcardbyid(id);
	
	}
	}
	

