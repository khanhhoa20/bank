package com.bs.controller;
//package com.bs.controller;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.bs.dao.*;
import com.bs.model.*;
public class TestHiber {
    public static void main(String[] args) {
        SchedulePlanDepartmentDAOHibernate schedulePlanDepartmentDAOHibernate = new SchedulePlanDepartmentDAOHibernate();
        SchedulePlanDepartment schedulePlanDepartment = new SchedulePlanDepartment(1, 2);
        schedulePlanDepartmentDAOHibernate.insert(schedulePlanDepartment);
    }
}
