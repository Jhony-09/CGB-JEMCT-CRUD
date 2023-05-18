package edu.levelup.service;

import edu.levelup.domain.Componente;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ComponenteService {

    private final WebTarget webTarget;

    public ComponenteService() {
        Client client = ClientBuilder.newClient();
        webTarget = client.target("http://localhost:8081/componentes");
    }

    public List<Componente> getComponentes() {
        Response response = webTarget
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.readEntity(new GenericType<List<Componente>>() {});
        } else {
            throw new RuntimeException("Error al obtener componentes");
        }
    }

    public Componente getComponenteById(int id) {
        WebTarget target = webTarget.path(String.valueOf(id));
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.readEntity(Componente.class);
        } else {
            throw new RuntimeException("Error al obtener componente con ID: " + id);
        }
    }

    public void borrarComponentes(List<Integer> ids) {
        String idParam = ids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        WebTarget target = webTarget.queryParam("ids", idParam);
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .delete();

        if (response.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
            System.out.println("Componentes eliminados con éxito");
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Error al borrar los componentes: " + errorMessage);
        }
    }

    public void crearComponente(Componente componente) {
        if (componente.getNombreComp().isEmpty() || componente.getDescripcionComp().isEmpty()) {
            throw new RuntimeException("Ingrese el nombre y la descripción del componente");
        }

        if (componente.getPrecioComp().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Ingrese un precio válido");
        }

        Response response = webTarget
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(componente));

        if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            System.out.println("Componente creado con éxito");
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Error al crear el componente: " + errorMessage);
        }
    }

    public void actualizarComponente(Componente componente) {
        if (componente.getIdComp() == 0) {
            throw new RuntimeException("El componente no existe");
        }

        Response response = webTarget.path(String.valueOf(componente.getIdComp()))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(componente));

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Componente actualizado con éxito");
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Error al actualizar el componente: " + errorMessage);
        }
    }
}

