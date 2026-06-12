class Doctor {
    int doctorId;
    String name;
    String specialization;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }
}

class Patient {
    int patientId;
    String name;
    int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
}

class Appointment {
    Doctor doctor;
    Patient patient;
    String timeSlot;
    String status;

    public Appointment(Doctor doctor, Patient patient, String timeSlot) {
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.status = "Booked";
    }
}

class AppointmentManager {
    Appointment[] appointments = new Appointment[10];
    int count = 0;

    public boolean isSlotAvailable(Doctor doctor, String timeSlot) {
        for (int i = 0; i < count; i++) {
            if (appointments[i].doctor.doctorId == doctor.doctorId
                    && appointments[i].timeSlot.equals(timeSlot)
                    && appointments[i].status.equals("Booked")) {
                return false;
            }
        }
        return true;
    }

    public void bookAppointment(Doctor doctor,
                                Patient patient,
                                String timeSlot) {

        if (isSlotAvailable(doctor, timeSlot)) {
            appointments[count++] =
                    new Appointment(doctor, patient, timeSlot);

            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Error: Slot already booked.");
        }
    }

    public void cancelAppointment(int patientId, String timeSlot) {
        for (int i = 0; i < count; i++) {
            if (appointments[i].patient.patientId == patientId
                    && appointments[i].timeSlot.equals(timeSlot)
                    && appointments[i].status.equals("Booked")) {

                appointments[i].status = "Cancelled";
                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public void displayAppointments() {
        System.out.println("\n----- Appointment Details -----");

        for (int i = 0; i < count; i++) {
            System.out.println("Doctor: "
                    + appointments[i].doctor.name);

            System.out.println("Patient: "
                    + appointments[i].patient.name);

            System.out.println("Time Slot: "
                    + appointments[i].timeSlot);

            System.out.println("Status: "
                    + appointments[i].status);

            System.out.println("-------------------------");
        }
    }
}

public class javaaprilproject {

    public static void main(String[] args) {

        Doctor[] doctors = new Doctor[2];
        doctors[0] = new Doctor(101,
                "Dr. Sharma",
                "Cardiologist");

        doctors[1] = new Doctor(102,
                "Dr. Verma",
                "Dermatologist");

        Patient[] patients = new Patient[2];
        patients[0] = new Patient(201,
                "Rahul",
                22);

        patients[1] = new Patient(202,
                "Priya",
                25);

        AppointmentManager manager =
                new AppointmentManager();

        manager.bookAppointment(
                doctors[0],
                patients[0],
                "10:00 AM"
        );

        manager.displayAppointments();

        System.out.println("\nAttempting same slot...");

        manager.bookAppointment(
                doctors[0],
                patients[1],
                "10:00 AM"
        );

        System.out.println("\nCancelling appointment...");

        manager.cancelAppointment(
                201,
                "10:00 AM"
        );

        manager.displayAppointments();
    }
}