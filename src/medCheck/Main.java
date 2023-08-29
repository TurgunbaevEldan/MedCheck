package medCheck;


import medCheck.service.serviceImpl.DoctorServiceImpl;
import medCheck.service.serviceImpl.HospitalServiceImpl;
import medCheck.db.DataBase;
import medCheck.enums.Gender;
import medCheck.service.serviceImpl.PatientServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl(dataBase);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(dataBase);
        PatientServiceImpl patientService = new PatientServiceImpl(dataBase);

        List<Doctor> doctor1 = List.of(new Doctor(1L, "Rabiya", "Moldokamilova", Gender.FEMALE, 5));
        List<Doctor> doctor2 = List.of(new Doctor(2L, "Elaman", "Erlan uulu", Gender.MALE, 3));
        List<Doctor> doctor3 = List.of(new Doctor(3L, "Kuti", "Bakirov", Gender.MALE, 7));
        List<Doctor> doctor4 = List.of(new Doctor(4L, "Rysbay", "Sagynaliev", Gender.MALE, 4));


        List<Department> department1 = List.of(new Department(1L, "Surgery", doctor1),
                new Department(2L, "x-ray", doctor2),
                new Department(3L, "Optometrist", doctor3),
                new Department(4L, "Allergology", doctor4));


        List<Patient> patient1 = List.of(new Patient(1L, "Muslim", "Moldokamilov", 10, Gender.MALE),
                new Patient(2L, "Medina", "Moldokamilova", 14, Gender.FEMALE),
                new Patient(3L, "Asel", "Nurlanova", 19, Gender.FEMALE),
                new Patient(4L, "Akylai", "Musaeva", 22, Gender.FEMALE));


        while (true) {
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Add hospital");
                    System.out.println("Введите ID Больницы");
                    Long hospitalId = new Scanner(System.in).nextLong();
                    System.out.println("Введите имя больницы");
                    String hospitalName = new Scanner(System.in).nextLine();
                    System.out.println("Введите адресс больницы");
                    String hospitalAddress = new Scanner(System.in).nextLine();
                    System.out.println(hospitalService.addHospital(new Hospital(hospitalId, hospitalName, hospitalAddress, department1, doctor1, patient1)));
                    break;
                case 2:
                    System.out.println("Find hospital by Id");
                    System.out.println("Введите ID больницы ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalService.findHospitalById(id));
                    break;
                case 3:
                    System.out.println("Get all hospital");
                    System.out.println(hospitalService.getAllHospital());
                    break;
                case 4:
                    System.out.println("Get all patient from hospital");
                    System.out.println("Введите ID больницы ");
                    Long i = new Scanner(System.in).nextLong();
                    hospitalService.getAllPatientFromHospital(i);
                    break;
                case 5:
                    System.out.println("Delete hospital by id");
                    System.out.println("Введите ID больницы ");
                    Long o = new Scanner(System.in).nextLong();
                    System.out.println(hospitalService.deleteHospitalById(o));
                    break;
                case 6:
                    System.out.println("Get all hospital by address ");
                    System.out.println("Введите адрес больницы ");
                    String y = new Scanner(System.in).nextLine();
                    System.out.println(hospitalService.getAllHospitalByAddress(y));
                case 7:
                    System.out.println("Find doctor by id");
                    System.out.println("Введите ID доктора");
                    Long p = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.findDoctorById(p));
                    break;
                case 8:
                    System.out.println("Get all doctors by hospital id");
                    System.out.println("Введите ID больницы ");
                    Long e = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(e));
                    break;
                case 9:
                    System.out.println("Get all doctors by department id");
                    System.out.println("Введите ID отделение ");
                    Long u = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(u));
                    break;
                case 10:
                    System.out.println("Add");
                    System.out.println("Введите ID больницы ");
                    Long t = new Scanner(System.in).nextLong();
                    System.out.println("ID доктора");
                    Long f = new Scanner(System.in).nextLong();
                    System.out.println("Имя Доктора");
                    String q = new Scanner(System.in).nextLine();
                    System.out.println("Фамилия доктора");
                    String d = new Scanner(System.in).nextLine();
                    System.out.println("Введите пол доктора");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.println("Опыт работы ");
                    int r = scanner.nextInt();
                    doctorService.add(t, new Doctor(f, q, d, Gender.valueOf(gender), r));
                    break;
                case 11:
                    System.out.println("Remove by id ");
                    System.out.println("Введите ID доктора");
                    Long s = new Scanner(System.in).nextLong();
                    doctorService.removeById(s);
                    break;
                case 12:
                    System.out.println();

            }
        }
    }
}