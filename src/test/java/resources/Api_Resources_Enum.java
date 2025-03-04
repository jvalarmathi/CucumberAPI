package resources;

public enum Api_Resources_Enum {

	AddplaceAPI ("/maps/api/place/add/json"),
	GetplaceAPI ("/maps/api/place/get/json"),
	DeleteplaceAPI ("/maps/api/place/delete/json");
	private String resource;
	
	Api_Resources_Enum(String resource) {
		this.resource=resource;
	}

	public String getresource()
	{
		return resource;
	}
}
