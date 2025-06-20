package factory;

import model.Sorvete;

public class SorveteFactory {
    public static Sorvete criarSorvete(String tipo) {
        switch (tipo.toLowerCase()) {
            case "massa":
                return new model.Massa();
            case "picole":
                return new model.Picole();
            case "milkshake":
                return new model.Milkshake();
            default:
                throw new IllegalArgumentException("Tipo inválido");
        }
    }
}