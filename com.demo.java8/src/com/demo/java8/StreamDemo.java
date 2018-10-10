package com.demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {
public static void main(String[] args) {
	List<String> names=new ArrayList<>();
	names.add("a");
	names.add("raju");
	names.add("sai");
	
	List<String> filterList=new ArrayList<>();
	
	for (String name:names) {
		if(name.startsWith("r"))
		{
			filterList.add(name);
		}
	}
	System.out.println(filterList.size());
	
	for (String name:filterList) {
		System.out.println(name);
	}
	
	
	//Java8
	names.stream().filter(a->a.startsWith("r")).forEach(System.out::println);
	
	Predicate<String> p1=s->s.startsWith("r");
	
	
	Consumer<String>  c1=c->System.out.println(c);
	names.stream().filter(p1).forEach(c1);
	System.out.println(names.stream().filter(p1).count());
}
}
