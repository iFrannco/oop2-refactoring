package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonaRepository {

    private Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    /**
     * Busca por nombre a parte
     */
    public List<Persona> buscarPorNombre(String nombreOParte) {
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where nombre like ?")
                    .bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();

            var personas = new ArrayList<Persona>();

//            if (rs.isEmpty()) {
//                return personas;
//            }

            for (Map<String, String> map : rs) {
                personas.add(new Persona(map.get("nombre"), map.get("apellido")));
            }

            return personas;
        });

    }


    /**
     * Dado un id, retorna:
     * - null si el id no se encuentra en la BD
     * - la instancia de Persona encontrada
     */
    public Optional<Persona> buscarId(Long id) {
        return jdbi.withHandle(handle -> {

            var rs = handle
                    .select("select nombre, apellido from persona where id_persona = ?")
                    .bind(0, id).mapToMap(String.class).list();

            if (rs.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(new Persona(rs.get(0).get("nombre"), rs.get(0).get("apellido")));
            // return new Persona(rs.get(0).get("nombre"), rs.get(0).get("apellido"));

        });
    }

}
