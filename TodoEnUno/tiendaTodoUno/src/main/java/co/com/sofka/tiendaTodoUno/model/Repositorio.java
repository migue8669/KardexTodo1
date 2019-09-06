package co.com.sofka.tiendaTodoUno.model;

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
	
	public List<Kardex> getAllKardex();
	
	public void createKardex(Kardex kardex);
	
	public Kardex findByNameKardex(String name);
	
	public Document updateKardex (String id, Kardex kardex);
	
	public DeleteResult removeProduct(String id);
	
}