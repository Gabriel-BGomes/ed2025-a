public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int[][] tabuleiro;
    protected int jogador;
    protected int tamanho;

    public JogoDaVelha(int tamanho) {
        this.tamanho = tamanho;
        tabuleiro = new int [tamanho][tamanho];
        limpaTabuleiro();
    }

    public void limpaTabuleiro() {
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < tamanho; j++)
                tabuleiro[i][j] = VAZIO;

        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i >= tamanho || j < 0 || j >= tamanho)
            throw new IllegalArgumentException("Posição Inválida");
        if (tabuleiro[i][j] != VAZIO)
            throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j] = jogador;
        jogador = -jogador;
    }

    public boolean eVencedor(int marca) {
        //linhas
        for (int i = 0; i < tamanho; i++) {
            int cont = 0;
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == marca) cont++;
            }
            if (cont == tamanho) return true;
        }

        //colunas
        for (int j = 0; j < tamanho; j++) {
            int cont = 0;
            for (int i = 0; i < tamanho; i++) {
                if (tabuleiro[i][j] == marca) cont++;
            }
            if (cont == tamanho) return true;
        }

        // Diagonal1
        int diagonal1 = 0;
        for (int i = 0; i < tamanho; i++) {
            if (tabuleiro[i][i] == marca) diagonal1++;
        }
        if (diagonal1 == tamanho) return true;

        // Diagonal2
        int diagonal2 = 0;
        for (int i = 0; i < tamanho; i++) {
            if (tabuleiro[i][tamanho - 1 - i] == marca) diagonal2++;
        }
        if (diagonal2 == tamanho) return true;

        return false;
    }

    public int vencedor() {
        if (eVencedor(X)) return X;
        if (eVencedor(O)) return O;
        return 2; 
    }

    public String toString() {
        String retorno = "";
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == X) {
                    retorno += " X ";
                } else if (tabuleiro[i][j] == O) {
                    retorno += " O ";
                } else {
                    retorno += "   ";
                }
                if (j < tamanho - 1) retorno += "|";
            }
            retorno += "\n";
            if (i < tamanho - 1) {
                for (int k = 0; k < tamanho; k++) {
                    retorno += "---";
                    if (k < tamanho - 1) retorno += "+";
                }
                retorno += "\n";
            }
        }
        return retorno;
    }
}