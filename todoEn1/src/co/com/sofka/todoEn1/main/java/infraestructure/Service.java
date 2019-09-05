package co.com.sofka.kardexTd1.infraestructure;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.sun.jersey.api.core.InjectParam;

import co.com.sofka.kardexTd1.model.*;

import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

@org.springframework.stereotype.Service("userService")
@Transactional
public class Service implements Repositorio {
	
	public static final String DB_NAME = "kardex";
    public static final String COLL_NAME_USER = "usuario";
    public static final String COLL_NAME_PRODUCT = "producto";
    public static final String COLL_NAME_KARDEX = "kardex";

    protected MongoDatabase db;
    protected MongoCollection<Document> collectionUser;
    protected MongoCollection<Document> collectionProduct;
    protected MongoCollection<Document> collectionKardex;
    
    @InjectParam
    MongoClient mongoClient;
    
    @PostConstruct
    public void init() {
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.collectionUser = this.db.getCollection(COLL_NAME_USER);
        this.collectionProduct = this.db.getCollection(COLL_NAME_PRODUCT);
        this.collectionKardex = this.db.getCollection(COLL_NAME_KARDEX);
    }
    
	
	public List<Usuario> findAllUser() {
		
		List<Usuario> userArray = new ArrayList<Usuario>();
		MongoCursor<Document> cursor = this.collectionUser.find().iterator();
		
		while (cursor.hasNext()) {
			Document UserBson = cursor.next();

			Usuario user = new Usuario();
			
			user.setId(UserBson.getString("id"));
			user.setName(UserBson.getString("Name"));
			user.setNit(UserBson.getString("Nit"));

			userArray.add(user);
		}
		return  userArray;
	}

	public void CreateUser(Usuario user) {
		Document doc = new Document();
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("Name", user.getName());
		doc.append("Nit", user.getNit());
		
		this.collectionUser.insertOne(doc);
	}

	public void updateUser(String id, Usuario user) {
		Document doc = new Document();
		doc.append("id", user.getId()).append("Name", user.getName()).append("Nit", user.getNit());
		this.collectionUser.findOneAndUpdate(eq("id", id), new Document("$set", doc));
	}
	
	public Usuario findByIdUser(String id) {
		Usuario user = new Usuario();
		Document UserBson = this.collectionUser.find(eq("id", id)).first();
		
		user.setId(UserBson.getString("id"));
		user.setName(UserBson.getString("Name"));
		user.setNit(UserBson.getString("Nit"));
		
		return user;
	}
	

	public List<Producto> getAllproduct() {
		
		List<Producto> productArray = new ArrayList<Producto>();
		MongoCursor<Document> cursor = this.collectionProduct.find().iterator();
		
		while (cursor.hasNext()) {
			
			Document ProductBson = cursor.next();
			Producto product = new Producto();
			
			product.setId(ProductBson.getString("id"));
			product.setDetail(ProductBson.getString("detail"));
			product.setStok(ProductBson.getString("stock"));
			product.setPrice(ProductBson.getString("price"));
			
			productArray.add(product);
		}
		return  productArray;
	}

	public void createProduct(Producto product) {
		Document doc = new Document();
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("detail", product.getDetail());
		doc.append("stock", product.getStok());
		doc.append("price", product.getPrice());
		
		this.collectionProduct.insertOne(doc);
	}

	public void updateProduct(String id, Producto product) {
		Document doc = new Document();
		doc.append("id", product.getId());
		doc.append("detail", product.getDetail());
		doc.append("stock", product.getStok());
		doc.append("price", product.getPrice());
		
		this.collectionProduct.findOneAndUpdate(eq("id", id), new Document("$set", doc));
	}


	public Producto findByIdProduct(String id) {
	
		Producto product = new Producto();
		try {
			Document ProductBson = this.collectionProduct.find(eq("id", id)).first();
			String _id = ProductBson.getString("id");
			String detail = ProductBson.getString("detail");
			
			product.setId(_id);
			product.setDetail(detail);
			
		} catch (NullPointerException e) {
			System.out.println("Caught Null Pointer Exception" + e);
		}
		
		return product;
	}
	
	public DeleteResult removeProduct(String id) {
		DeleteResult deleteResult = this.collectionProduct.deleteOne(eq("id", id));
		 
		 return deleteResult;
	}

