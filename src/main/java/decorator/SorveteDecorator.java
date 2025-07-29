package decorator;

import model.Sorvete;

public abstract class SorveteDecorator extends Sorvete {
    protected Sorvete sorvete;

    public SorveteDecorator(Sorvete sorvete) {
        this.sorvete = sorvete;
    }
}

//Por que herda Sorvete:
//Isso permite que um decorator possa ser tratado como um Sorvete, mantendo a interface comum
// (muito útil para polimorfismo).