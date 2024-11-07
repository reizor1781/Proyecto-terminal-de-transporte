package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class AdminTerminal extends Persona implements Serializable {
    private String lugarOrigen;
    private String estadoCivil;
    public AdminTerminal() {
    }
    public AdminTerminal(int cedula, String nombre, char genero, String celular, LocalDate fechaNacimiento, String contraseña, String lugarOrigen, String estadoCivil) {
        super(cedula, nombre, genero, celular, fechaNacimiento, contraseña);
        this.lugarOrigen = lugarOrigen;
        this.estadoCivil = estadoCivil;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "AdminTerminal{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", celular='" + celular + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", contraseña='" + contraseña + '\'' +
                ", lugarOrigen='" + lugarOrigen + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
}
