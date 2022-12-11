package service;

import entity.Certification;
import entity.Employee;
import entity.Flight;
import repository.FlightRepository;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
    private Connection connection;

    public FlightService() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }

    private FlightRepository flightRepository;

    //6.Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    public int request6() throws Exception {
        int count = 0;
        for (Flight flight : flightRepository.getListFlight()) {
            if (flight.getFrom().equals("SGN")) {
                count++;
            }
        }
        return count;
    }
    //--20.	Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
    public List<Flight> request20() throws Exception {
        List<Flight> flights = new ArrayList<>();
        for (Flight flight : flightRepository.getListFlight()) {
            if (flight.getOurGo().getHours()<12) {
               flights.add(flight);
            }
        }
        return flights;
    }




}

