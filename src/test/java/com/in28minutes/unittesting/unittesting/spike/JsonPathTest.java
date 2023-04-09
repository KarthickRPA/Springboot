package com.in28minutes.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":1, \"name\":\"NVIDIA\", \"model\":RTX3060 \"price\":\35000}," + 
				"{\"id\":2, \"name\":\"NVIDIA\", \"model\":RTX3080 \"price\":89000},"  + 
				"{\"id\":3, \"name\":\"AMD\", \"model\":RX6700 \"price\":41000}" + 
				"]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");

		assertThat(ids).containsExactly(1,2,3);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
		
	}

}
