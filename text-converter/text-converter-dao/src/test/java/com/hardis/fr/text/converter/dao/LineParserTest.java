package com.hardis.fr.text.converter.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hardis.fr.text.converter.exceptions.ReportException;
import com.hardis.fr.text.converter.models.entities.Reference;
import com.hardis.fr.text.converter.models.enums.Params;
import com.hardis.fr.text.converter.traitement.LineParser;

@RunWith(PowerMockRunner.class)
public class LineParserTest {

	@Test
	public void getColorByCodeGreenTest() {
		Params.Colors color = LineParser.getColorByCode('G');
		Assert.assertNotNull(color);
		Assert.assertEquals(color.getColorName(), "GREEN");
	}

	@Test
	public void getColorByCodeRedTest() {
		Params.Colors color = LineParser.getColorByCode('R');
		Assert.assertNotNull(color);
		Assert.assertEquals(color.getColorName(), "RED");
	}

	@Test
	public void getColorByCodeNotAllowedColorTest() {
		Params.Colors color = LineParser.getColorByCode('Y');
		Assert.assertNull(color);
	}

	@Test
	public void formaterLigneReferenceSuccessTest() {
		final String reference = "1460100040;R;45.12;27";
		try {
			Reference result = LineParser.formaterLigneReference(reference);
			Assert.assertNotNull(result);
			Assert.assertEquals("1460100040", result.getNumReference());
			Assert.assertEquals(45.12, result.getPrice(), 0.1);
			Assert.assertEquals(27, result.getSize());
			Assert.assertEquals('R', result.getType());
		} catch (ReportException e) {

			Assert.fail();
		}
	}

	@Test
	public void formaterLigneReferenceFailColorTest() {
		final String reference = "1462100403;R;100.1;9";
		try {
			LineParser.formaterLigneReference(reference);
		} catch (ReportException e) {
			Assert.assertEquals(Params.INCORRECT_COLOR, e.getMessage());
		}
	}

	@Test
	public void formaterLigneReferenceFailNumReferenceTest() {
		final String reference = "1400403abc;R;100.1;9";
		try {
			LineParser.formaterLigneReference(reference);
		} catch (ReportException e) {
			Assert.assertEquals(Params.INCORRECT_NUM_REFERENCE, e.getMessage());
		}
	}

	@Test
	public void formaterLigneReferenceFailPriceTest() {
		final String reference = "1400403235;G;100b.1;9";
		try {
			LineParser.formaterLigneReference(reference);
		} catch (ReportException e) {
			Assert.assertEquals(Params.INCORRECT_PRICE, e.getMessage());
		}
	}
	@Test
	public void formaterLigneReferenceFailSizeTest() {
		final String reference = "1400403235;G;100.1;G";
		try {
			LineParser.formaterLigneReference(reference);
		} catch (ReportException e) {
			Assert.assertEquals(Params.INCORRECT_SIZE, e.getMessage());
		}
	}
}
