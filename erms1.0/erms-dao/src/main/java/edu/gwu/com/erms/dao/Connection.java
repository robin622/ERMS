package edu.gwu.com.erms.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Connection {
	private String host = "localhost";
	private int port = 27017;
	private String dbName = "test";

	private static Connection instance = null;

	// singleton model
	private Connection() {
	}

	public DB getConnection() {
		DB db = null;
		try {
			MongoClient client = new MongoClient(host, port);
			db = client.getDB(dbName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return db;
	}

	public static Connection getInstance() {
		if (Connection.instance == null) {
			Connection.instance = new Connection();
		}
		return Connection.instance;
	}
}
