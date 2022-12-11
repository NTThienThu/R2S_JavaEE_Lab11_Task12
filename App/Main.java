package App;

import entity.Certification;
import entity.Employee;
import entity.Flight;
import entity.Plane;
import repository.CertificateRepository;
import repository.EmployeeRepository;
import repository.FlightRepository;
import repository.PlaneRepository;
import service.CertificateService;
import service.EmployeeService;
import service.FlightService;
import service.PlaneService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeService employeeService = new EmployeeService();
        FlightService flightService = new FlightService();
        CertificateService certificationService = new CertificateService();
        PlaneService planeService = new PlaneService();

        CertificateRepository certificateRepository= new CertificateRepository();
        EmployeeRepository employeeRepository= new EmployeeRepository();
        FlightRepository flightRepository= new FlightRepository();
        PlaneRepository planeRepository = new PlaneRepository();

        String select;
        Scanner sc = new Scanner(System.in);
        System.out.print("choose your funtion: ");
//Thienthu
        do {
            System.out.println("\n_________________________________________ M E N U ___________________________________________");
            System.out.println("A" +
                    "A. Show all Employee");
            System.out.println("B. Show all Flight");
            System.out.println("C. Show all Certification");
            System.out.println("D. Show all Plane");
            System.out.println("E. Insert Employee");

            System.out.println("\t1.\tCho biết các chuyến bay đi Đà Lạt (DAD).");
            System.out.println("\t2.\tCho biết các loại máy bay có tầm bay lớn hơn 10,000km.");
            System.out.println("\t3.\tTìm các nhân viên có lương nhỏ hơn 10,000.");
            System.out.println("\t4.\tCho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.");
            System.out.println("\t5.\tCho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).");
            System.out.println("\t6.\tCó bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).");
            System.out.println("\t7.\tCó bao nhiêu loại máy báy Boeing.");
            System.out.println("\t8.\tCho biết tổng số lương phải trả cho các nhân viên.");
            System.out.println("\t9.\tCho biết mã số của các phi công lái máy báy Boeing.");
            System.out.println("\t10.\tCho biết các nhân viên có thể lái máy bay có mã số 747");
            System.out.println("\t11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.");
            System.out.println("\t12.\tCho biết các loại máy bay có thể thực hiện mã số của các phi công vừa lái được Boeing vừa lái được Airbus.");
            System.out.println("\t13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.");
            System.out.println("\t14.\tCho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.");
            System.out.println("\t15.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t16.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t17.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t18.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t19.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t20.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t21.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t22.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t23.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t24.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t25.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t26.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t27.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t28.\tCho biết tên của các phi công lái máy bay Boeing.");
            System.out.println("\t29.\tCho biết tên của các phi công lái máy bay Boeing.");


            System.out.println("F. Exit");
            System.out.println("________________________________________________________________________________________________________________");

            select = sc.nextLine();
            switch (select) {
                case "A": {
                    List<Employee> employeeList = employeeRepository.getListEmployee();
                    employeeList.stream().forEach(element -> System.out.println(element.getId() + " " + element.getName()+ " " + element.getSalary()));

                    break;
                }
                case "B": {
                    List<Flight> flightList = flightRepository.getListFlight();
                    flightList.stream().forEach(element -> System.out.println(element.getId() +" " +element.getFrom() + " " +element.getTo() +" " +element.getLengthFlight() + " " +element.getOurGo() +" " +element.getOurCome() + " " +element.getCost()));

                    break;
                }

                case "C": {
                    List<Certification> certificationList = certificateRepository.getListCertificate();
                    certificationList.stream().forEach(element -> System.out.println(element.getIdE() + " " + element.getIdP()));

                    break;
                }
                case "D": {
                    List<Plane> planeList = planeRepository.getListPlane();
                    planeList.stream().forEach(element -> System.out.println(element.getId() + " " + element.getType()+ " " + element.getFlightRange()));

                    break;
                }

                case "E": {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Employee Salary: ");
                    int salary = scanner.nextInt();

                    employeeRepository.insertEmployee(id,name,salary);

                    break;
                }
                case "1":{
                    for (Flight flight: flightRepository.request1()){
                        System.out.println(flight);
                    }
                    break;
                }
                case "2":{
                    for (Plane plane: planeRepository.request2()){
                        System.out.println(plane);
                    }
                    break;
                }
                case "3":{
                    for (Employee employee: employeeRepository.request3()){
                        System.out.println(employee);
                    }
                    break;
                }
                case "4":{
                    for (Flight flight: flightRepository.request4()){
                        System.out.println(flight);
                    }
                    break;
                }
                case "5":{
                    for (Flight flight: flightRepository.request5()){
                        System.out.println(flight);
                    }
                    break;
                }
                case "6":{
                    System.out.println("Số chuyến bay xuất phát từ SG : "+ flightService.request6());
                    break;
                }
                case "7":{
                    System.out.println("Số loại máy bay Boeing : "+ planeService.request7());
                    break;
                }
                case "8":{
                    System.out.println("Tổng lương phải trả cho nv: "+ employeeService.request8());
                    break;
                }
                case "9":{
                    certificateRepository.request9();
                    break;
                }
                case "10":{
                    employeeRepository.request10();
                    break;
                }
                case "11":{
                    planeRepository.request11();
                    break;
                }
                case "12":{
                    employeeRepository.request12();
                    break;
                }
                case "13":{
                    planeRepository.request13();
                    break;
                }
                case "14":{
                    flightRepository.request14();
                    break;
                }
                case "15":{
                    employeeRepository.request15();
                    break;
                }

                case "16":{
                    break;
                }
                case "17":{
                    break;
                }
                case "18":{
                    break;
                }
                case "19":{
                    break;
                }
                case "20":{
                    break;
                }
                case "21":{
                    break;
                }
                case "22":{
                    break;
                }
                case "23":{
                    break;
                }
                case "24":{
                    break;
                }
                case "25":{
                    break;
                }
                case "26":{
                    break;
                }
                case "27":{
                    break;
                }
                case "28":{
                    break;
                }
                case "F": {
                    System.out.println("Exit");
                    System.exit(0);
                }
            }
        }
        while (!select.equals(""));
    }
}