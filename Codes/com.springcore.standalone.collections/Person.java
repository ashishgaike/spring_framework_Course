package com.springcore.standalone.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	
	
	private List<String> friends;
	private Map<String, Integer> feesstructure;
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Map<String, Integer> getFeesstructure() {
		return feesstructure;
	}

	public void setFeesstructure(Map<String, Integer> feesstructure) {
		this.feesstructure = feesstructure;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "Person [friends=" + friends + ", feesstructure=" + feesstructure + ", properties=" + properties + "]";
	}

	


}
