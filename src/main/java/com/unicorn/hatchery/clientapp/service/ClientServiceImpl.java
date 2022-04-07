package com.unicorn.hatchery.clientapp.service;

import com.unicorn.hatchery.clientapp.domain.Client;
import com.unicorn.hatchery.clientapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientServiceImpl implements ClientService {

    //servisni vrstva bude delegovat praci databazi na uroven repository
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //tady bude vracet ClientRepository
    @Override
    public Client readClient(Long clientID) {
        //muze byt null, proto oprional, orElse, kdyz se nam nic nevrati a chceme vratit fake, orelseget to samy
        //orelsethrow, kdyz zadny zaznam pouzijeme vzjimku
        return clientRepository.findById(clientID).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientID) {
        clientRepository.deleteById(clientID);

    }

    //resit vujimky tady
    @Override
    public void updateClient(Long clientID, Client client) {
        Client clientFromDB = clientRepository.findById(clientID)
                .orElseThrow(IllegalArgumentException::new);
        clientFromDB.setName(client.getName());
        clientFromDB.setName(client.getEmail());
        clientRepository.save(clientFromDB);


    }

    @Override
    public List<Client> getClients() {
        return StreamSupport
                .stream(clientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
