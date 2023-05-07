package com.bs.controller;
//package com.bs.controller;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.bs.dao.*;
import com.bs.model.*;
public class TestHiber {
    public static void main(String[] args) {
    	   // create a test SchedulePlanDepartment object
        SchedulePlanDepartment spd = new SchedulePlanDepartment();
        spd.setDepartmentID(1);
        spd.setSchedulePlanID(1);

        // create DAO instance
        SchedulePlanDepartmentDAOHibernate dao = new SchedulePlanDepartmentDAOHibernate();

        // test insert() method
        dao.insert(spd);
        System.out.println("Insert successful.");

        // test update() method
        spd.setDepartmentID(2);
        dao.update(spd);
        System.out.println("Update successful.");

        // test findById() method
        SchedulePlanDepartment spdFound = dao.findById(1);
        System.out.println("SchedulePlanDepartment found: " + spdFound);

        // test findBySchedulePlanId() method
        List<SchedulePlanDepartment> spdList = dao.findBySchedulePlanId(1);
        System.out.println("SchedulePlanDepartment list found: " + spdList);

        // test delete() method
        dao.delete(spd);
        System.out.println("Delete successful.");
    }
}
