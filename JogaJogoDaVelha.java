import java.util.Random;
import java.util.Scanner;

public class JogaJogoDaVelha {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao teste do Jogo da Velha!");
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite 1 para jogar ou 0 para sair: ");
        int opcao = scanner.nextInt();


        Random random = new Random();

        
        while (opcao!=0) {
            System.out.println("Digite um número inteiro para a dimensão do tabuleiro: ");
            int tamanho = scanner.nextInt();

            JogoDaVelha jogo = new JogoDaVelha(tamanho);
            int jogadas = 0;
            int totalJogadas = tamanho * tamanho;


            while (jogadas < totalJogadas && jogo.vencedor() == 2) {
                int i = random.nextInt(tamanho);
                int j = random.nextInt(tamanho);
                
                if (jogo.tabuleiro[i][j] == JogoDaVelha.VAZIO){
                    jogo.poePeca(i, j);
                    jogadas++;
                }
            }


            System.out.println("Tabuleiro:");     
            System.out.println(jogo); 

            int resultado = jogo.vencedor();
            if (resultado == JogoDaVelha.X) {
                System.out.println("Jogador X venceu!");
            } else if (resultado == JogoDaVelha.O) {
                System.out.println("Jogador O venceu!");
            } else {
                System.out.println("Empate!");
            }
            System.out.println("Deseja jogar novamente? (1-sim, 0-nao): ");
            opcao = scanner.nextInt();
        }

        scanner.close();
    }
}
