package com.hardis.fr.text.converter.soa.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.hardis.fr.text.converter.dao.ReferenceDAO;
import com.hardis.fr.text.converter.exceptions.ReportException;
import com.hardis.fr.text.converter.models.entities.Report;
import com.hardis.fr.text.converter.models.entities.ReportXml;
import com.hardis.fr.text.converter.soa.TextParserSOA;

public class TextParserSOAImpl implements TextParserSOA {

	public static final String FORMAT_XML = "XML";
	public static final String FORMAT_JSON = "Json";

	/**
	 * DAO d'accès au données
	 */
	private ReferenceDAO referenceDAO;

	public String generateXmlFromText(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(ReportXml.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ReportXml reportXml = (ReportXml) referenceDAO.getReportFromFile(file, FORMAT_XML);
			m.marshal(reportXml, System.out);

		} catch (JAXBException ex) {
			ex.printStackTrace();
		} catch (ReportException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String generateJsonFromText(File file) {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		Report reportJson;
		try {
			reportJson = referenceDAO.getReportFromFile(file, FORMAT_JSON);
			String jsonEmp1 = objectWriter.writeValueAsString(reportJson);
			return jsonEmp1;
		} catch (ReportException e) {
			e.printStackTrace();

		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public void setReferenceDAO(ReferenceDAO referenceDAO) {
		this.referenceDAO = referenceDAO;
	}

}
