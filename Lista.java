import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lista {
    private List<Codebar> pacotes;

    public Lista(Scanner in, int nroPacotes) {
        pacotes = new LinkedList<Codebar>();
        for (int i = 0; i < nroPacotes; i++) {
            pacotes.add(new Codebar(i+1, in.nextLine()));
        }
    }

    public void imprimeDescricaoPacotes() {
        System.out.println("--DESCRICAO DOS PACOTES--\n");

        for (Codebar pacote : pacotes) {
            System.out.println("Pacote " + pacote.getPacote());
            System.out.println("Destino: " + pacote.getDestino());
            System.out.println((pacote.ehValido() ? "Codigo valido" : "Codigo invalido"));
            System.out.println();
        }
    }

    public void imprimePacotesPorDestino() {
        HashMap<String, LinkedList<Integer>> pacotesPorDestino = new HashMap<String, LinkedList<Integer>>();

        for (Codebar pacote : pacotes) {
            if (!(pacote.ehValido())) continue;
            String destino = pacote.getDestino();
            if (!(pacotesPorDestino.containsKey(destino))) {
                pacotesPorDestino.put(destino, new LinkedList<Integer>());
            }
            pacotesPorDestino.get(destino).add(pacote.getPacote());
        }

        String[] regioes = {"Norte", "Nordeste", "Centro-oeste", "Sudeste", "Sul"};
        System.out.println("--PACOTES POR REGIAO DE DESTINO--\n");

        for (String regiao : regioes) {
            if (pacotesPorDestino.containsKey(regiao)) {
                System.out.println("Regiao " + regiao);
                Iterator<Integer> itPacotesDestino = pacotesPorDestino.get(regiao).iterator();
                while (itPacotesDestino.hasNext()) {
                    System.out.print(itPacotesDestino.next() + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public void imprimeQtdePacotesVendedor() {
        HashMap<Integer, Integer> pacotesPorVendedor = new HashMap<Integer, Integer>();

        for (Codebar pacote : pacotes) {
            if (pacote.ehValido()) {
                int codigoVendedor = pacote.getCodigoVendedor();
                if (!(pacotesPorVendedor.containsKey(codigoVendedor))) {
                    pacotesPorVendedor.put(codigoVendedor, 1);
                } else {
                    pacotesPorVendedor.put(codigoVendedor, pacotesPorVendedor.get(codigoVendedor) + 1);
                }
            }
        }

        System.out.println("\n--NÚMERO DE PACOTES POR VENDEDOR--\n");

        for (Integer vendedor : pacotesPorVendedor.keySet()) {
            System.out.println("Vendedor " + vendedor + ": " + pacotesPorVendedor.get(vendedor) + " pacote(s)");
        }
        System.out.println();
    }

    public boolean existePacoteOrigemTipo(int origem, int tipo) {
        for (Codebar pacote : pacotes) {
            if (!(pacote.ehValido())) continue;
            if (pacote.getCodigoOrigem() == origem && pacote.getCodigoTipo() == tipo) return true;
        }
        return false;
    }

    public void geraRelatorioDestinoTipo() {
        HashMap<String, HashMap<String, LinkedList<Integer>>> pacotesDestinoTipo = new HashMap<String, HashMap<String, LinkedList<Integer>>>();

        for (Codebar pacote : pacotes) {
            if (pacote.ehValido()) {
                String destino = pacote.getDestino();
                if (!(pacotesDestinoTipo.containsKey(destino))) {
                    pacotesDestinoTipo.put(destino, new HashMap<String, LinkedList<Integer>>());
                }
                HashMap<String, LinkedList<Integer>> mapDestino = pacotesDestinoTipo.get(destino);
                String tipo = pacote.getTipo();
                if (!(mapDestino.containsKey(tipo))) {
                    mapDestino.put(tipo, new LinkedList<Integer>());
                }
                mapDestino.get(tipo).add(pacote.getPacote());
            }
        }

        System.out.println("--RELATÓRIO (PACOTES POR DESTINO E TIPO)--\n");

        for (String destino : pacotesDestinoTipo.keySet()) {
            System.out.println("  --Região " + destino + "--");
            HashMap<String, LinkedList<Integer>> pacotesTipo = pacotesDestinoTipo.get(destino);
            for (String tipo : pacotesTipo.keySet()) {
                System.out.println("    --" + tipo + "--");
                LinkedList<Integer> pacotes = pacotesTipo.get(tipo);
                System.out.print("        ");
                for (Integer pacote : pacotes) {
                    System.out.print(pacote + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
