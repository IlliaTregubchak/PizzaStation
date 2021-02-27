package station.pizza.service;

import station.pizza.dto.clients.EditClientDTO;

public interface ClientService {

    long save(EditClientDTO editClientDTO);

    boolean exists(String phone);

    void delete(long id);
}
