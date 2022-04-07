package com.unicorn.hatchery.clientapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicorn.hatchery.clientapp.domain.Client;
import com.unicorn.hatchery.clientapp.service.ClientService;
import com.unicorn.hatchery.clientapp.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * restcontroller aby se response tvaril jako JSON, proto namisto kontrolleru
 * vse za lomitkem clients poujde do controlleru
 *
 * */
//kontrolem kominukace s postmanem, klientem, web psany v angularu, oddeluje zbytek app od toho, jakym zpusobem premapovat HTTP data na to kokretni metody s konkretnimi parametrz
@RestController
@RequestMapping("/clients")
public class ClientController {

    //provazani se servisou

    private ClientService clientService;

//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired // autowired tady a ne u property kvuli testovani
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
//        this.objectMapper = objectMapper;
    }

    //@RequestMapping(method = RequestMethod.POST, path = "/")
    //obsah http pozadavku se ma namapovat na tridu klient prost request body
    //zrusim lomitko
    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    //pres ID se zeptam na konkretniho klienta
    //nevi, 6e parametr id ma pouyit jaklo clientID, muisime mu to rict
    @GetMapping("/{id}")
    public Client readClient(@PathVariable("id") Long clientID){
        //provazani se servisoui, co se ma vracet
        return clientService.readClient(clientID);

    }

    //updaty by mely vracet stav 202, proto void, u update ma byt put
    //musime vedet jakoho konk klienta updatopvat
    //potrebujeme vedet jakym zpusobem, to je to request body
    @PutMapping("/{id}")
    public void updateClient(@PathVariable("id") Long clientID,
                             @RequestBody Client client){
        clientService.updateClient(clientID, client);

    }

    //smazani klienta, k tomu by melo stacit id
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long clientID) {
        clientService.deleteClient(clientID);

    }

    //po zruseni lomitka naimplementuju metodu
    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }


}
