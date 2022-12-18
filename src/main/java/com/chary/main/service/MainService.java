package com.chary.main.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Service;

import com.chary.main.config.JobConfiguration;
import com.chary.main.model.DateStr;
import com.chary.main.model.ScheduleParam;
import com.chary.main.repository.Repo;

@Service
public class MainService {

	@Autowired
	JobConfiguration jobConfig;

	@Autowired
	Repo repo;

	public Boolean schedule(ScheduleParam scheduleData) throws Exception {
//		DateStr todaysDate = new DateStr();
//
//		Date todayDate = new Date();
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
//		todaysDate.setDate(dateFormat.format(todayDate));
//
//		Example<DateStr> example = Example.of(todaysDate);
//		List<DateStr> list = repo.findAll(example);
//		//System.out.println(list.size());
//		//System.out.println(example);
//
//		FileReader file=new FileReader("src/main/resources/application.properties");
//		Properties properties= new Properties();
//		properties.load(file);
//		
//		var mongoClient = MongoClients.create(properties.getProperty("url"));
//
//		var database = mongoClient.getDatabase(properties.getProperty("spring.data.mongodb.database"));
//
//		MongoCollection<Document> collection = database.getCollection("HolidayCollection");
//
//		Document eg=collection.find(new Document("Date",todaysDate.getDate())).first();
//		System.out.println(eg);
//		
//		mongoClient.close();
		return jobConfig.init(scheduleData);
	}

	public boolean findHoliday() throws IOException {
		DateStr todaysDate = new DateStr();

		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

		todaysDate.setDate(dateFormat.format(todayDate));
		
		FileReader fileReader = new FileReader("C:\\Users\\Admin\\Desktop\\Holidays.txt");
		BufferedReader br=new BufferedReader(fileReader);
		String line="";
	    //System.out.println(todaysDate.Date);
		while((line=br.readLine())!=null) {
			if(line.equals(todaysDate.getDate().toString())) {
	    		return true;
	    	}
	    }
	    br.close();
	    //return repo.findById(todaysDate.getDate()) == null ? false : true;
	    return false;
	}
	
//	public boolean containsInDatabase(DateStr todaysDate) throws IOException {
//		
//		FileReader file=new FileReader("src/main/resources/application.properties");
//		Properties properties= new Properties();
//		properties.load(file);
//		
//		var mongoClient = MongoClients.create(properties.getProperty("url"));
//
//		var database = mongoClient.getDatabase(properties.getProperty("spring.data.mongodb.database"));
//
//		MongoCollection<Document> collection = database.getCollection(properties.getProperty("HolidayCollection"));
//
//		Document eg=collection.find(new Document("Date",todaysDate)).first();
//		//System.out.println(collection.find(new Document("Date",todaysDate)).first().containsValue(todaysDate.getDate())+" "+todaysDate.getDate()+" "+collection.find(new Document("Date","29/9/2022")).first());
//		
//		mongoClient.close();
//		if(eg==null) {
//			return false;
//		}
//		return true;
//	}

}
