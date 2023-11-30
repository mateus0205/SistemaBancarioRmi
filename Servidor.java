import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            ContaBancariaImpl conta = new ContaBancariaImpl(1);

            // Registra a instância no RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ContaBancaria1", conta);

            System.out.println("Servidor pronto para receber chamadas.");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}