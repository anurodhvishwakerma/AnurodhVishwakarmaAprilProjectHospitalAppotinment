class Doctor {
    int doctorId;
    String name;
    String specialization;

    Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }
}

class Patient {
    int patientId;
    String name;
    int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
}

class Appointment {
    int doctorId;
    String doctorName;
    int patientId;
    String patientName;
    String timeSlot;
    String status;

    Appointment(int doctorId, String doctorName,
                int patientId, String patientName,
                String timeSlot) {

        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.patientId = patientId;
        this.patientName = patientName;
        this.timeSlot = timeSlot;
        this.status = "Booked";
    }
}

public class javaaprilproject {
    public static void main(String[] args) {

        Doctor[] doctors = new Doctor[2];
        doctors[0] = new Doctor(101, "Dr. Sharma", "Cardiologist");
        doctors[1] = new Doctor(102, "Dr. Verma", "Dermatologist");

        Patient[] patients = new Patient[2];
        patients[0] = new Patient(201, "Rahul", 22);
        patients[1] = new Patient(202, "Priya", 25);

        Appointment[] appointments = new Appointment[2];

        appointments[0] = new Appointment(
                doctors[0].doctorId,
                doctors[0].name,
                patients[0].patientId,
                patients[0].name,
                "10:00 AM"
        );

        appointments[1] = new Appointment(
                doctors[1].doctorId,
                doctors[1].name,
                patients[1].patientId,
                patients[1].name,
                "11:00 AM"
        );

        for (int i = 0; i < appointments.length; i++) {
            System.out.println("Doctor: " +
                    appointments[i].doctorName);

            System.out.println("Patient: " +
                    appointments[i].patientName);

            System.out.println("Time Slot: " +
                    appointments[i].timeSlot);

            System.out.println("Status: " +
                    appointments[i].status);

            System.out.println("-------------------");
        }
    }
}