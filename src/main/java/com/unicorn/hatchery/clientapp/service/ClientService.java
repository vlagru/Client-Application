package com.unicorn.hatchery.clientapp.service;

import com.unicorn.hatchery.clientapp.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

//controller pracujee s htttp poz, repositorz pracuje s databayzi
//servisa specificka pro praci s
//diky tomu ze trida dostane Komponent, ulozena do kontextu, DI

//servisni vrstva lepidlo, z kontrolleru prijdou data, se kterzmi umi pracovat, vi o repozitory, provadi business logiku
//kontrol nikdy nebude koukat na repozitorzy, ale na servise, na te servisni vrstve ta business  a spojuje
@Service
public interface ClientService {


    Client readClient(Long clientID);

    Client createClient(Client client);

    void deleteClient(Long clientID);

    void updateClient(Long clientID, Client client);

    List<Client> getClients();
}
