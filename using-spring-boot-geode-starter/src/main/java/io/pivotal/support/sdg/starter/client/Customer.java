package io.pivotal.support.sdg.starter.client;

import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("Customer")
public class Customer {

	@Override public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
