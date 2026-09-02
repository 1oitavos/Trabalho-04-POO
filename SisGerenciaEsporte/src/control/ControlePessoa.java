package control;
import model.Pessoa;

public class ControlePessoa {

    private Pessoa[] pessoas;
    private int quantidade;
    private int proximoId;

    public ControlePessoa(int tamanho) {
        pessoas = new Pessoa[tamanho];
        quantidade = 0;
        proximoId = 1;
    }

    // CREATE
    public void cadastrar(String nome, String cpf, String email, String telefone) {

        if (quantidade >= pessoas.length) {
            System.out.println("Não há espaço para cadastrar mais pessoas.");
            return;
        }

        Pessoa pessoa = new Pessoa(
            proximoId,
            nome,
            cpf,
            email,
            telefone
        );

        pessoas[quantidade] = pessoa;

        quantidade++;
        proximoId++;

        System.out.println("Pessoa cadastrada com sucesso!");
    }

    // READ
    public Pessoa consultar(int id) {

        for (int i = 0; i < quantidade; i++) {

            if (pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }

        return null;
    }

    // UPDATE
    public boolean alterar(int id, String nome, String cpf,
                           String email, String telefone) {

        Pessoa pessoa = consultar(id);

        if (pessoa == null) {
            return false;
        }

        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setEmail(email);
        pessoa.setTelefone(telefone);

        return true;
    }

    // DELETE
    public boolean excluir(int id) {

        for (int i = 0; i < quantidade; i++) {

            if (pessoas[i].getId() == id) {

                for (int j = i; j < quantidade - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }

                pessoas[quantidade - 1] = null;
                quantidade--;

                return true;
            }
        }

        return false;
    }

    // LIST
    public void listar() {

        if (quantidade == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            System.out.println(pessoas[i]);
        }
    }
}