package co.com.sofka.kardexTd1.model;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.result.DeleteResult;


public interface Repositorio   {
	
	public  List<Usuario> findAllUser();
	
	public void CreateUser (Usuario user);
	
	public void updateUser (String id, Usuario user);
	
	public Usuario findByIdUser(String id);
	
	public List<Producto> getAllproduct();
	
	public void createProduct(Producto product);
	
	public void updateProduct (String id, Producto product);
	
	public Producto findByIdProduct(String id);
	
	public List<KardexTd1> getAllKardex();
	
	public void createKardex(KardexTd1 kardex);
	
	public KardexTd1 findByNameKardex(String name);
	
	public Document updateKardex (String id, KardexTd1 kardex);
	
	public DeleteResult removeProduct(String id);
	
}