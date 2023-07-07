package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String index(Model model,@RequestParam(required = false, defaultValue = "0") Integer page) {
		Page<Cliente> pg= clienteService.listarPaginado(PageRequest.of(page, 5));
		model.addAttribute("clientes", pg);
		model.addAttribute("paginacion", "/cliente/listar");
		return "cliente/index";
	}
	
	@GetMapping("/nuevo")
	public String registrarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/registrar";
	}
	
	@PostMapping("/guardar")
	public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.registrarCliente(cliente);
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		clienteService.eliminarCliente(id);
		System.out.println("Producto eliminado correctamente");
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return "cliente/editar";
	}
	
	@PostMapping("/actualizar/{id}")
	public String actualizarCliente(@PathVariable("id") Integer id, @ModelAttribute("cliente") Cliente cliente) {
		Cliente cliExistente = clienteService.buscarPorId(id);
		cliExistente.setId(id);
		cliExistente.setNombre(cliente.getNombre());
		cliExistente.setApellido(cliente.getApellido());
		cliExistente.setDireccion(cliente.getDireccion());
		cliExistente.setTelefono(cliente.getTelefono());
		cliExistente.setEmail(cliente.getEmail());
		
		clienteService.actualizarCliente(cliExistente);
		
		return "redirect:/cliente/listar";
	}
	
}
