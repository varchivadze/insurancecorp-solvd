package org.solvd.service;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Year;

public class YearAdapter extends XmlAdapter<String, Year> {

    @Override
    public Year unmarshal(String year) {
        return Year.parse(year);
    }

    @Override
    public String marshal(Year year) {
        return year.toString();
    }
}
