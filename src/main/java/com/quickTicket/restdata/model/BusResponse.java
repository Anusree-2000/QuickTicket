package com.quickTicket.restdata.model;

import lombok.Data;

@Data
public class BusResponse 
{
	int bus_number;
	String name;
	String source;
	String destination;
	int date;
	float time;
	long price;
}
