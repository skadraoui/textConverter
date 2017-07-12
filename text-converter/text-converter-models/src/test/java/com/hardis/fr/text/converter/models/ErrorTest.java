package com.hardis.fr.text.converter.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import com.hardis.fr.text.converter.models.entities.Error;

@RunWith(PowerMockRunner.class)
public class ErrorTest {

	@Test
	public void surchargeEqualsTest() {
		Error e1 = new Error(10, "error_1", "line_of_erreor_1");
		Error e2 = new Error(10, "error_1", "line_of_erreor_1");
		Assert.assertEquals(e1, e2);
	}

	@Test
	public void surchargeNotEqualsTest() {
		Error e1 = new Error(10, "error_1", "line_of_erreor_1");
		Error e2 = new Error(10, "error_2", "line_of_erreor_1");
		Assert.assertNotEquals(e1, e2);
	}

}
