package persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.*;
public class Serializadora {
    public void escribirArrayListPersonas(ArrayList<Persona> lista){
        try{
            FileOutputStream archivo = new FileOutputStream("personas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(lista);
        }  catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<Persona> leerArrayListPersonas(){
        try{
            FileInputStream archivo
                    = new FileInputStream("personas.dat");
            ObjectInputStream lector
                    = new ObjectInputStream(archivo);
            return (ArrayList<Persona>) lector.readObject();
        }  catch(IOException | ClassNotFoundException ex){
            return new ArrayList<>();
        }
    }
    public void escribirArrayListCasetas(ArrayList<Caseta> lista){
        try{
            FileOutputStream archivo = new FileOutputStream("casetas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(lista);
            escritor.close();
        }  catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<Caseta> leerArrayListCasetas(){
        try{
            FileInputStream archivo
                    = new FileInputStream("casetas.dat");
            ObjectInputStream lector
                    = new ObjectInputStream(archivo);
            return (ArrayList<Caseta>) lector.readObject();
        }  catch(IOException | ClassNotFoundException ex){
            return new ArrayList<>();
        }
    }

}