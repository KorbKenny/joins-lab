package com.korbkenny.kennylab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mButton1, mButton2, mButton3;
    private RecyclerView mRecyclerView;
    private RVAdapter mRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> mMacysResults;
        final List<String> mBostonCompaniesResults;
        final List<String> mHighSalaryResult;
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Helper helper = Helper.getInstance(MainActivity.this);

        Employee employee1 = new Employee(123045678,"John","Smith",1973,"NY");
        Employee employee2 = new Employee(123045679,"David","McWill",1982,"Seattle");
        Employee employee3 = new Employee(123045680,"Katerina","Wise",1973,"Boston");
        Employee employee4 = new Employee(123045681,"Donald","Lee",1992,"London");
        Employee employee5 = new Employee(123045682,"Gary","Henwood",1987,"Las Vegas");
        Employee employee6 = new Employee(123045683,"Anthony","Bright",1963,"Seattle");
        Employee employee7 = new Employee(123045684,"William","Newey",1995,"Boston");
        Employee employee8 = new Employee(123045685,"Melony","Smith",1970,"Chicago");

        Job job1 = new Job(123045678,"Fuzz",60,1);
        Job job2 = new Job(123045679,"GA",70,1);
        Job job3 = new Job(123045680,"Little Place",120,5);
        Job job4 = new Job(123045681,"Macy's",78,3);
        Job job5 = new Job(123045682,"New Life",65,1);
        Job job6 = new Job(123045683,"Believe",158,6);
        Job job7 = new Job(123045684,"Macy's",200,8);
        Job job8 = new Job(123045685,"Stop",299,12);

//        helper.insertRowEmployee(employee1);
//        helper.insertRowEmployee(employee2);
//        helper.insertRowEmployee(employee3);
//        helper.insertRowEmployee(employee4);
//        helper.insertRowEmployee(employee5);
//        helper.insertRowEmployee(employee6);
//        helper.insertRowEmployee(employee7);
//        helper.insertRowEmployee(employee8);
//
//        helper.insertRowJob(job1);
//        helper.insertRowJob(job2);
//        helper.insertRowJob(job3);
//        helper.insertRowJob(job4);
//        helper.insertRowJob(job5);
//        helper.insertRowJob(job6);
//        helper.insertRowJob(job7);
//        helper.insertRowJob(job8);
//
        mMacysResults = helper.getMacysWorkers();
        mBostonCompaniesResults = helper.getCompaniesInBoston();
        mHighSalaryResult = helper.getHighestPaidEmployee();

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRVAdapter = new RVAdapter(mMacysResults);
                mRecyclerView.setAdapter(mRVAdapter);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRVAdapter = new RVAdapter(mBostonCompaniesResults);
                mRecyclerView.setAdapter(mRVAdapter);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRVAdapter = new RVAdapter(mHighSalaryResult);
                mRecyclerView.setAdapter(mRVAdapter);
            }
        });

    }
}
