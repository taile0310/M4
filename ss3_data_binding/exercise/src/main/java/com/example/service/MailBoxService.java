package com.example.service;

import com.example.model.MailBox;
import com.example.repository.IMailBoxRepository;
import com.example.repository.MailBoxRepository;


import java.util.List;

public class MailBoxService implements IMailBoxService {

    private IMailBoxRepository mailBoxRepository = new MailBoxRepository();

    @Override
    public List<MailBox> showList() {
        return mailBoxRepository.showList();
    }

    @Override
    public List<String> language() {
        return mailBoxRepository.language();
    }

    @Override
    public List<Integer> pageSizes() {
        return mailBoxRepository.pageSizes();
    }

    @Override
    public MailBox findById(int id) {
        return mailBoxRepository.findById(id);
    }

    @Override
    public void update(MailBox mailBox) {
        mailBoxRepository.update(mailBox);
    }
}
