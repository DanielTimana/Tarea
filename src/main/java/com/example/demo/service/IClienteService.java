package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Cliente;

public interface IClienteService {
	
	List<Cliente> listadoClientes();
	Page<Cliente> listarPaginado(Pageable pageable);
	Cliente buscarPorId(Integer id);
	Cliente actualizarCliente(Cliente cliente);
	void registrarCliente(Cliente cliente);
	void eliminarCliente(Integer id);

}
