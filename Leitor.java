import java.util.Scanner;

public class Leitor {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int nroPacotes = Integer.parseInt(in.nextLine());
        Lista pacotes = new Lista(in, nroPacotes);

        pacotes.imprimeDescricaoPacotes();

        System.out.println(pacotes.existePacoteOrigemTipo(000, 888) ? "Existe pacote com brinquedos vindo da região Sul\n" : "Não existe pacote com brinquedos vindo da região Sul\n");

        pacotes.imprimePacotesPorDestino();

        pacotes.imprimeQtdePacotesVendedor();

        pacotes.geraRelatorioDestinoTipo();
    }
}
