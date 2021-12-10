package edu.touro.cs.mcon264;

public enum Weekday { // enumerated type...kind of class
Sunday("יום ראשון"), Monday("יום שני"),
    Tuesday(null), Wednesday(null), Thursday(null), Friday(null), Saturday(null);
    // each enumerated value is static and final
    // enums are a type of class, you can create methods and fields
    Weekday(String heb)
    {
        hebrewDay = heb;
    }
    private String hebrewDay;

    public int toDayOrdinal()
    {
        return ordinal()+1;
    }
    public String hebrewDay()
    {
        return hebrewDay;
    }

// Principle of Least Privilege = CIA - need to know basis -- give as little access
}

enum DreidelSpin { Nun, Hey, Gimmel, Shin}