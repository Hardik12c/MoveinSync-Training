package com.collections;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String CompanyName;
    private String type;
    private int turnover;

    Company(String CompanyName,String type,int turnover){
        this.CompanyName=CompanyName;
        this.turnover=turnover;
        this.type=type;
    }
}
class Record{
    List<Company> li=new ArrayList<Company>();

    String addCompany(Company company) {
        li.add(company);
        return "Added";
    }
}
