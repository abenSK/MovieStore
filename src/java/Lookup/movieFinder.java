package Lookup;

import DB.DBConnect;
import java.sql.ResultSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
 * This class gives the ability to access movies via store id, inventory id
 * or movie title. 
 * It returns the requested information as a JSON array.
 */
/**
 *
 * @author aben
 */


public class movieFinder {
    
    private JsonArray movieArray;
    private JsonObject movieObject;
    
    
    public movieFinder() {
        this.movieObject = null;
        this.movieArray = null;
    }
    /*
        Given a store ID and a title
        returns all movies with that title in that store
    */
    public JsonArray lookUpByStoreID (int id,String title){
        movieLookupStore(id,title);
        return movieArray;
    }
    
    /*
        Look up movie by inventory ID
    */
    public JsonArray lookupByInvID(int id){
        movieLookupInv(id);
        return movieArray;
    }
    /*
        Look up movie by title
    */
    public JsonArray lookupByTitle(String title){
        movieLookupTitle(title);
        return movieArray;
    }

    private void movieLookupStore(int id, String title) {
        DBConnect db = null;
        movieArray = new JsonArray();
        
        try {
            db = new DBConnect();
            String query = "SELECT inventory_id, s.store_id, title, description, length,rating, release_year, rental_duration, rental_rate, address,district,city "
                    + "FROM inventory i "
                    + "left join film f on f.film_id = i.film_id "
                    + "left join store s on s.store_id = i.film_id "
                    + "left join address a on a.address_id = s.address_id "
                    + "left join city c on c.city_id = a.city_id "
                    + "where i.store_id = ? and f.title = ? ";
            db.newQuery(query);
            db.statement.setInt(1, id);
            db.statement.setString(2, title);
            ResultSet rs = db.statement.executeQuery();
            while (rs.next()) {
                movieObject = new JsonObject();
                movieObject.addProperty("inv_id", rs.getInt("inventory_id"));
                movieObject.addProperty("store_id", rs.getInt("store_id"));
                movieObject.addProperty("title", rs.getString("title"));
                movieObject.addProperty("desc", rs.getString("description"));
                movieObject.addProperty("length", rs.getInt("length"));
                movieObject.addProperty("rating", rs.getString("rating"));
                movieObject.addProperty("release", rs.getString("release_year"));
                movieObject.addProperty("rental_duration", rs.getInt("rental_duration"));
                movieObject.addProperty("rental_rate", rs.getBigDecimal("rental_rate"));
                movieObject.addProperty("address", rs.getString("address"));
                movieObject.addProperty("district", rs.getString("district"));
                movieObject.addProperty("city", rs.getString("city"));
                
                movieArray.add(movieObject);
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.closeConnection();
            }
        }
    }
    private void movieLookupInv(int id) {
        DBConnect db = null;
        movieArray = new JsonArray();
        
        try {
            db = new DBConnect();
            String query = "SELECT inventory_id, s.store_id, title, description, length,rating, release_year, rental_duration, rental_rate, address,address2,district,city "
                    + "FROM inventory i "
                    + "left join film f on f.film_id = i.film_id "
                    + "left join store s on s.store_id = i.film_id "
                    + "left join address a on a.address_id = s.address_id "
                    + "left join city c on c.city_id = a.city_id "
                    + "where i.inventory_id = ? ";
            db.newQuery(query);
            db.statement.setInt(1, id);
            ResultSet rs = db.statement.executeQuery();
            while (rs.next()) {
                movieObject = new JsonObject();
                movieObject.addProperty("inv_id", rs.getInt("inventory_id"));
                movieObject.addProperty("inv_id", rs.getInt("inventory_id"));
                movieObject.addProperty("store_id", rs.getInt("store_id"));
                movieObject.addProperty("title", rs.getString("title"));
                movieObject.addProperty("desc", rs.getString("description"));
                movieObject.addProperty("length", rs.getInt("length"));
                movieObject.addProperty("rating", rs.getString("rating"));
                movieObject.addProperty("release", rs.getString("release_year"));
                movieObject.addProperty("rental_duration", rs.getInt("rental_duration"));
                movieObject.addProperty("rental_rate", rs.getBigDecimal("rental_rate"));
                movieObject.addProperty("address", rs.getString("address"));
                movieObject.addProperty("district", rs.getString("district"));
                movieObject.addProperty("city", rs.getString("city"));
                movieArray.add(movieObject);
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.closeConnection();
            }
        }
    }
    
    private void movieLookupTitle(String title) {
        DBConnect db = null;
        movieArray = new JsonArray();
        
        try {
            db = new DBConnect();
            String query = "SELECT inventory_id, s.store_id, title, description, length,rating, release_year, rental_duration, rental_rate, address,address2,district,city "
                    + "FROM inventory i "
                    + "left join film f on f.film_id = i.film_id "
                    + "left join store s on s.store_id = i.film_id "
                    + "left join address a on a.address_id = s.address_id "
                    + "left join city c on c.city_id = a.city_id "
                    + "where title = ? ";
            db.newQuery(query);
            db.statement.setString(1, title);
            ResultSet rs = db.statement.executeQuery();
            while (rs.next()) {
                movieObject = new JsonObject();
                movieObject.addProperty("inv_id", rs.getInt("inventory_id"));
                movieObject.addProperty("inv_id", rs.getInt("inventory_id"));
                movieObject.addProperty("store_id", rs.getInt("store_id"));
                movieObject.addProperty("title", rs.getString("title"));
                movieObject.addProperty("desc", rs.getString("description"));
                movieObject.addProperty("length", rs.getInt("length"));
                movieObject.addProperty("rating", rs.getString("rating"));
                movieObject.addProperty("release", rs.getString("release_year"));
                movieObject.addProperty("rental_duration", rs.getInt("rental_duration"));
                movieObject.addProperty("rental_rate", rs.getBigDecimal("rental_rate"));
                movieObject.addProperty("address", rs.getString("address"));
                movieObject.addProperty("district", rs.getString("district"));
                movieObject.addProperty("city", rs.getString("city"));
                movieArray.add(movieObject);
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.closeConnection();
            }
        }
    }
    
   
    

}
