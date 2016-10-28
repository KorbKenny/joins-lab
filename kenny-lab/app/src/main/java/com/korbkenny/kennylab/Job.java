package com.korbkenny.kennylab;

/**
 * Created by KorbBookProReturns on 10/28/16.
 */

public class Job {
    private Integer mSsn;
    private String mCompany;
    private int mSalary, mExperience;

    public Job(Integer ssn, String company, int salary, int experience) {
        mSsn = ssn;
        mCompany = company;
        mSalary = salary;
        mExperience = experience;
    }

    public void setSsn(Integer ssn) {
        mSsn = ssn;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public void setSalary(int salary) {
        mSalary = salary;
    }

    public void setExperience(int experience) {
        mExperience = experience;
    }

    public Integer getSsn() {
        return mSsn;
    }

    public String getCompany() {
        return mCompany;
    }

    public int getSalary() {
        return mSalary;
    }

    public int getExperience() {
        return mExperience;
    }
}
