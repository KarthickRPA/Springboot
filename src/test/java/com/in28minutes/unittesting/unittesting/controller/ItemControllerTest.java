package com.in28minutes.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.internal.Classes;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {ItemControllerTest.class})
public class ItemControllerTest {

	@Mock
	
	ItemBusinessService service;
	
	@InjectMocks
	
	ItemController controller;
	
	List<Item> cards;
	
	Item item;
	
	@Test
	@Order(1)
	public void Test_getallcards() {
		List<Item> cards = new ArrayList<Item>();
		cards.add(new Item(1,"NVIDIA","GT610",4444));
		cards.add(new Item(2,"AMD","R6000",7744));
		cards.add(new Item(3,"GALAX","GT730",8900));

		when(service.getallCards()).thenReturn(cards);
		
		List<Item> res = controller.getallCards();
		
	}
	
	
	
	
}
