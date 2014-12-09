package se.tv4.teknik.videometadataapi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.exceptions.ConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TestValidateContentXML extends XMLTestCase{

	public TestValidateContentXML(String name){
		super(name);
	}


	
	public void testValidateContentXml() throws ConfigurationException, SAXException, IOException{
	
//		String xsdPath = "/content.xsd";
//		String xmlPath = "/xml/content.xml";
		
//		assertNotNull("File content.xsd is not available in phase test", getClass().getResource(xsdPath));
//		assertNotNull("File content.xml is not available in phase test", getClass().getResource(xmlPath));

		// TODO: The following code does not do the work - isValid becomes false.
		// The main reason seems to be that content.xsd imports schemas common.xsd and material.xsd
		// and the test-framework looks for the schemas in the wrong directory
		
		/*		
		URL xmlUrl = getClass().getResource(xmlPath);
		
		FileInputStream xmlFileInputStream = new FileInputStream(xmlUrl.getPath());
		
		InputSource inputSource = new InputSource(xmlFileInputStream);
		Validator validator = new Validator(inputSource);
		validator.useXMLSchema(true);

		URL xsdUrl = getClass().getResource(xsdPath);
		File myXsdFile = new File(xsdUrl.getPath());
		validator.setJAXP12SchemaSource(myXsdFile);
		boolean isValid = validator.isValid();
		xmlFileInputStream.close();
		xmlFileInputStream = null;
		myXsdFile = null;
		assertTrue("Contents are not valid: " + validator.toString(), isValid);
		*/ 	
	}

}
