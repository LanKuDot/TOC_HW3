/* The data structure of the requesting data. */
public class DataRequest
{
	public String URL;	// The URL of Json file
	public String zone;
	public String road;
	public int year;

	/* Constructor */
	public DataRequest( String URL,
			String zone, String road, int year )
	{
		this.URL = URL;
		this.zone = zone;
		this.road = road;
		this.year = year;
	}
}	// end of DataRequest class
