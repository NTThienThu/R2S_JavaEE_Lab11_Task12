package service;

import entity.Certification;
import entity.Employee;
import entity.Flight;
import entity.Plane;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CertificateService {
    private Connection connection;

    public CertificateService() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }


}

