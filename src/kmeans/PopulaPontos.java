
package kmeans;

import java.util.ArrayList;
import java.util.List;

public class PopulaPontos {
    
    public List<Ponto> popula(){
        List<Ponto> lista = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            lista.add(new Ponto(0 + (double) (Math.random() * ((100 - 0) + 1)), 0 + (double) (Math.random() * ((100 - 0) + 1))));
        }
        
        return lista;
    }
}
