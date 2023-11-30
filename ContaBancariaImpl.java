import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaBancariaImpl extends UnicastRemoteObject implements ContaBancaria {
    private int numeroConta;
    private double saldo;

    public ContaBancariaImpl(int numeroConta) throws RemoteException {
        super();
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    @Override
    public double consultarSaldo() throws RemoteException {
        return saldo;
    }

    @Override
    public void depositar(double valor) throws RemoteException {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
    }

    @Override
    public void sacar(double valor) throws RemoteException {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void transferir(int contaDestino, double valor) throws RemoteException {
        System.out.println("Transferência de " + valor + " realizada para a conta destino " + contaDestino + ".");
    }

    @Override
    public int getNumeroConta() throws RemoteException {
        return numeroConta;
    }
}
