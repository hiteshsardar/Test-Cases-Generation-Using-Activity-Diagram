
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

	public class Variables {
	
//	Folder path
    final static String FOLDER_ADDRESS = "src/Activity_Diagram/";
//  File path
    final static String FILE_ADDRESS = "Library_System/Library_System.xmi";
    
    final static String NODE = "node";
    final static String EDGE = "edge";
    final static String FULL_FILE_ADDRESS = FOLDER_ADDRESS + FILE_ADDRESS;
    
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    static DocumentBuilder docBuilder; 
    static Document doc;
}