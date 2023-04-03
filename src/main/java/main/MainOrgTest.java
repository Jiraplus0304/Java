package main;

import exam.base.OrgUnit;
import exam.unit.Department;
import exam.unit.School;
import exam.unit.Staff;
import exam.base.Group;


public class MainOrgTest {
    public static void main(String[] args) {
//        testSchool();
//        testDepartment();
//        testStaff();
//        testDepeartmentGroup();
    }

    public static void testSchool(){
        School sc1 = new School(1,"SIT");
        System.out.printf("%s : code[%d], balance[%.2f],log[%s]\n",sc1.getName(),sc1.getCode(),sc1.getBalance(),sc1.getLog());
        sc1.earn(10000);
        sc1.spend(2500);
        System.out.printf("%s : code[%d], balance[%.2f],log[%s]\n",sc1.getName(),sc1.getCode(),sc1.getBalance(),sc1.getLog());
    }
    public static void testDepartment(){
        School sc1 = new School(1,"SIT");
        Department de1 = new Department(1,"IT",sc1);
        System.out.printf("%s : code[%d] school[%s] log[%s]\n", de1.getName(),de1.getCode(),de1.getSchool().getName(),de1.getLog());
        de1.setSchool(new School(2,"DS"));
        System.out.printf("%s : code[%d] school[%s] log[%s]\n", de1.getName(),de1.getCode(),de1.getSchool().getName(),de1.getLog());
    }
    public static void testAsOrgUnit(){
        School s1 = new School(1,"SIT");
        Dep
    }
    public static void testDepartmentAsLoggable(){

    }

    public static void testStaff(){
        School sc1 = new School(1,"SIT");
        Department de1 = new Department(2,"IT",sc1);
        Staff sf1 = new Staff(011,"Jiraplus","Chanpong",sc1);
        Staff sf2 = new Staff(011,"Jiraplus","Chanpong",de1);
        sf1.setId(011);
        sf1.setFirstname("Jiraplus");
        sf1.setLastname("Chanpong");
        sf1.setAffliation(sc1);
        System.out.printf(" ID: [%d] , Name : %s , %s , Affliation : [ %s ]",sf1.getId(),sf1.getFirstname(),sf1.getLastname(),sf1.getAffliation().getName());
    }

    public static void testDepeartmentGroup(){

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
