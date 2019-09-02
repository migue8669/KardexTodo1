package com.example.kardex.Dominio.Modelo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
@Document(collection = "producto")
public class Productos {
    @Id
    private String id;
    private String producto;
    private String talla;
    private String genero;
    private String precio;


}