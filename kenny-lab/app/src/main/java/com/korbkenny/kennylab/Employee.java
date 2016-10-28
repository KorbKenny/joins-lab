package com.korbkenny.kennylab;

/**
 * Created by KorbBookProReturns on 10/28/16.
 */

public class Employee {
    private String mFirstName, mLastName, mCity;
    private int mYear;
    private Integer mSsn;

    public Employee(Integer ssn, String firstName, String lastName, int year, String city) {
        mSsn = ssn;
        mFirstName = firstName;
        mLastName = lastName;
        mYear = year;
        mCity = city;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public void setYear(int year) {
        mYear = year;
    }

    public void setSsn(Integer ssn) {
        mSsn = ssn;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getCity() {
        return mCity;
    }

    public int getYear() {
        return mYear;
    }

    public Integer getSsn() {
        return mSsn;
    }
}
