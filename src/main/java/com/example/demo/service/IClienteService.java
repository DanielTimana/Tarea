package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Cliente;

public interface IClienteService {
	
	List<Cliente> listadoClientes();
	Cliente buscarPorId(Integer id);
	Cliente actualizarCliente(Cliente cliente);
	void registrarCliente(Cliente cliente);
	void eliminarCliente(Integer id);

}
