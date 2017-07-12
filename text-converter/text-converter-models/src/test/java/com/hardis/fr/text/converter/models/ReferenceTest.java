package com.hardis.fr.text.converter.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hardis.fr.text.converter.models.entities.Reference;

@RunWith(PowerMockRunner.class)
public class ReferenceTest {

	@Test
	public void surchargeEqualsTest() {
		Reference r1 = new Reference('G', 10.2f, 20, "0123456789");
		Reference r2 = new Reference('G', 10.2f, 20, "0123456789");
		Assert.assertEquals(r1, r2);
	}

	@Test
	public void surchargeNotEqualsTest() {
		Reference r1 = new Reference('G', 10.2f, 20, "0123456789");
		Reference r2 = new Reference('R', 10.2f, 20, "0123456789");
		Assert.assertNotEquals(r1, r2);
	}
}
