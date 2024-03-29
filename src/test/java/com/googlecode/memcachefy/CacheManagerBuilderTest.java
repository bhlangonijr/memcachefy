package com.googlecode.memcachefy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: bhlangonijr
 * Date: 12/21/12
 * Time: 3:53 PM
 */
public class CacheManagerBuilderTest {

	@Test
	public void testOnheapBuilder() throws CacheException {

		CacheManager cacheManager = CacheManagerBuilder.newBuilder().
				setCacheType(CacheType.ONHEAP).
				setMaxEntries(5000).
				setDefaultTtl(60).build();

		Cache<String, String> cache = cacheManager.getCache("test");
		cache.put("hey", "ola");

		assertEquals("ola", cache.get("hey"));

	}

	@Test
	public void testMemcachedBuilder() throws CacheException {

		CacheManager cacheManager = CacheManagerBuilder.newBuilder().
				setCacheType(CacheType.MEMCACHED).
				setMemcachedHosts("localhost:11211, 127.0.0.1:11211").
				setDefaultTtl(120).build();


		Cache<String, String> cache = cacheManager.getCache("test");

		cache.put("hey", "ola");

		assertEquals("ola", cache.get("hey"));

	}

}
