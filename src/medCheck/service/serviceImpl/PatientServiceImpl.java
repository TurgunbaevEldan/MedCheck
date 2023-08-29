package medCheck.service.serviceImpl;

import medCheck.Hospital;
import medCheck.Patient;
import medCheck.db.DataBase;

import medCheck.service.GenericService;
import medCheck.service.PatientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {
    private DataBase dataBase;

    public PatientServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital h:dataBase.getHospitals()) {
            if (h.getId().equals(id)){
                h.getPatients().addAll(patients);
                return dataBase.getPatients()+"Пациент добавлен ";
            }
        }
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        List<Patient> patients = dataBase.getPatients().stream()
                .filter(patient -> patient.getId().equals(id)).toList();
        System.out.println("Пациент которого вы ищете ");
        return patients.get(0);
    }

    @Override
    public List<Patient> getAllPatient() {
        return dataBase.getPatients();
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> integerPatientMap = new HashMap<>();
        for (Patient p : getAllPatient()) {
            if (p.getAge() == age) {
                integerPatientMap.put(p.getAge(), p);
            }
        }
        return integerPatientMap;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
       return null;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public String updateById(Long id, Patient patient) {
        return null;
    }
}
