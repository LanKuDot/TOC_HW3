/* The JSON data is real-price housing information in Taiwan.
 * This program would get only data specified. User could decide
 * which data would get by assigning the District, the Road, and
 * the Year saled. Note that the program will find all houses
 * saled at/after the Year.
 * Then output the average sale price of the specified houses saled.
 *
 * Run:
 *   java -cp ".:jason.jar" TocHW3 <URL> <District> <Road> <Year>
 */

import java.io.IOException;

import org.json.*;

public class TocHw3
{
	public static void main( String[] args )
	{
		double avg_price = 0.0;      // The avarage sale price of matching data

		/* Get the arguments from command line */
		DataRequest request = new DataRequest(
				args[0], args[1], args[2], Integer.parseInt( args[3] ) );

		try
		{
			/* Parsing JSON file with regex */
			JsonWebReader webReader = new JsonWebReader();
			JSONArray data = webReader.readJsonFromURL( request.URL, request );

			/* Calculating the average sale price */
			int totalEntries = 0;      // the num of non-empty entries
			JSONObject element;        // Get the entry from JSONArray
			int yearCompare = ( request.year - 1 ) * 100 + 99;
			                           // Year format: (Integer) YYYMM
			for ( int i = 0; i < data.length(); ++i )
			{
				// If the JSONObject is not null element, then get the sale price.
				if ( !data.isNull(i) )
				{
					element = data.getJSONObject(i);
					// Take the house data which was saled at/after the Year.
					if ( ((Integer)element.get( "交易年月" )).intValue() > yearCompare )
					{
						++totalEntries;
						avg_price += ((Integer)element.get( "總價元" )).doubleValue();
					}
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
