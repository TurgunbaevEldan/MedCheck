package medCheck.service.serviceImpl;

import com.sun.source.tree.UsesTree;
import medCheck.Department;
import medCheck.Hospital;
import medCheck.service.DepartmentService;
import medCheck.db.DataBase;
import medCheck.service.GenericService;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {
    private DataBase dataBase;

    public DepartmentServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream()
                .filter(hospital -> hospital.getId().equals(id)).toList();
        System.out.println("Все отделение которые вы искали ");
        return list.get(0).getDepartments();
    }

    @Override
    public Department findDepartmentByName(String name) {
        dataBase.getDepartments().stream()
                .filter(department -> department.getDepartmentName().contains(name)).forEach(System.out::println);
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital h:dataBase.getHospitals()) {
            if (h.getId().equals(hospitalId)){
                h.getDepartments().add(department);
                return "Отделение успешно добавлен ";
            }
        }
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public String updateById(Long id, Department department) {
        for (int i = 0; i < dataBase.getDepartments().size(); i++) {
            if (dataBase.getDepartments().get(i).getId()==id);
        }
        return null;
    }
}
