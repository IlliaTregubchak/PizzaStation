package station.pizza.dao;

import station.pizza.dto.clients.EditClientDTO;

public interface ClientDAO {

    long save(EditClientDTO editClientDTO);

    boolean exists(String phone);

    // викликається тільки із сервіса (ClientServiceImpl) методом-помічником
    long findIdByPhone(String phone);

    void delete(long id);
}
