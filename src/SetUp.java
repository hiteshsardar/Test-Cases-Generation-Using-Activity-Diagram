import java.io.File;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SetUp extends Variables{

    SetUp(){
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(new File(FULL_FILE_ADDRESS));

        } catch (SAXParseException err) {

//        	Checking the file is .xmi file or not
            System.out.println("** Parsing error **" +
            		"\nPlease Check The Uploaded file Once again.(Only .xmi file is Acceptable)" +
            		"\nUploaded " + err.getSystemId());
            System.exit(0);

        } catch (SAXException e) {

            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        	System.exit(0);

        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(0);
        }
    }


    
	public void show(){
//		normalize text representation
        doc.getDocumentElement().normalize();
        System.out.println("==============================");
        System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());
        
    }
}
