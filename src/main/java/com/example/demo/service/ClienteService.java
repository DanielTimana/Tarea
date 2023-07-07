package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IClienteDao;
import com.example.demo.model.Cliente;

@Service
public class ClienteService implements IClienteService{

	
	@Autowired private IClienteDao clienteDao;
	
	@Override
	public List<Cliente> listadoClientes() {
		return clienteDao.findAll();
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public void registrarCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		clienteDao.deleteById(id);
	}

	@Override
	public Page<Cliente> listarPaginado(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}
}