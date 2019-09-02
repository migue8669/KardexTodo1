package com.example.kardex.Dominio.Repositiorio;


import com.example.kardex.Dominio.Modelo.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductosRepositorio extends MongoRepository<Productos, String> {}