	public List<KardexTd1> getAllKardex() {
		List<KardexTd1> kardexArray = new ArrayList<KardexTd1>();
		MongoCursor<Document> cursor = this.collectionKardex.find().iterator();
		
		while (cursor.hasNext()) {
			
			Document kardexBson = cursor.next();
			KardexTd1 kardex = new KardexTd1();
		
			kardex.setId(kardexBson.getString("id"));
			kardex.setAmountOutput(kardexBson.getString("AmountOutput"));
			kardex.setTotalOutput(kardexBson.getString("TotalOutput"));
			kardex.setInputAmount(kardexBson.getString("InputAmount"));
			kardex.setBalanceAmount(kardexBson.getString("BalanceAmount"));
			kardex.setTotalEntry(kardexBson.getString("TotalEntry"));
			kardex.setDetail(kardexBson.getString("Detail"));
			kardex.setValue(kardexBson.getString("Value"));
			kardex.setTotalBalance(kardexBson.getString("TotalBalance"));
			kardex.setDate(kardexBson.getString("Date"));
			
			kardexArray.add(kardex);
		}
		return  kardexArray;
	}
	

	
	public void createKardex(KardexTd1 kardex) {
		Document doc = new Document();
		TotalKardex resultadoKardex = new TotalKardex();
		Date fecha = new Date();
		
		String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat formaDate = new SimpleDateFormat(strDateFormat);
		
		Random ran = new Random();
		doc.append("id", String.valueOf(ran.nextInt(100000000)));
		doc.append("AmountOutput", kardex.getAmountOutput());
		doc.append("TotalOutput", kardex.getTotalOutput());
		doc.append("InputAmount", kardex.getInputAmount());
		doc.append("BalanceAmoun", kardex.getBalanceAmount());
		doc.append("TotalEntry", resultadoKardex.kardexTotalTicket(kardex));
		doc.append("Detail", kardex.getDetail());
		doc.append("Value", kardex.getValue());
		doc.append("TotalBalance", kardex.getTotalBalance());
		doc.append("Date",  formaDate.format(fecha));
		this.collectionKardex.insertOne(doc);
			
	}
	
	public String EntryKardex(KardexTd1 kardex) {
		
		String resul = this.findByNameKardex(kardex.getDetail()).getDetail();
		if (kardex.getDetail().equals(resul)) {
			updateKardex(kardex.getDetail(), kardex);
			return "update";
		}else {
			createKardex(kardex);
			return "create";
		}
	}
	

	public KardexTd1 findByNameKardex(String name) {
		KardexTd1 kardex = new KardexTd1();
		
		try {
			Document kardexBson = this.collectionKardex.find(eq("Detail", name)).first();
			
			kardex.setId(kardexBson.getString("id"));
			kardex.setAmountOutput(kardexBson.getString("AmountOutput"));
			kardex.setTotalOutput(kardexBson.getString("TotalOutput"));
			kardex.setInputAmount(kardexBson.getString("InputAmount"));
			kardex.setBalanceAmount(kardexBson.getString("BalanceAmount"));
			kardex.setTotalEntry(kardexBson.getString("TotalEntry"));
			kardex.setDetail(kardexBson.getString("Detail"));
			kardex.setValue(kardexBson.getString("Value"));
			kardex.setTotalBalance(kardexBson.getString("TotalBalance"));
			kardex.setDate(kardexBson.getString("Date"));
			
		} catch (NullPointerException e) {
			System.out.println("Caught Null Pointer Exception" + e);
		}
		
		return kardex;
	}

	public Document updateKardex(String Detail, KardexTd1 kardex) {
		TotalKardex resultadoKardex = new TotalKardex();
		Document doc = new Document();
		
		doc.append("AmountOutput", kardex.getAmountOutput());
		doc.append("TotalOutput", kardex.getTotalOutput());
		doc.append("InputAmount", kardex.getInputAmount());
		doc.append("BalanceAmoun", kardex.getBalanceAmount());
		doc.append("TotalEntry", resultadoKardex.kardexTotalTicket(kardex));
		doc.append("Detail", kardex.getDetail());
		doc.append("Value", kardex.getValue());
		doc.append("TotalBalance", kardex.getTotalBalance());
		//doc.append("Date", kardex.getDate());
		Document result = this.collectionKardex.findOneAndUpdate(eq("Detail", Detail), new Document("$set", doc));
		return result;
	}


	
	
}
