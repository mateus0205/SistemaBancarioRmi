import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ContaBancaria contaRemota = (ContaBancaria) registry.lookup("ContaBancaria1");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Sacar");
                System.out.println("4. Transferir");
                System.out.println("5. Sair");

                int escolha = scanner.nextInt();
                double valor;

                switch (escolha) {
                    case 1:
                        System.out.println("Saldo atual: " + contaRemota.consultarSaldo());
                        break;
                    case 2:
                        System.out.println("Digite o valor para depositar:");
                        valor = scanner.nextDouble();
                        contaRemota.depositar(valor);
                        break;
                    case 3:
                        System.out.println("Digite o valor para sacar:");
                        valor = scanner.nextDouble();
                        contaRemota.sacar(valor);
                        break;
                    case 4:
                    System.out.println("Digite o valor para transferir:");
                    valor = scanner.nextDouble();

                    try {
                        System.out.println("Contas disponíveis:");
                        for (int i = 1; i <= 3; i++) {
                            System.out.println(i + ". Conta " + i);
                        }

                        System.out.println("Digite o número da conta de destino:");
                        int contaDestino = scanner.nextInt();
                        ContaBancaria contaDestinoRemota = (ContaBancaria) registry.lookup("ContaBancaria" + contaDestino);
                        contaRemota.transferir(contaDestinoRemota.getNumeroConta(), valor);
                    } catch (Exception ex) {
                        System.out.println("Erro ao obter referência à conta de destino: " + ex.getMessage());
                    }
                    break;
                    case 5:
                        System.out.println("Saindo do programa.");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
