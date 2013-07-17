package com.project.rest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.project.rest.model.Document;

@Repository
public class DocumentService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "document";
	
	public void addDocument(Document document) {
		if (!mongoTemplate.collectionExists(Document.class)) {
			mongoTemplate.createCollection(Document.class);
		}		
		document.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(document, COLLECTION_NAME);
	}
	
	public List<Document> listDocument() {
		return mongoTemplate.findAll(Document.class, COLLECTION_NAME);
	}
	
	public void deleteDocument(Document document) {
		mongoTemplate.remove(document, COLLECTION_NAME);
	}
	
	public void updateDocument(Document document) {
		mongoTemplate.insert(document, COLLECTION_NAME);		
	}
}
