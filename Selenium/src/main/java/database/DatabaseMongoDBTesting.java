package database;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Properties;

import static database.DatabaseTesting.DB_URL;

public class DatabaseMongoDBTesting {
    MongoClient mongoClient = null;
    MongoDatabase db = null;


    @BeforeClass

    public void beforeClass() {
        try {
            //Connect to DB
            mongoClient = new MongoClient("localhost", 27017);
            db = mongoClient.getDatabase("users");
            System.out.println("Connected database successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void afterClass() throws SQLException {
        if ( mongoClient!= null)
            mongoClient.close();

    }

    @Test
    public void test() {
        try {
            //Get collection
            MongoCollection<Document> table = db.getCollection("user_info");
            //Extract data
            FindIterable<Document> cursor = table.find();
            //Get all data
            for (Document doc : cursor) {
                System.out.println(doc.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
