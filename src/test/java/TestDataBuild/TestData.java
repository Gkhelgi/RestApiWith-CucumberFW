package TestDataBuild;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import pojo.AddPlace;
import pojo.Location;

public class TestData {
	
	
	public AddPlace addplacePayload(String name, String language, String address)
	{
		AddPlace p =new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(name);
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location location =new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		//p.setLocation(location);
		//ObjectMapper mapper = new ObjectMapper();
		//String s = mapper.writeValueAsString(p);
		
		return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
	}


