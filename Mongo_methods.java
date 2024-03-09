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

public interface PlaceRepository {
    void addPlace(Place place);

    List<Place> getPlaces();

    Place getPlace(String placeId);
}

public class PlaceRepositoryImpl implements PlaceRepository {
    private final MongoCollection<Document> collection;
    private final Gson gson = new Gson();

    public PlaceRepositoryImpl(String databaseName, String collectionName) {
        MongoDatabase database = MongoClients.create().getDatabase(databaseName);
        this.collection = database.getCollection(collectionName);
    }

    @Override
    public void addPlace(Place place) {
        Document doc = new Document("placeId", place.getPlaceId())
                .append("name", place.getName())
                .append("address", place.getAddress());
        collection.insertOne(doc);
    }

    @Override
    public List<Place> getPlaces() {
        List<Place> places = new ArrayList<>();
        for (Document doc : collection.find()) {
            Place place = gson.fromJson(doc.toJson(), Place.class);
            places.add(place);
        }
        return places;
    }

    @Override
    public Place getPlace(String placeId) {
        Document doc = collection.find(new Document("placeId", placeId)).first();
        if (doc != null) {
            return gson.fromJson(doc.toJson(), Place.class);
        }
        return null;
    }
}
