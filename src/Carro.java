public class Carro {

    private int id;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;

    public Carro (int id, String marca, String modelo, String cor, String placa) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    public int getId() {return id;}
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getCor() {
        return cor;
    }
    public String getPlaca() {
        return placa;
    }

    public void setId (int id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String toString() {
        return "ID: " + id + " | Marca: " + marca + " | Modelo: " + modelo + " | Cor: " + cor + " | Placa: " + placa;
    }



}



