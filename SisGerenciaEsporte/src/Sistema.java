import control.ControleEsporte;
import control.ControlePessoa;
import model.Esporte;
import model.Pessoa;

public class Sistema {

    public static void main(String[] args) {

        ControlePessoa controlePessoa = new ControlePessoa(10);
        ControleEsporte controleEsporte = new ControleEsporte(10);


        // ==========================
        // PESSOAS
        // ==========================

        System.out.println("=== CADASTRO DE PESSOAS ===");

        controlePessoa.cadastrar(
            "João",
            "111.111.111-11",
            "joao@email.com",
            "99999-1111"
        );

        controlePessoa.cadastrar(
            "Maria",
            "222.222.222-22",
            "maria@email.com",
            "99999-2222"
        );


        System.out.println("\n=== LISTA DE PESSOAS ===");

        controlePessoa.listar();


        System.out.println("\n=== CONSULTA ===");

        Pessoa pessoa = controlePessoa.consultar(1);

        if (pessoa != null) {
            System.out.println(pessoa);
        }


        System.out.println("\n=== ALTERAÇÃO ===");

        controlePessoa.alterar(
            1,
            "João Silva",
            "111.111.111-11",
            "joao.silva@email.com",
            "98888-1111"
        );

        controlePessoa.listar();


        System.out.println("\n=== EXCLUSÃO ===");

        controlePessoa.excluir(2);

        controlePessoa.listar();


        // ==========================
        // ESPORTES
        // ==========================

        System.out.println("\n\n=== CADASTRO DE ESPORTES ===");

        controleEsporte.cadastrar(
            "Voleibol",
            "Esporte coletivo praticado com uma bola e uma rede."
        );

        controleEsporte.cadastrar(
            "Futebol",
            "Esporte coletivo praticado com uma bola nos pés."
        );

        controleEsporte.cadastrar(
            "Basquete",
            "Esporte coletivo praticado com uma bola e uma cesta."
        );


        System.out.println("\n=== LISTA DE ESPORTES ===");

        controleEsporte.listar();


        System.out.println("\n=== CONSULTA ===");

        Esporte esporte = controleEsporte.consultar(1);

        if (esporte != null) {
            System.out.println(esporte);
        }


        System.out.println("\n=== ALTERAÇÃO ===");

        controleEsporte.alterar(
            1,
            "Voleibol",
            "Esporte coletivo praticado com seis jogadores em cada equipe."
        );

        controleEsporte.listar();


        System.out.println("\n=== EXCLUSÃO ===");

        controleEsporte.excluir(2);

        controleEsporte.listar();
    }
}