package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@SpringBootTest(classes = {ItemBusinessServiceTest.class})
public class ItemBusinessServiceTest {

	@Mock
	ItemRepository repository;
	
	@InjectMocks
	ItemBusinessService business;
	
	public List<Item> mycards;
	
	@Test
	@Order(1)
	public void Test_getallCards() {
		
		List<Item>mycards = new ArrayList<Item >();
		
		mycards.add(new Item(1,"NVIDIA","GTX1650",16000));
		mycards.add(new Item(2,"NVIDIA","GTX1060",19000));
		mycards.add(new Item(3,"AMD","RX7000",18000));
		
		when(repository.findAll()).thenReturn(mycards);
		business.getallCards().size();
		assertEquals(3, business.getallCards().size());
	}
	@Test
	@Order(2)
	public void Test_getcardbyid() {

		List<Item>mycards = new ArrayList<Item >();
		
		mycards.add(new Item(1,"NVIDIA","GTX1650",16000));
		mycards.add(new Item(2,"NVIDIA","GTX1060",19000));
		mycards.add(new Item(3,"AMD","RX7000",18000));
		
		int cardid = 1;
		when(repository.findAll()).thenReturn(mycards);
		
		assertEquals(1, business.getcardbyid(cardid).getId());
	}
	@Test
	@Order(3)
	public void Test_getcardbyName() {
        List<Item>mycards = new ArrayList<Item >();
		
		mycards.add(new Item(1,"NVIDIA","GTX1650",16000));
		mycards.add(new Item(2,"NVIDIA","GTX1060",19000));
		mycards.add(new Item(3,"AMD","RX7000",18000));
		
		String model = "GTX1060";
		
		when(repository.findAll()).thenReturn(mycards);
		
		
		assertEquals(model, business.getcardbyName(model).getModel());

	}
	@Test
	@Order(4)
	public void Test_deletecard() {
		Item item = new Item(3,"AMD","RX7000",18000);
		
	   business.deleteCardbyid(item);
	   verify(repository,times(1)).delete(item);

	}
}
