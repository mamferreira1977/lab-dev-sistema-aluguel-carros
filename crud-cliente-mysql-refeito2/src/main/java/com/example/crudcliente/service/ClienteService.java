package com.example.crudcliente.service;

import com.example.crudcliente.model.Cliente;
import com.example.crudcliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        validarCpfUnico(cliente);
        validarRgUnico(cliente);
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    private void validarCpfUnico(Cliente cliente) {
        clienteRepository.findByCpf(cliente.getCpf())
                .filter(existente -> !existente.getId().equals(cliente.getId()))
                .ifPresent(existente -> {
                    throw new IllegalArgumentException("Já existe cliente cadastrado com este CPF.");
                });
    }

    private void validarRgUnico(Cliente cliente) {
        clienteRepository.findByRg(cliente.getRg())
                .filter(existente -> !existente.getId().equals(cliente.getId()))
                .ifPresent(existente -> {
                    throw new IllegalArgumentException("Já existe cliente cadastrado com este RG.");
                });
    }
}
