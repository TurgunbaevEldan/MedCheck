package medCheck.service;

import medCheck.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    String addPatientsToHospital(Long id,List<Patient> patients);
    Patient getPatientById(Long id);
     List<Patient> getAllPatient();
    Map<Integer, Patient> getPatientByAge(int age);
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
