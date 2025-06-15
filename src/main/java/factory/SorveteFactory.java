package factory;

import model.Sorvete;
import model.tipoSorvete.Massa;
import model.tipoSorvete.Milkshake;
import model.tipoSorvete.Picole;

public class SorveteFactory {

    public static Sorvete criarSorvete(TipoSorvete tipo) {
        switch (tipo) {
            case MASSA:
                return new Massa();

            case PICOLE:
                return new Picole();

            case MILKSHAKE:
                return new Milkshake();

            default:
                throw new IllegalArgumentException("Tipo de sorvete inválido");
        }
    }

}
