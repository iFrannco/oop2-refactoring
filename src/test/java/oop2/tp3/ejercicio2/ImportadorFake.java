package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.StringReader;

public class ImportadorFake implements Importador{
    @Override
    public CSVReader importar() {
        String fakeCsvData =
                "permalink,company_name,number_employees,category,city,state,funded_date,raised_amount,raised_currency,round\n" +
                        "company/a,Alpha Inc,50,Software,San Francisco,CA,2020-01-15,500000,USD,Seed\n" +
                        "facebook,Facebook,450,web,Palo Alto,CA,1-Sep-04,500000,USD,angel\n" +
                        "company/c,Gamma SA,35,E-commerce,Bogotá,Cundinamarca,2021-09-30,750000,COP,Angel\n" +
                        "company/d,Delta GmbH,80,Health,Berlin,Berlin,2018-03-20,1000000,EUR,Series B";

        CSVReader csvReader = new CSVReader(new StringReader(fakeCsvData));

        return csvReader;
    }
}
