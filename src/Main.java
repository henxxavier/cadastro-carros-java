import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarroDAO dao = new CarroDAO();

        Carro carro = dao.buscarPorPlaca("ABC-1234");

        if (carro != null) {
            dao.excluir(carro); // ✅ Aqui tudo certo!
        }
    }
}