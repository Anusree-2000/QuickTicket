package com.quickTicket.restdata.model;

import lombok.Data;

@Data
public class BusRequest 
{
	String source;
	String destination;
	int date;
    float time;
}
