package com.hardis.fr.text.converter.controller;

import java.io.File;

import com.hardis.fr.text.converter.soa.TextParserSOA;

public class TextParserController {

	TextParserSOA textParserSOA;

	public String generateJsonFromText(File file) {
		return textParserSOA.generateJsonFromText(file);
	}

	public String generateXmlFromText(File file) {
		return textParserSOA.generateXmlFromText(file);
	}
}
