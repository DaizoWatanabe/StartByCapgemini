package LE1_1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
    }
}

//Exerc�cio 1
/*
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um n�mero");
        int firstInput = leitor.nextInt();

        System.out.println("Digite outro n�mero");
        int secondInput = leitor.nextInt();

        int soma = firstInput + secondInput;

        System.out.println("O total da soma entre os números é " + soma);
 */
//Exerc�cio 2
/* 
 Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um número");
        int num1 = leitor.nextInt();
        System.out.println("Digite outro número");
        int num2 = leitor.nextInt();

        int soma = num1 + num2;
        int sub = num1 - num2;
        float div = num1 / num2;
        int mult = num1 * num2;

        System.out.println("A soma entre os números é " + soma);
        System.out.println("A subtração entre os números é " + sub);
        System.out.println("A divisão entre os números é " + div);
        System.out.println("A multiplicação entre os números é " + mult);
 */
//Exerc�cio 24
/*
        Scanner leitor = new Scanner(System.in);

        boolean cond = true;
        while (cond == true) {
            System.out.println("Digite um número");
            int num = leitor.nextInt();
            if (num > 0) {
                System.out.println("Número positivo");
            } else if (num < 0) {
                System.out.println("Número Negativo");
            } else {
                System.out.println("O número digitado foi 0");
            }

            System.out.println("Digite 1 para sair ou 2 para continuar");
            int res = leitor.nextInt();
            cond = res != 1;
        }
 */
//Exerc�cio 22
/* 
        int mpc = 0;
        int mpv = 0;
        Scanner leitor = new Scanner(System.in);

        int i = 0;
        for (; i < 40; i++) {

            System.out.println("Digite o custo do produto");
            int pc = leitor.nextInt();
            System.out.println("Digite o preço de venda do produto");
            int pv = leitor.nextInt();
            if (pv == pc) {
                System.out.println("Empate");
            } else {
                if (pv > pc) {
                    int lucro = pv - pc;
                    System.out.println("Você obteve um lucro de " + lucro);
                } else {
                    int prejuizo = pc - pv;
                    System.out.println("Você teve prejuízo no produto. Prejuízo total: " + prejuizo);
                }
            }
            mpc = mpc + pc;
            mpv = mpv + pv;
        }
        System.out.println("A média do preço de custo dos seus produtos foi de " + mpc / i);
        System.out.println("A média do preço de venda dos seus produtos foi de " + mpv / i);
 */
