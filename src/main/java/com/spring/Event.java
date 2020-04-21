package com.spring;

public class Event 
{
    String eventName;
	Owner owner;
    
    public Event(String eventName,Owner owner)
    {
        this.eventName = eventName;
        this.owner = owner;
    }
    
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}	
}
