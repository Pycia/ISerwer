package pl.edu.pk.cyberMama.dao;

import com.mongodb.*;
import pl.edu.pk.cyberMama.model.User;

import java.net.UnknownHostException;

/**
 * Created by Nati on 30.03.14.
 */
public class UsersDaoSingleton {
    private static UsersDaoSingleton instance;
    private DB db;

    public synchronized static UsersDaoSingleton getInstance(){
        if(instance==null)
            instance= new UsersDaoSingleton();
        return instance;
    }

    public UsersDaoSingleton() {

        try {
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            db = mongoClient.getDB( "test" );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public String getUserByLogin(String login){
        DBCursor cursor=db.getCollection("scores").find(QueryBuilder.start("name").is(login).get());
        if(cursor.hasNext())
        {
            DBObject object=cursor.next();
            return(object.get("passwordHash").toString());
        } else
            return null;
    }
}