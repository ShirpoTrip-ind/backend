import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Place {
    private String placeId;
    private String name;
    private String address;

    public Place(String placeId, String name, String address) {
        this.placeId = placeId;
        this.name = name;
        this.address = address;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

public class PlaceRepository {
    private final MongoCollection<Document> collection;

    public PlaceRepository() {
        MongoDatabase database = MongoClients.create().getDatabase("your_database_name");
        this.collection = database.getCollection("places_collection");
    }

    public void addPlace(Place place) {
        collection.insertOne(Document.parse(place.toJson()));
    }

    public List<Place> getPlaces() {
        List<Place> places = new ArrayList<>();
        for (Document doc : collection.find()) {
            places.add(new Place(doc.toJson()));
        }
        return places;
    }

    public Place getPlace(String placeId) {
        Document doc = collection.find(new Document("placeId", placeId)).first();
        if (doc != null) {
            return new Place(doc.toJson());
        }
        return null;
    }
}
