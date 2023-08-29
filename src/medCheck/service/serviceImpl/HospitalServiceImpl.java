package medCheck.service.serviceImpl;

import medCheck.Hospital;
import medCheck.Patient;
import medCheck.service.HospitalService;
import medCheck.db.DataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    private DataBase dataBase;

    public HospitalServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addHospital(Hospital hospital) {
        dataBase.getHospitals().add(hospital);
        return "Больница успешно добавлен...";
    }

    @Override
    public String findHospitalById(Long id) {
        dataBase.getHospitals().stream().filter(hospital -> false).forEach(System.out::println);
        return dataBase.getHospitals() + "\nБольница найдено ";
    }


    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream()
                .filter(hospital -> hospital.getId().equals(id)).toList();
        System.out.println(dataBase.getPatients()+"Все пациенты которые вы ищете \n");
        return list.get(0).getPatients();
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (int i = 0; i < dataBase.getHospitals().size(); i++) {
            if (dataBase.getHospitals().get(i).getId() == id) {
                dataBase.getHospitals().remove(dataBase.getHospitals().get(i));
            }
        }
        return dataBase.getHospitals() + "Больница успешно удалено";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalsByAddress = new HashMap<>();
        for (Hospital hospital : getAllHospital()) {
            if (hospital.getAddress().equalsIgnoreCase(address)) {
                hospitalsByAddress.put(hospital.getHospitalName(), hospital);
            }
        }
        return hospitalsByAddress;
    }
}
