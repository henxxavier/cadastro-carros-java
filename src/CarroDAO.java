import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class CarroDAO {
    public void inserir(Carro carro) {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO Carros (marca, modelo, cor, placa) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getPlaca());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

            System.out.println("Carro adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Carro> listar() {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Carros";

        Connection conn = Conexao.conectar();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");
                String placa = rs.getString("placa");

                Carro carro = new Carro(id, marca, modelo, cor, placa);
                lista.add(carro);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Carro buscarPorPlaca(String placa) {

        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM Carros WHERE placa = ?";
        Carro carro = null;


        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");
                String placaBanco = rs.getString("placa");

                carro = new Carro(id, marca, modelo, cor, placaBanco);
            } else {
                return null;
            }

            rs.close();
            stmt.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carro;
    }

    public List<Carro> buscarPorMarca(String marca) {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Carros WHERE marca = ?";
        Connection conn = Conexao.conectar();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String marcaBanco = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");
                String placaBanco = rs.getString("placa");

                Carro carro = new Carro(id, marcaBanco, modelo, cor, placaBanco);
                lista.add(carro);
            }

            rs.close();
            stmt.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public List<Carro> buscarPorCor(String cor) {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Carros WHERE cor = ?";
        Connection conn = Conexao.conectar();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String corBanco = rs.getString("cor");
                String placaBanco = rs.getString("placa");

                Carro carro = new Carro(id, marca, modelo, corBanco, placaBanco);
                lista.add(carro);
            }

            rs.close();
            stmt.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public void atualizar(Carro carro) {
        String sql = "UPDATE Carros SET marca = ?, modelo = ?, cor = ?, placa = ? WHERE id = ?";
        Connection conn = Conexao.conectar();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getPlaca());
            stmt.setInt(5, carro.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Carro atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Carro carro) {
        String sql = "DELETE FROM Carros WHERE id = ?";
        Connection conn = Conexao.conectar();

        try {
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, carro.getId());
         stmt.executeUpdate();
         stmt.close();
         conn.close();

            System.out.println("Carro excluido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}