package medCheck.db;

import medCheck.Department;
import medCheck.Doctor;
import medCheck.Hospital;
import medCheck.Patient;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    List<Hospital>hospitals = new ArrayList<>();
    List<Doctor>doctors = new ArrayList<>();
    List<Department>departments = new ArrayList<>();
    List<Patient>patients = new ArrayList<>();


    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
