package main;

import exam.base.Group;
import exam.base.Loggable;
import exam.base.OrgUnit;
import exam.unit.Department;
import exam.unit.School;
import exam.unit.Staff;

public class MainOrgTest {
    public static void main(String[] args) {
        testSchool();
        testDepartment();
        testSchoolAsOrgUnit();
        testDepartmentAsLoggable();
        testStaff();
        testDepartmentGroup();
    }


    public static void testSchool(){
        School sc1 = new School(1,"SIT");
        sc1.earn(10000);
        sc1.spend(5000);
        System.out.printf("code [%d] School [%s] Balance [%s] Log [%s]\n",sc1.getCode(),sc1.getName(),sc1.getBalance(),sc1.getLog());
        sc1.spend(5000);
        sc1.ClearLog();
        System.out.printf("code [%d] School [%s] Balance [%s] Log [%s]\n",sc1.getCode(),sc1.getName(),sc1.getBalance(),sc1.getLog());

    }
    public static void testDepartment(){
        Department de1 = new Department(1,"IT",new School(1,"SIT"));
        System.out.printf(" %s : code[%d] School [%s] Log[%s]\n",de1.getName(),de1.getCode(),de1.getSchool().getName(),de1.getLog());
        de1.setSchool(new School(2,"Debsirin"));
        de1.setName("Gifted");
        System.out.printf(" %s : code[%d] School [%s] Log[%s]\n",de1.getName(),de1.getCode(),de1.getSchool().getName(),de1.getLog());
        de1.ClearLog();
        System.out.printf(" %s : code[%d] School [%s] Log[%s]\n",de1.getName(),de1.getCode(),de1.getSchool().getName(),de1.getLog());
    }
    public static void testSchoolAsOrgUnit() {
        School sc1 = new School(1, "SIT");
        sc1.earn(100000);
        sc1.spend(50000);
        System.out.printf("code[%s] School[%s] Balance[%s] Log[%s]\n", sc1.getCode(), sc1.getName(), sc1.getBalance(), sc1.getLog());
        OrgUnit o1 = sc1;
        o1.setName("Debsirin");
        System.out.printf("code[%s] School[%s] Log[%s] \n", o1.getCode(), o1.getName(), o1.getLog());
        o1.ClearLog();
        System.out.printf("code[%s] School[%s] Log[%s] \n", o1.getCode(), o1.getName(), o1.getLog());
    }
    public static void testDepartmentAsLoggable () {
        Department de1 = new Department(1, "IT", new School(1, "SIT"));
        Loggable lg1 = de1;
        System.out.printf("Log[%s]\n",lg1.getLog());
        lg1.ClearLog();
        System.out.printf("Log[%s]\n",lg1.getLog());
    }

    public static void testStaff(){
        Staff s1 = new Staff(11,"Jiraplus","Chanpong",new Department(1,"IT",new School(1,"SIT")));
        System.out.printf(" %s : fname[%s] lname[%s] affliation[%s]\n",s1.getId(),s1.getFirstname(),s1.getLastname(),s1.getAffliation().getName());
        s1.setId(99);
        s1.setFirstname("David");
        s1.setLastname("Beckham");
        s1.setAffliation(new Department(4,"Manchester",new School(4,"United")));
        System.out.printf(" %s : fname[%s] lname[%s] affliation[%s]\n",s1.getId(),s1.getFirstname(),s1.getLastname(),s1.getAffliation().getName());
    }

    public static void testDepartmentGroup(){
        School sc1 = new School(1,"SIT");

        Department de1 = new Department(1,"IT",sc1);
        Department de2 = new Department(2,"CS",(new School(2,"CS")));
        Department de3 = new Department(3,"DSI",(new School(3,"DSI")));

        Group<Department> G1 = new Group<Department>(3);

        G1.append(de1);
        G1.append(de2);
        G1.append(de3);

        for (int i = 0; i < G1.getSize(); i++) {
            System.out.println(G1.get(i).getCode());
        }

        for (int i = 0; i < G1.getSize(); i++) {
            System.out.println(G1.get(i).getName());
        }

        for (int i = 0; i < G1.getSize(); i++) {
            System.out.println(G1.get(i).getLog());
        }

        for (int i = 0; i < G1.getSize(); i++) {
            System.out.println(G1.get(i).getSchool().getCode());
        }

        for (int i = 0; i < G1.getSize(); i++) {
            System.out.println(G1.get(i).getSchool().getName());
        }


        Group<School> G2 = new Group<School>(2);
        Group<Staff> G3 = new Group<Staff>(2);
    }
}

