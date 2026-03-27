package com.example.crudcliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O RG é obrigatório.")
    @Size(max = 20, message = "O RG deve ter no máximo 20 caracteres.")
    @Column(nullable = false, unique = true, length = 20)
    private String rg;

    @NotBlank(message = "O CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "Informe o CPF com 11 dígitos, sem pontos e traços.")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 120, message = "O nome deve ter no máximo 120 caracteres.")
    @Column(nullable = false, length = 120)
    private String nome;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String endereco;

    @NotBlank(message = "A profissão é obrigatória.")
    @Size(max = 100, message = "A profissão deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String profissao;

    @NotBlank(message = "A entidade empregadora é obrigatória.")
    @Size(max = 150, message = "A entidade empregadora deve ter no máximo 150 caracteres.")
    @Column(nullable = false, length = 150)
    private String entidadeEmpregadora;

    @NotNull(message = "O rendimento é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O rendimento deve ser maior que zero.")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal rendimentos;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEntidadeEmpregadora() {
        return entidadeEmpregadora;
    }

    public void setEntidadeEmpregadora(String entidadeEmpregadora) {
        this.entidadeEmpregadora = entidadeEmpregadora;
    }

    public BigDecimal getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(BigDecimal rendimentos) {
        this.rendimentos = rendimentos;
    }
}
