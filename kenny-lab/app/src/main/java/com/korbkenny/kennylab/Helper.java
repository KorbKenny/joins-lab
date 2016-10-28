package com.korbkenny.kennylab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KorbBookProReturns on 10/28/16.
 */

public class Helper extends SQLiteOpenHelper {

    public static final String EMPLOYEE_TABLE_NAME = "employee";
    public static final String COL_SSN = "ssn";
    public static final String COL_NAME_FIRST = "first_name";
    public static final String COL_NAME_LAST = "last_name";
    public static final String COL_BIRTH_YEAR = "birth_year";
    public static final String COL_CITY = "city";

    public static final String JOB_TABLE_NAME = "job";
    //public static final String COL_SSN = "ssn;"
    public static final String COL_COMPANY = "company";
    public static final String COL_SALARY = "salary";
    public static final String COL_EXPERIENCE = "experience";

    public static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY, " +
            COL_NAME_FIRST + " TEXT, " +
            COL_NAME_LAST + " TEXT, " +
            COL_BIRTH_YEAR + " INT, " +
            COL_CITY + " TEXT)";

    public static final String CREATE_JOB_TABLE = "CREATE TABLE " +
            JOB_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY, " +
            COL_COMPANY + " TEXT, " +
            COL_SALARY + " INT, " +
            COL_EXPERIENCE + " INT)";

    private static final String DELETE_TABLE_EMPLOYEE = "DROP TABLE IF EXISTS " +
            EMPLOYEE_TABLE_NAME;
    private static final String DELETE_TABLE_JOB = "DROP TABLE IF EXISTS " +
            JOB_TABLE_NAME;

    public void insertRowEmployee(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, employee.getSsn());
        values.put(COL_NAME_FIRST, employee.getFirstName());
        values.put(COL_NAME_LAST, employee.getLastName());
        values.put(COL_BIRTH_YEAR, employee.getYear());
        values.put(COL_CITY, employee.getCity());
        db.insertOrThrow(EMPLOYEE_TABLE_NAME,null,values);
    }

    public void insertRowJob(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, job.getSsn());
        values.put(COL_COMPANY, job.getCompany());
        values.put(COL_SALARY, job.getSalary());
        values.put(COL_EXPERIENCE, job.getExperience());
        db.insertOrThrow(JOB_TABLE_NAME,null,values);
    }

    private Helper(Context context){super(context,"db",null,1);}

    private static Helper INSTANCE;

    public static synchronized Helper getInstance(Context context){
        if(INSTANCE == null)
            INSTANCE = new Helper(context.getApplicationContext());
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEE_TABLE);
        db.execSQL(CREATE_JOB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DELETE_TABLE_EMPLOYEE);
        db.execSQL(DELETE_TABLE_JOB);
        onCreate(db);
    }


    public List<String> getMacysWorkers(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + COL_NAME_FIRST + ", " + COL_NAME_LAST + ", " +
                COL_COMPANY + " FROM " + EMPLOYEE_TABLE_NAME + " INNER JOIN " +
                JOB_TABLE_NAME + " ON " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " = " + JOB_TABLE_NAME + "." + COL_SSN;

        Cursor cursor = db.rawQuery(query,null);

        List<String> names = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                if((cursor.getString(cursor.getColumnIndex(COL_COMPANY))).equals("Macy's")) {
                    String first = cursor.getString(cursor.getColumnIndex(COL_NAME_FIRST));
                    String last = cursor.getString(cursor.getColumnIndex(COL_NAME_LAST));
                    String name = first + " " + last;
                    names.add(name);
                }
                cursor.moveToNext();
            }
        }
        cursor.close();
        return names;
    }

    public List<String> getCompaniesInBoston(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + COL_COMPANY + ", " + COL_CITY + " FROM " +
                EMPLOYEE_TABLE_NAME + " INNER JOIN " +  JOB_TABLE_NAME + " ON " +
                EMPLOYEE_TABLE_NAME + "." + COL_SSN + " = " +
                JOB_TABLE_NAME + "." + COL_SSN;

        Cursor cursor = db.rawQuery(query,null);

        List<String> companies = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                if((cursor.getString(cursor.getColumnIndex(COL_CITY))).equals("Boston")) {
                    String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                    companies.add(company);
                }
                cursor.moveToNext();
            }
        }
        cursor.close();
        return companies;
    }

    public List<String> getHighestPaidEmployee(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + COL_NAME_FIRST + ", " + COL_NAME_LAST + ", " +
                COL_SALARY + " FROM " + EMPLOYEE_TABLE_NAME + " INNER JOIN " +
                JOB_TABLE_NAME + " ON " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " = " + JOB_TABLE_NAME + "." + COL_SSN;

        Cursor cursor = db.rawQuery(query,null);

        List<String> highestNameList = new ArrayList<>();

        int highest = 0;
        String highestName = "";

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                int salary = cursor.getInt(cursor.getColumnIndex(COL_SALARY));
                if(salary > highest){
                    highest = salary;
                    highestName = cursor.getString(cursor.getColumnIndex(COL_NAME_FIRST))+" "+
                            cursor.getString(cursor.getColumnIndex(COL_NAME_LAST));
                }
                cursor.moveToNext();
            }
        }

        highestNameList.add(highestName);
        cursor.close();
        return highestNameList;
    }

}
