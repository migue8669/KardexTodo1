package com.example.kardex.Controller;

import com.example.kardex.Dominio.Modelo.Productos;
import com.example.kardex.Dominio.Repositiorio.ProductosRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductosController {
    @Autowired
    ProductosRepositorio productosRepositorio;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Productos> getfindAll() {
        return productosRepositorio.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Productos> getByIdProducto(@PathVariable("id") String id) {
        return productosRepositorio.findById(id);
    }

    @RequestMapping(value = "/saveNewProducto/", method = RequestMethod.POST)
    public Productos createProducto(@Valid @RequestBody Productos producto) {

        return productosRepositorio.save(producto);
    }

    @RequestMapping(value = "/updateByIdProducto/{id}", method = RequestMethod.PUT)
    public void updateByIdProducto(@PathVariable("id") String id, @Valid @RequestBody Productos producto) {
        producto.setId(id);
        productosRepositorio.save(producto);
    }

    @RequestMapping(value = "/deleteProductoById/{id}", method = RequestMethod.DELETE)
    public void deleteProducto(@PathVariable("id") String id) {

        productosRepositorio.deleteById(id);
    }
}
