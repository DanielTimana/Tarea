package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer>{

}
