package co.edu.uniquindio.poo;

import java.util.Collection;

public class Drogueria {
    private String nombreDrogueria;
    private Collection<Producto> listaProductos;
    private Collection<Pedido> listaPedidos;
    private Collection<Cliente> listaClientes;
    private Collection<Empleado> listaEmpleados;
    public Drogueria(String nombreDrogueria, Collection<Producto> listaProductos, Collection<Pedido> listaPedidos,
            Collection<Cliente> listaClientes, Collection<Empleado> listaEmpleados) {
        this.nombreDrogueria = nombreDrogueria;
        this.listaProductos = listaProductos;
        this.listaPedidos = listaPedidos;
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
    }
    public String getNombreDrogueria() {
        return nombreDrogueria;
    }
    public void setNombreDrogueria(String nombreDrogueria) {
        this.nombreDrogueria = nombreDrogueria;
    }
    public Collection<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(Collection<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    public Collection<Pedido> getListaPedidos() {
        return listaPedidos;
    }
    public void setListaPedidos(Collection<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public Collection<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(Collection<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
}



   
