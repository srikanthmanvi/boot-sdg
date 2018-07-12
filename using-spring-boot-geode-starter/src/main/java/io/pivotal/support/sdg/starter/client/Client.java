package io.pivotal.support.sdg.starter.client;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;

@ClientCacheApplication
public class Client {

	public static void main(String args[]) {
		SpringApplication.run(Client.class, args);
	}

	@Bean
	@Qualifier("customerRegion") Region customerRegion(GemFireCache cache) {
		ClientCache clientCache = (ClientCache) cache;
		ClientRegionFactory<Object, Object> clientRegionFactory = clientCache
				.createClientRegionFactory(ClientRegionShortcut.PROXY);
		return clientRegionFactory.create("Customer");
	}

	@Bean
	ApplicationRunner applicationRunner(@Qualifier("customerRegion") Region customerRegion) {
		return args -> {
			customerRegion.put(2, "AA");
			System.out.println("Done With Put");
		};
	}
}
