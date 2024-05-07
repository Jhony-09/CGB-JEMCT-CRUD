package edu.levelup.service;

import edu.levelup.domain.Componente;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;
import java.util.List;

public class ComponenteService implements Serializable {

    private final WebTarget webTarget;

    public ComponenteService() {
        Client client = ClientBuilder.newClient();
        webTarget = client.target("http://localhost:8081/componentes");
    }

    public List<Componente> getComponentes() {
        Response response = webTarget.path("/listar").request(MediaType.APPLICATION_JSON).get();
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

    public int borrarComponentes(Componente componente) {
        int valor = 0;
        try {
            WebTarget target = webTarget.path("/eliminar").queryParam("idComp", componente.getIdComp());
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .delete();

            if (response.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
               valor = 1;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return valor;
    }

    public int crearComponente(Componente componente) {
        int valor = 0;
        try {
            Response response = webTarget.path("/crear")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(componente));

            if (Response.Status.CREATED.getStatusCode() == response.getStatus()) {
               valor = 1;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return valor;
    }

    public int actualizarComponente(Componente componente) {
        int valor = 0;
        try {
            Response response = webTarget.path("/actualizar")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(componente));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                valor = 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return valor;
    }
}

