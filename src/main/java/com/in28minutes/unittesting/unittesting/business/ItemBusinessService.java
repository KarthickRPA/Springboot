package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
@Service
public class ItemBusinessService {

	@Autowired
	ItemRepository repository;

	public List<Item> getallCards() {

		return repository.findAll();
	}

	public Item getcardbyid(int id) {
		List<Item> cards = repository.findAll();
		Item item = null;
		for (Item i : cards) {
			if (i.getId() == id) {
				item = i;

			}
		}
		return item;

	}

	public Item getcardbyName(String model) {
		List<Item> cards = repository.findAll();
		Item item = null;
		for (Item i : cards) {
			if (i.getModel().equalsIgnoreCase(model)) {
				item = i;

			}
		}
		return item;
	}

	public void deleteCardbyid(Item item) {
		repository.delete(item);
		System.out.println("Card Deleted");

	}
}