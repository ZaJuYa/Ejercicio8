import Modelo.*;
import com.google.common.collect.ImmutableBiMap;
import org.junit.jupiter.api.Test;

import java.nio.IntBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PruebasUnitarias {

    @Test
    public void insertarInmbueble(){
        Inmueble i = new Inmueble("Vitoria","Za",5);
        String resultado = i.getLocalidad();
        assertEquals("Vitoria",resultado,"La localidad no es correcta");
    }


    @Test
    public void borrarInmbueble(){

    }

    @Test
    public void modificarInmbueble(){

    }

    @Test
    public void insertarUsuario(){
        Usuario u = new Usuario("Zahir","Zambrano","12345678A");
        String resultado = u.getNombre();
        assertEquals("Zahir",resultado,"El nombre no es el esperado");
    }

    @Test
    public void borrarUsuario(){

    }

    @Test
    public void modificarUsuario(){

    }
}
