package com.java.mongo.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ResourceBundle;

public class ConnectionHelper {
  private static MongoClient client = null;
  private static MongoDatabase dbs = null;

  static {
    ResourceBundle rb = ResourceBundle.getBundle("db");
    String driver = rb.getString("driver");
    String db = rb.getString("db");

    client = MongoClients.create(driver);
    dbs = client.getDatabase(db);
  }

  public static MongoDatabase getConnection() {
    return dbs;
  }
}

