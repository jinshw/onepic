package com.ykkj.weiyi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoDatabase;

/** 
 * Describe class DBManager here. 
 * example: 
 * 初始化：MongoDBLink.getInstance().init(); 
 * 之后，每次通过下面的代码获取数据库对象 
 * MongoDBLink.getInstance().getDB(); 
 * 
 * @version 1.0 
 */  
public class MongoDBLink {
	private static MongoDBLink instance;
	
	private MongoClient mongoClient;
	
	private String ips = "127.0.0.1";
	private int port = 27017;
	private String dbname = "repository";
	private String username = "res";
	private String password = "res";
	
	private MongoDatabase db;
	
	static {
		instance = new MongoDBLink();
	}
	
	private MongoDBLink() {
		initMongoClient();
	}
	
	public static MongoDBLink getInstance() {
		return instance;
	}
	
	private void initMongoClient() {  
        System.setProperty("MONGO.POOLSIZE", "1000");
        
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.heartbeatFrequency(10000);
        builder.connectionsPerHost(300);// 连接池设置为300个连接,默认为100
        builder.connectTimeout(15000);// 连接超时，推荐>3000毫秒
        builder.maxWaitTime(5000); //
        builder.socketTimeout(0);// 套接字超时时间，0无限制
        builder.threadsAllowedToBlockForConnectionMultiplier(5000);// 线程队列数
        builder.writeConcern(WriteConcern.SAFE);//
        builder.build();
        MongoClientOptions options = builder.build(); 
		
        ServerAddress address = new ServerAddress(ips, port);
        //MongoDB 集群调用
		List<ServerAddress> addresses = new ArrayList<ServerAddress>();
		String[] ipArr = null;
		if(null != ips && !"".equals(ips)){
			ipArr = ips.split(",");
		}
		if (null != ipArr) {
			for (int i = 0; i < ipArr.length; i++) {
				addresses.add(new ServerAddress(ipArr[i], port));
			}
		}
		
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();   
//		MongoCredential credential = MongoCredential.createMongoCRCredential(username, dbname, password.toCharArray());
		MongoCredential credential = MongoCredential.createCredential(username, dbname, password.toCharArray());
        credentialsList.add(credential);
        
        mongoClient = new MongoClient(address,Arrays.asList(credential));
        
		db = mongoClient.getDatabase(dbname);
    }

	/**
     * 获取连接
     * @return
     */
	public DB getDB() {
		DB db = null;
		try {
			db = mongoClient.getDB(dbname);
		} catch (Exception e) {
			throw new RuntimeException("获取DB异常", e);
		}
		return db;
	}
	
	public MongoDatabase getDatabase(){
		return db;
	}
    
    /**
     * 
     * @param db 数据库
     * @param collection 集合
     * @param list 插入数据集
     * @return
     */
	public boolean insert(DB db,String collection,List<DBObject> list){
		DBCollection col = db.getCollection(collection);
		WriteResult res = col.insert(list,WriteConcern.SAFE);
//		String resultString = res.getError();
		int n = res.getN();
//		if (!StringUtils.isBlank(resultString)) {
		if (n<=0) {
			return false;
		}
		return true; 
	}
	/**
     * 
     * @param db 数据库
     * @param collection 集合
     * @param list 插入数据集
     * @return
     */
	public boolean insert(DB db,String collection,DBObject obj){
		DBCollection col = db.getCollection(collection);
		WriteResult res = col.insert(obj,WriteConcern.SAFE);
//		String resultString = res.getError();
		int n = res.getN();
//		if (!StringUtils.isBlank(resultString)) {
		if (n<0) {
			return false;
		}
		return true; 
	}
	
	/**
     * 保存并修改数据
     * @param db 数据库
     * @param collection 集合
     * @param list 插入数据集
     * @return
     */
	public boolean saveOrModify(DB db,String collection,DBObject obj){
		DBCollection col = db.getCollection(collection);
		WriteResult res = col.save(obj,WriteConcern.SAFE);
//		String resultString = res.getError();
		int n = res.getN();
//		if (!StringUtils.isBlank(resultString)) {
		if (n<=0) {
			return false;
		}
		return true; 
	}
	
	/**
	 * @param db 数据库
	 * @param collection 集合
	 * @param query 查询条件
	 * @param news 更新数据
	 * @return
	 */
	public boolean updata(DB db,String collection,DBObject query,DBObject news){
		DBCollection col = db.getCollection(collection);
		WriteResult res = col.update(query, news);
		if(res.getN()>0){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * @param db
	 * @param collection
	 * @param obj 要删除的对象
	 * @return
	 */
	public boolean delete(DB db,String collection,DBObject obj){
		DBCollection col = db.getCollection(collection);
		DBObject res = col.findAndRemove(obj);
		if(res != null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询列表
	 *
	 * @作者: 张晓东
	 * @创建日期： 2015年12月3日
	 *
	 * @param db
	 * @param collection
	 * @return
	 * @返回值： List<DBObject>
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
    public List<DBObject> findAll(DB db,String collection){
    	List<DBObject> list = new ArrayList<DBObject>();
    	DBCollection col = db.getCollection(collection);
    	DBCursor cur = col.find();
		while (cur.hasNext()) {
			list.add(cur.next());
		}
		return list;
    }
	
	/**
	 * 带查询条件查询列表
	 *
	 * @作者: 张晓东
	 * @创建日期： 2015年12月3日
	 *
	 * @param db
	 * @param collection
	 * @param query 查询条件
	 * @return
	 * @返回值： List<DBObject>
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
    public List<DBObject> findAllQuery(DB db,String collection, DBObject query){
    	List<DBObject> list = new ArrayList<DBObject>();
    	DBCollection col = db.getCollection(collection);
    	DBCursor cur = col.find(query);
		while (cur.hasNext()) {
			list.add(cur.next());
		}
		return list;
    }
    
    /**
     *  带分页查询所有集合
     *
     * @作者: 张晓东
     * @创建日期： 2015年12月3日
     *
     * @param db 数据库对象
     * @param collection 集合名称（表名）
     * @param query 查询条件
     * @param pageNo 当前页页码
     * @param pageSize 每页大小
     * @返回值： List<DBObject>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public List<DBObject> findAllPages(DB db,String collection,int pageNo,int pageSize){
    	List<DBObject> list = new ArrayList<DBObject>();
    	DBCollection col = db.getCollection(collection);
    	DBCursor cur = col.find().skip((pageNo-1) * pageSize).limit(pageSize);
    	while (cur.hasNext()) {
    		list.add(cur.next());
    	}
    	return list;
    }
    
    /**
     * @param db 数据库
     * @param collection 集合
     * @param obj 查询条件
     * @return
     */
    public DBObject find(DB db,String collection,DBObject obj){
    	DBCollection col = db.getCollection(collection);
    	return col.findOne(obj);
    }
    
    /**
     *  带分页带条件查询所有集合
     *
     * @作者: 张晓东
     * @创建日期： 2015年12月3日
     *
     * @param db 数据库对象
     * @param collection 集合名称（表名）
     * @param query 查询条件
     * @param pageNo 当前页页码
     * @param pageSize 每页大小
     * @返回值： List<DBObject>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public List<DBObject> findAllPagesQuery(DB db, String collection, DBObject query, int pageNo, int pageSize){
    	List<DBObject> list = new ArrayList<DBObject>();
    	DBCollection col = db.getCollection(collection);
    	DBCursor cur = col.find(query).skip((pageNo-1) * pageSize).limit(pageSize);
    	while (cur.hasNext()) {
    		list.add(cur.next());
    	}
    	return list;
    }
    
}
