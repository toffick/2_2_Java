package by.borsuk.JSON;

import by.borsuk.AirManager.CreateAirCargo;
import by.borsuk.AirManager.CreateAirMilitary;
import by.borsuk.AirManager.CreateAirPassenger;
import by.borsuk.AirManager.FactoryMethod;
import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import javax.xml.ws.Response;
import java.io.*;


public class JSONPars {

    public boolean objtoJSON(Airplanes tempair, String jsonfilePath) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(jsonfilePath);

            JsonObject rootObject = new JsonObject();
            JsonObject airplane = new JsonObject();
            rootObject.addProperty("airplane", tempair.getClassName());

            airplane.addProperty("capacity", tempair.getCapacity());
            airplane.addProperty("weith", tempair.getWeight());
            airplane.addProperty("fuel", tempair.getFuelConsumption());
            airplane.addProperty("rang", tempair.getFlightRange());
            airplane.addProperty("model", tempair.getAirtType().toString());
            rootObject.add("info", airplane);

            Gson gson = new Gson();
            fileWriter.write(gson.toJson(rootObject));

            return true;

        } catch (Exception e) {
            System.out.println("Json create error: " + e.getMessage());
            return false;
        } finally {
            fileWriter.close();
        }

    }

    public Airplanes  JSONtoobj( String jsonfilePath) {

        Airplanes tempair = null;
        try {
            FileReader fileReader = new FileReader(jsonfilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String jsonstring = bufferedReader.readLine();

            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(jsonstring);
            JsonObject rootObject = jsonElement.getAsJsonObject();

            FactoryMethod crCargo = new CreateAirCargo();
            FactoryMethod crMilitary = new CreateAirMilitary();
            FactoryMethod crPassenger = new CreateAirPassenger();

            if(rootObject.get("airplane").getAsString().equals("AirCargo"))
            {
                tempair = crCargo.CreateAirplane();
            }else
            if(rootObject.get("airplane").getAsString().equals("AirMilitary"))
            {
                tempair = crMilitary.CreateAirplane();
            }else
            if(rootObject.get("airplane").getAsString().equals("AirPassenger"))
            {
                tempair = crPassenger.CreateAirplane();
            }

            JsonObject info = rootObject.getAsJsonObject("info");
            tempair.set_weight(Integer.parseInt(info.get("weith").getAsString()));
            tempair.set_capacity(Integer.parseInt(info.get("capacity").getAsString()));
            tempair.set_fuelconsumption(Integer.parseInt(info.get("fuel").getAsString()));
            tempair.set_flightrange(Integer.parseInt(info.get("rang").getAsString()));
            tempair.set_type(AirType.valueOf(info.get("model").getAsString()));


        } catch (Exception e) {
            System.out.println("Json create error: " + e.getMessage());
        }
        finally
        {
            return tempair;
        }

    }
}
