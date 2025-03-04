package resources;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileInputStream;
 public class Utils {
	static RequestSpecification requestbuild;
	static ResponseSpecification responsebuild;
	static PrintStream log;
	static Properties prop;
	//Create Requestbuilder for unique request collection.
	public RequestSpecification requestbuilder() throws IOException
	{
		if(requestbuild==null)
		{
		log=new PrintStream(new FileOutputStream("logging.text"));
		requestbuild=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return requestbuild;
		}
		
		return requestbuild;
	}

	
	
	//Create Responsebuilder for unique response validation collection.
		public ResponseSpecification responsebuilderforstatuscode(Integer int1)
		{
			if(responsebuild==null)
			{
			responsebuild =new ResponseSpecBuilder().expectStatusCode(int1).expectContentType(ContentType.JSON).build();
			return responsebuild;
			}
			return responsebuild;
		}
		
		
		public static String getGlobalValue(String globalvariable) throws IOException
		{
			prop=new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\APIAutomationwithBDD\\src\\test\\java\\resources\\Global.properties");
			prop.load(file);
			String value=prop.getProperty(globalvariable);
			
			return value;
		}
}
