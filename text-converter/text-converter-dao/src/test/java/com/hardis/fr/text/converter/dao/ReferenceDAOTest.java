package com.hardis.fr.text.converter.dao;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.hardis.fr.text.converter.dao.impl.ReferenceDAOImpl;
import com.hardis.fr.text.converter.models.entities.Report;
import com.hardis.fr.text.converter.models.entities.ReportJson;
import com.hardis.fr.text.converter.models.entities.ReportXml;

@RunWith(PowerMockRunner.class)
public class ReferenceDAOTest {

	@Test
	public void getReportFromFileTest() {
		String entryFileName = ReferenceDAOTest.class.getResource("/references.txt").getFile();

		File file = new File(entryFileName);
		try {
			final Report result = Whitebox.invokeMethod(new ReferenceDAOImpl(), "getReportFromFile", file, "XML");
			Assert.assertNotNull(result);
			Assert.assertTrue(result.getInputFile().contains("references.txt"));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void getReportFromFileJsonTest() {
		String entryFileName = ReferenceDAOTest.class.getResource("/references.txt").getFile();

		File file = new File(entryFileName);
		try {
			final ReportJson result = Whitebox.invokeMethod(new ReferenceDAOImpl(), "getReportFromFile", file, "Json");
			Assert.assertNotNull(result);
			Assert.assertEquals(1, result.getErrors().size());
			Assert.assertEquals(4, result.getReferences().size());
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void getReportFromFileXMLTest() {
		String entryFileName = ReferenceDAOTest.class.getResource("/references.txt").getFile();

		File file = new File(entryFileName);
		try {
			final ReportXml result = Whitebox.invokeMethod(new ReferenceDAOImpl(), "getReportFromFile", file, "XML");
			Assert.assertNotNull(result);
			Assert.assertEquals(1, result.getErrors().getErrors().size());
			Assert.assertEquals(4, result.getReferences().getReferences().size());
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
