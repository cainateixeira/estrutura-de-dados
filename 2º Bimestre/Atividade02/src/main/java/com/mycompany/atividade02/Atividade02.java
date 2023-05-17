package com.mycompany.atividade02;

import com.mycompany.atividade02.model.Clientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author caina.teixeira
 */
public class Atividade02 {

    public static void main(String[] args) {
        
        ArrayList<Clientes> clientes = new ArrayList<>();
        
        int opcao;
        do{
            opcao = exibirMenu();
            
            switch(opcao){
                case 0:
                    cadastrarCliente(clientes);
                    break;
                case 1:
                    exibirClientesOrdenados(clientes);
                    break;
                case 2:
                    pesquisarCliente(clientes);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, 
                            "Aplicativo encerrado.");
                    return; //retorna imediatamente para sair do metodo main
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção Invalida!");
            }
        } while (true); //loop infinito
    }
    public static int exibirMenu() {
        String[] opcoes = {"Cadastrar Cliente", "Exibir Clientes Ordenados",
            "Pesquisar Cliente", "Sair"};
        return JOptionPane.showOptionDialog(null, 
                "Selecione uma opção:", "Cadastro de Clientes",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, null,
                opcoes, opcoes[0]);
    }
    
    public static void cadastrarCliente(ArrayList<Clientes> clientes) {
        String codigo = JOptionPane.showInputDialog(
                "Informe o código do cliente:");
        String nome = JOptionPane.showInputDialog(
                "Informe o nome do cliente:");
        String dataNascimento = JOptionPane.showInputDialog(
                "Informe a data de nascimento do cliente:");
        String cpf = JOptionPane.showInputDialog(
                "Informe o CPF do cliente:");

        Clientes cliente = new Clientes(codigo, nome, dataNascimento, cpf);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, 
                "Cliente cadastrado com sucesso!");
    }
    
    public static void exibirClientesOrdenados(ArrayList<Clientes> clientes) {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Não há clientes cadastrados.");
            return;
        }
         
        // Ordenar os clientes pelo código usando ordenação por inserção
        for (int i = 1; i < clientes.size(); i++) {
            Clientes clienteAtual = clientes.get(i);
            int j = i - 1;
            while (j >= 0 && clientes.get(j).getCodigo().compareTo(clienteAtual.getCodigo()) > 0) {
                clientes.set(j + 1, clientes.get(j));
                j--;
            }
            clientes.set(j + 1, clienteAtual);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Clientes cadastrados (ordenados por código):\n");

        for (Clientes cliente : clientes) {
            sb.append(cliente.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void pesquisarCliente(ArrayList<Clientes> clientes) {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Não há clientes cadastrados.");
            return;
        }

        String codigoPesquisa = JOptionPane.showInputDialog(
                "Informe o código do cliente:");

        Clientes clientePesquisado = pesquisarClienteBinaria(clientes,
                codigoPesquisa);

        if (clientePesquisado != null) {
            JOptionPane.showMessageDialog(null, 
                    "Cliente encontrado:\n" + clientePesquisado.toString());
        } else {
            JOptionPane.showMessageDialog(null, 
                    "Cliente não encontrado.");
        }
    }
    
    public static Clientes pesquisarClienteBinaria(ArrayList<Clientes> clientes,
            String codigo) {
        int inicio = 0;
        int fim = clientes.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            Clientes clienteMeio = clientes.get(meio);

            int comparacao = clienteMeio.getCodigo().compareTo(codigo);

            if (comparacao == 0) {
                return clienteMeio;
            }

            if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return null;
    }
}

