package com.mycompany.atividade02.model;

/**
 *
 * @author caina.teixeira
 */
public class Clientes {
    
    private String codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;
    
    public Clientes(){
        
    }
    public Clientes(String codigo, String nome, String dataNascimento,
            String cpf){
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Clientes{" + "codigo=" + codigo + ", nome=" + nome + 
                ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + '}';
    }
}
