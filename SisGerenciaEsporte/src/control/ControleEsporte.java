package control;
import model.Esporte;

public class ControleEsporte {

    private Esporte[] esportes;
    private int quantidade;
    private int proximoId;

    public ControleEsporte(int tamanho) {
        esportes = new Esporte[tamanho];
        quantidade = 0;
        proximoId = 1;
    }

    // CREATE
    public void cadastrar(String nome, String descricao) {

        if (quantidade >= esportes.length) {
            System.out.println("Não há espaço para cadastrar mais esportes.");
            return;
        }

        Esporte esporte = new Esporte(
            proximoId,
            nome,
            descricao
        );

        esportes[quantidade] = esporte;

        quantidade++;
        proximoId++;

        System.out.println("Esporte cadastrado com sucesso!");
    }

    // READ
    public Esporte consultar(int id) {

        for (int i = 0; i < quantidade; i++) {

            if (esportes[i].getId() == id) {
                return esportes[i];
            }
        }

        return null;
    }

    // UPDATE
    public boolean alterar(int id, String nome, String descricao) {

        Esporte esporte = consultar(id);

        if (esporte == null) {
            return false;
        }

        esporte.setNome(nome);
        esporte.setDescricao(descricao);

        return true;
    }

    // DELETE
    public boolean excluir(int id) {

        for (int i = 0; i < quantidade; i++) {

            if (esportes[i].getId() == id) {

                for (int j = i; j < quantidade - 1; j++) {
                    esportes[j] = esportes[j + 1];
                }

                esportes[quantidade - 1] = null;
                quantidade--;

                return true;
            }
        }

        return false;
    }

    // LIST
    public void listar() {

        if (quantidade == 0) {
            System.out.println("Nenhum esporte cadastrado.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            System.out.println(esportes[i]);
        }
    }
}