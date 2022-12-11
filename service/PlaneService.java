package service;

import entity.Certification;
import entity.Employee;
import entity.Plane;
import repository.PlaneRepository;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneService {
    private Connection connection;

    public PlaneService() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }
    private PlaneRepository planeRepository;

    //7. Có bao nhiêu loại máy báy Boeing.
    public int request7() throws Exception {
        int count =0;
        for (Plane plane: planeRepository.getListPlane()){
            if (plane.getType().contains("Boeing")){
                count++;
            }
        }
        return count;
    }


}
