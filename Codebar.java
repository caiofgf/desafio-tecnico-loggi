public class Codebar {
    private int nroPacote;
    private long codebar;
    private int trincaOrigem;
    private int trincaDestino;
    private int trincaLoggi;
    private int trincaVendedor;
    private int trincaProduto;

    /*public Codebar (long codebar) {
        this.codebar = codebar;
        long trincaOrigem = codebar % 1000000000000;
        this.trincaOrigem = (int) trincaOrigem;
        codebar -= trincaOrigem * 1000000000000;
        this.trincaDestino = (int) (codebar % 1000000000);
        codebar -= trincaDestino * 1000000000;
        this.trincaLoggi = (int) (codebar % 1000000);
        codebar -= trincaLoggi * 1000000;
        this.trincaVendedor = (int) (codebar % 1000);
        codebar -= trincaVendedor * 1000;
        this.trincaProduto = (int) (codebar); 
    }*/

    public Codebar (int pacote, String codebar) {
        this.nroPacote = pacote;
        this.codebar = Long.parseLong(codebar);
        if (codebar.length() != 15) return;
        char[] codebarArray = codebar.toCharArray();
        String trincaOrigem = Character.toString(codebarArray[0]) + Character.toString(codebarArray[1]) + Character.toString(codebarArray[2]);
        this.trincaOrigem = Integer.parseInt(trincaOrigem);
        String trincaDestino = Character.toString(codebarArray[3]) + Character.toString(codebarArray[4]) + Character.toString(codebarArray[5]);
        this.trincaDestino = Integer.parseInt(trincaDestino);
        String trincaLoggi = Character.toString(codebarArray[6]) + Character.toString(codebarArray[7]) + Character.toString(codebarArray[8]);
        this.trincaLoggi = Integer.parseInt(trincaLoggi);
        String trincaVendedor = Character.toString(codebarArray[9]) + Character.toString(codebarArray[10]) + Character.toString(codebarArray[11]);
        this.trincaVendedor = Integer.parseInt(trincaVendedor);
        String trincaProduto = Character.toString(codebarArray[12]) + Character.toString(codebarArray[13]) + Character.toString(codebarArray[14]);
        this.trincaProduto = Integer.parseInt(trincaProduto);
    }

    public String getDestino() {
        switch (trincaDestino) {
            case 111:
                return "Centro-oeste";
            case 333:
                return "Nordeste";
            case 555:
                return "Norte";
            case 888:
                return "Sudeste";
            case 000:
                return "Sul";
        }
        return "Destino inválido";
    }

    public int getCodigoOrigem() {
        return this.trincaOrigem;
    }

    public boolean ehValido() {
        switch (trincaVendedor) {
            case 584:
                return false;
        }
        switch (trincaProduto) {
            case 000:
            case 111:
            case 333:
            case 555:
            case 888:
                break;
            default:
                return false;
        }
        if (trincaOrigem == 111 && trincaProduto == 000) return false;
        return true;
    }

    public int getPacote() {
        return this.nroPacote;
    }

    public int getCodigoVendedor() {
        return this.trincaVendedor;
    }

    public String getTipo() {
        switch (trincaProduto) {
            case 000:
                return "Joias";
            case 111:
                return "Livros";
            case 333:
                return "Eletronicos";
            case 555:
                return "Bebidas";
            case 888:
                return "Brinquedos";
        }
        return "Tipo invalido";
    }

    public int getCodigoTipo() {
        return this.trincaProduto;
    }
}