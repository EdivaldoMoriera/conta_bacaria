import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Account acount;
        double initialDeposit;
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com o numero da conta");
        int number = ler.nextInt();
        System.out.println("Informe o  titular da conta");
        ler.nextLine();
        String holder = ler.nextLine();
        System.out.println("tem deposito inicial (s/n)?");
        char response = ler.next().charAt(0);
        if (response == 's') {
            System.out.println("Entre com o valor inicial");
            initialDeposit = ler.nextDouble();
            acount = new Account(number, holder, initialDeposit);

        } else  {
            acount = new Account(number, holder);
        }

        System.out.println("saldo da conta" + acount);

        System.out.println("entre  com o  valor do saque");
        double saque = ler.nextDouble();
        if (acount.getBalance() > 0) {
            acount.withdraw(saque);
            System.out.println(acount);
        } else  {
            System.out.println("Não há saldo suficiente quer ir para o cheque  especial (s/n)?");
            char res = ler.next().charAt(0);
            if (res == 's') {
                acount.withdraw(saque);
                System.out.println(acount);

            }
            else{
                System.out.println("saldo insuficiente");
            }

            ler.close();
        }

    }
}