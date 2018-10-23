package au.usyd.onlineshopping.Entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

// fulfill Serializable interface

public class BaseDomain implements Serializable{
	
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this);
	}
}
