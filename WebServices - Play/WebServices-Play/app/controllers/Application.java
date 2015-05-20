package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import jdk.nashorn.internal.runtime.JSONFunctions;
import play.*;
import play.api.libs.json.*;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

import java.sql.ResultSet;
import java.util.Hashtable;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready. Hola :D"));
    }

    /*
     * El siguiente método hace una multiplicación de enteros.
     * @param a el primer  entero.
     * @param b el segundo entero.
     * @return Resultado en formato Json.
     */
    public static Result getMultiplicacion(int a, int b) {
        ObjectNode result = Json.newObject();
        result.put("resultado", a * b);
        return ok(result);
    }

    /*
     * El siguiente método verifica si una cadena es un palíndromo.
     * @param word la palabra a validar.
     * @return true o false en formato Json.
     */
    public static Result getPalindromo(String word){
        ObjectNode result = Json.newObject();
        String myWord = word.replaceAll("\\s+","");
        String reverse = new StringBuffer(myWord).reverse().toString();
        result.put("resultado", reverse.equalsIgnoreCase(myWord));
        return ok(result);
    }

    public static Result getPeso(double dolar){
        ObjectNode result = Json.newObject();
        double usd = 14.92;
        result.put("Pesos", dolar*usd);
        return ok(result);

    }

    public static Result getCelcius(double kelvin){
        ObjectNode result = Json.newObject();
        result.put("Celcius", kelvin - 272.15);
        return ok(result);

    }


    public static Result getCapital(String pais){
        ObjectNode result = Json.newObject();
        Hashtable<String, String> hashtable = new Hashtable<String, String>();

        hashtable.put("España", "Madrid");
        hashtable.put("Alemania", "Berlin");
        hashtable.put("Reino Unido", "Londres");
        hashtable.put("Austria", "Vienna");
        hashtable.put("Francia", "Paris");
        hashtable.put("Italia", "Roma");

        result.put("Capital", hashtable.get(pais));
        return ok(result);


    }

    public static Result getEmbajada(String pais){
        ObjectNode result = Json.newObject();
        Hashtable<String, String> hashtable = new Hashtable<String, String>();

        hashtable.put("España", "40.4160947,-3.6973632");
        hashtable.put("Alemania", "52.507790, 13.351741");
        hashtable.put("Reino Unido", "51.513102, -0.143613");
        hashtable.put("Austria", "48.1998585,16.3700744");
        hashtable.put("Francia", "48.8648275,2.292344");
        hashtable.put("Italia", "41.9133032,12.5097257");

        result.put("Embajada", hashtable.get(pais));
        return ok(result);


    }


}
