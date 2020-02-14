package TestDataBuild;

public enum APIEnums {
	
	addPlaceApi(""),
	getPlaceApi(""),
	deletePlaceApi("");
	private String resource;
	
	APIEnums(String resource)
	{
		this.resource=resource;
	}
  public String getResource()
  {
	return resource;
	  
  }
}
