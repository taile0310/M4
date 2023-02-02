package com.example.repository;

import com.example.model.MailBox;

import java.util.ArrayList;
import java.util.List;

public class MailBoxRepository implements IMailBoxRepository {
    private static List<MailBox> mailBoxList = new ArrayList<>();
    static {
        mailBoxList.add(new MailBox(1,"Vietnamese", 5,true,"Hà Nội, HCM"));
        mailBoxList.add(new MailBox(2,"English", 5,false,"King, London"));
        mailBoxList.add(new MailBox(3,"Japanese", 5,true,"King, Tokyo"));
        mailBoxList.add(new MailBox(4,"Chinese", 5,true,"Trung Hoa, Bắc Kinh"));
    }

    @Override
    public List<MailBox> showList() {
        return  mailBoxList;
    }

    @Override
    public List<String> language() {
        List<String> languagesList = new ArrayList<>();
        languagesList.add("Vietnamese");
        languagesList.add("English");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        return languagesList;
    }

    @Override
    public List<Integer> pageSizes() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(20);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }

    @Override
    public MailBox findById(int id ) {
        for (MailBox mailBox : mailBoxList) {
            if( id == mailBox.getId()){
                return mailBox;
            }
        }
        return null;
    }


    @Override
    public void update(MailBox mailBox) {
        for (MailBox mailBox1 : mailBoxList){
            if (mailBox1.getId() == mailBox.getId()){
                mailBox1.setLanguage(mailBox.getLanguage());
                mailBox1.setPageSize(mailBox.getPageSize());
                mailBox1.setSpamsFilter(mailBox.isSpamsFilter());
                mailBox1.setSignature(mailBox.getSignature());
            }
        }
    }
}
