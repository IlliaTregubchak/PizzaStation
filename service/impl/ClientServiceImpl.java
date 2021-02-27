package station.pizza.service.impl;

import station.pizza.dao.ClientDAO;
import station.pizza.dao.OrderDAO;
import station.pizza.dao.impl.ClientDAOImpl;
import station.pizza.dao.impl.OrderDAOImpl;
import station.pizza.dto.clients.EditClientDTO;
import station.pizza.service.ClientService;

public class ClientServiceImpl implements ClientService {

    @Override
    public long save(EditClientDTO editClientDTO) {
        if (editClientDTO == null) {
            throw new NullPointerException("Client is NULL");
        }
        final boolean exists = exists(editClientDTO.getPhone());
        if (exists) {
            return findIdByPhone(editClientDTO.getPhone());
        } else {
            final ClientDAO clientDAO = new ClientDAOImpl();
            return clientDAO.save(editClientDTO);
        }
    }

    @Override
    public boolean exists(String phone) {
        final ClientDAO clientDAO = new ClientDAOImpl();
        return clientDAO.exists(phone);
    }

    @Override
    public void delete(long id) {
        final OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.deleteByClientId(id);
        final ClientDAO clientDAO = new ClientDAOImpl();
        clientDAO.delete(id);
    }

    // приватний метод-помічник
    private long findIdByPhone(String phone) {
        final ClientDAO clientDAO = new ClientDAOImpl();
        return clientDAO.findIdByPhone(phone);
    }
}
