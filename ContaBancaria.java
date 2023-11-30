import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContaBancaria extends Remote {
    double consultarSaldo() throws RemoteException;
    void depositar(double valor) throws RemoteException;
    void sacar(double valor) throws RemoteException;
    void transferir(int contaDestino, double valor) throws RemoteException;
    int getNumeroConta() throws RemoteException;
}
