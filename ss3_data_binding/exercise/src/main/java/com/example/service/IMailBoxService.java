package com.example.service;

import com.example.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    List<MailBox> showList();

    List<String> language();

    List<Integer> pageSizes();
    MailBox findById(int id);



    void update(MailBox mailBox);
}
