import daos.persona.PersonaDaoImp;
import dto.Tablas.PersonaDto;
import grafica.Ventana;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
       // Connection conn = Conexion.getConexion();
        PersonaDaoImp per = new PersonaDaoImp();
      //  per.registrarPersona("2222121sc","andres2","carlsen","andis","77098552","andres2@hotmail.com");
       /*
  for (int i = 0; i <array.size() ; i++) {
            System.out.println(array.get(i).getCi());
            System.out.println(array.get(i).getNombre());
            System.out.println(array.get(i).getApellidoPaterno());
            System.out.println(array.get(i).getApellidoMaterno());
            System.out.println(array.get(i).getTelefono());
            System.out.println(array.get(i).getCorreo());
        }

        */
        ArrayList<PersonaDto>  array = per.getAll();

    }


}
