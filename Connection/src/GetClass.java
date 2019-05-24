
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ListIterator;
import java.util.Scanner;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class GetClass
{
    public static void main(String [] args) throws Exception
    {
        //inline will store the JSON data streamed in string format
        String inline = "";
        JSONObject jsonLineItem=null;

        try
        {
            URL url = new URL("http://localhost:8080/rest/all");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " +responsecode);

            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if(responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " +responsecode);
            else
            {
                //Scanner functionality will read the JSON data from the stream
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    inline+=sc.nextLine();
                }
              //  System.out.println("\nJSON Response in String format");
               // System.out.println(inline);
                //Close the stream when reading the data has been finished
                sc.close();
            }

            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser parse = new JSONParser();
            //Type caste the parsed json data in json object
            JSONArray jobj = (JSONArray) parse.parse(inline);
           ListIterator a= jobj.listIterator();
           while (a.hasNext())
           {
               JSONObject b= (JSONObject) a.next();
              // System.out.println(b);
              String c= b.toString();
               ObjectMapper mapper = new ObjectMapper();
               Product emp = mapper.readValue(c, Product.class);
               System.out.println(emp.getName());

           }

        //Disconnect the HttpURLConnection stream
            conn.disconnect();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




    }
}