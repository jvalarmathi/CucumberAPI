package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Location;

public class TestData {
	AddPlace ap=new AddPlace();
	DeletePlace dp=new DeletePlace();
	public AddPlace AddPlacePayload(String name,String address,String language)
	{
		Location l=new Location();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setName(name);
		ap.setPhone_number("1234567890");
		ap.setWebsite("http://google.com");
        ap.setLanguage(language);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		List<String> type=new ArrayList<String>();
		type.add("testing");
		type.add("shop");
		ap.setTypes(type);
		return ap;
	}
	
	public String deletePlacePayload(String placeid)
	{
	
		return "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}"
		;
	}
}
