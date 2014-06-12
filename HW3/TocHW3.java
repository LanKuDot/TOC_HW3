/* The JSON data is real-price housing information in Taiwan.
 * This program would get only data specified. User could decide
 * which data would get by appointing 鄉鎮市區, 路段, and 交易年月.
 * Then output the average sale price of the specified data.
 */

import java.io.IOException;

import org.json.*;

public class TocHW3
{
	public static void main( String[] args )
	{
		double avg_price = 0.0;      // The avarage sale price of matching data

		/* Get the arguments from command line */
		DataRequest request = new DataRequest(
				args[0], args[1], args[2], Integer.parseInt( args[3] ) );

		/* Generate regex string from input argument */
		String regex = "(?dm)\\{.*" + request.zone + ".*"
			+ request.zone + request.road + ".*"
			+ "\"交易年月\":" + request.year + ".*\\}";

		try
		{
			/* Parsing JSON file with regex */
			JsonWebReader webReader = new JsonWebReader();
			JSONArray data = webReader.readJsonFromURL( request.URL, regex );

			/* Calculating the average sale price */
			int totalEntries = 0;      // the num of non-empty entries 
			JSONObject element;        // Get the entry from JSONArray
			for ( int i = 0; i < data.length(); ++i )
			{
				// If the JSONObject is not null element, then get the sale price.
				if ( !data.isNull(i) )
				{
					++totalEntries;
					element = data.getJSONObject(i);
					avg_price += ((Integer)element.get( "總價元" )).doubleValue();
				}
			}

			avg_price = avg_price / (double) totalEntries;

			System.out.println( (int)avg_price );
		}
		catch ( IOException e )
		{
			System.out.println( e.toString() );
		}
		catch ( JSONException e )
		{
			System.out.println( e.toString() );
		}
	}
}	// end of TocHW3 class
