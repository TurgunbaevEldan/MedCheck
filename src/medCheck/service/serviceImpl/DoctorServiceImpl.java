package medCheck.service.serviceImpl;

import medCheck.Department;
import medCheck.Doctor;
import medCheck.Hospital;
import medCheck.service.DoctorService;
import medCheck.db.DataBase;
import medCheck.service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    private DataBase dataBase;

    public DoctorServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String findDoctorById(Long id) {
        dataBase.getDoctors().stream().filter(doctor -> doctor.getId().equals(id)).forEach(System.out::println);
        return dataBase.getDoctors() + "Доктор найден";
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {

        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        List<Hospital>list = dataBase.getHospitals().stream()
                        .filter(hospital -> hospital.getId().equals(id)).toList();
        System.out.println("Все доктора которые вы искали");
        return list.get(0).getDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        List<Department>list = dataBase.getDepartments().stream().
                filter(department -> department.getId().equals(id)).toList();
        System.out.println("Все доктора которые вы искали");
        return list.get(0).getDoctors();
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (Hospital h:dataBase.getHospitals()) {
            if (h.getId().equals(hospitalId)){
                h.getDoctors().add(doctor);
                return "Доктор добавлен";
            }
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h:dataBase.getHospitals()) {
            for (int i = 0; i <h.getDoctors().size() ; i++) {
                if (h.getDoctors().get(i).getId().equals(id)){
                    h.getDoctors().remove(h.getDoctors().get(i));
                    System.out.println("Доктор удален");
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (int i = 0; i <dataBase.getDoctors().size() ; i++) {
            if (dataBase.getDoctors().get(i).getId()==id);
        }
        return null;
    }
}
