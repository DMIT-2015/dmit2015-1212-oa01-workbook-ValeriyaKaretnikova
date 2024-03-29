package dmit2015.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EMP_DETAILS_VIEW", schema = "HR")
public class EmpDetailsViewEntity {
    @Id
    @Basic
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Basic
    @Column(name = "JOB_ID")
    private String jobId;
    @Basic
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Basic
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @Basic
    @Column(name = "LOCATION_ID")
    private Short locationId;
    @Basic
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "SALARY")
    private Integer salary;
    @Basic
    @Column(name = "COMMISSION_PCT")
    private Byte commissionPct;
    @Basic
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Basic
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Basic
    @Column(name = "CITY")
    private String city;
    @Basic
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Basic
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Basic
    @Column(name = "REGION_NAME")
    private String regionName;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        this.locationId = locationId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Byte getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Byte commissionPct) {
        this.commissionPct = commissionPct;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpDetailsViewEntity that = (EmpDetailsViewEntity) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(jobId, that.jobId) && Objects.equals(managerId, that.managerId) && Objects.equals(departmentId, that.departmentId) && Objects.equals(locationId, that.locationId) && Objects.equals(countryId, that.countryId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(salary, that.salary) && Objects.equals(commissionPct, that.commissionPct) && Objects.equals(departmentName, that.departmentName) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(city, that.city) && Objects.equals(stateProvince, that.stateProvince) && Objects.equals(countryName, that.countryName) && Objects.equals(regionName, that.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, jobId, managerId, departmentId, locationId, countryId, firstName, lastName, salary, commissionPct, departmentName, jobTitle, city, stateProvince, countryName, regionName);
    }
}
