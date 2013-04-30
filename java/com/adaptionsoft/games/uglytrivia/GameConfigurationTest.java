package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameConfigurationTest {
	
	@Test
	public void shouldNotAllowThisConfiguration() {
		GameConfiguration configuration = new GameConfiguration();
		assertEquals(true, configuration.isNotAnAllowedConfiguration(5));
	}
	
	@Test
	public void shouldAllowThisConfiguration() {
		GameConfiguration configuration = new GameConfiguration();
		assertEquals(false, configuration.isNotAnAllowedConfiguration(2));
		assertEquals(false, configuration.isNotAnAllowedConfiguration(4));
		assertEquals(false, configuration.isNotAnAllowedConfiguration(6));
	}

}
