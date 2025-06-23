public class EmployeeInformation {
    // Attributes
    private int employeeId;
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String sssNum;
    private String pagibigNum;
    private String philhealthNum;
    private String status;
    private String position;
    private String immediateSupervisor;
    private double baseSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    // Constructors
    public EmployeeInformation(int employeeId, String lastName, String firstName, String address, String phoneNumber, String sssNum, String pagibigNum, String philhealthNum, String status, String position, String immediateSupervisor, double baseSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNum = sssNum;
        this.pagibigNum = pagibigNum;
        this.philhealthNum = philhealthNum;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.baseSalary = baseSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNum() {
        return sssNum;
    }

    public String getPagibigNum() {
        return pagibigNum;
    }

    public String getPhilhealthNum() {
        return philhealthNum;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    // Setters
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

}
