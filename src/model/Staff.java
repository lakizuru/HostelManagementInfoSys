package model;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class Staff extends User {
    private double salary;
    private String bank, accountNo;
    private String dept; //department
    
    public Staff(){
        super();
    }
    
    public Staff (String username, String name, String dept){
        super(username, name);
        this.dept = dept;
    }

    public Staff(String username, String name, String nic, String phone, String address, boolean gender,
                    int salary, String bank, String accountNo, String dept) {
            super(username, name, nic, phone, address, gender);
            this.salary = salary;
            this.bank = bank;
            this.accountNo = accountNo;
            this.dept = dept;
    }

    public double getSalary() {
            return salary;
    }

    public void setSalary(double salary) {
            this.salary = salary;
    }

    public String getBank() {
            return bank;
    }

    public void setBank(String bank) {
            this.bank = bank;
    }

    public String getAccountNo() {
            return accountNo;
    }

    public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
    }

    public String getDept() {
            return dept;
    }

    public void setDept(String dept) {
            this.dept = dept;
    }
}
