public class javaaprilproject{
    public static void main(){
        class Doctor {
    private int doctorId;
    private String name;
    private String specialization;

    // Constructor
    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    // Display method
    public void displayDoctor() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

class Patient {
    private int patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Display method
    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String timeSlot;
    private String status;

    // Constructor
    public Appointment(Doctor doctor, Patient patient,
                       String timeSlot, String status) {
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    // Display method
    public void displayAppointment() {
        System.out.println("\total----- Appointment Details -----");

        System.out.println("\nDoctor Details:");
        doctor.displayDoctor();

        System.out.println("\nPatient Details:");
        patient.displayPatient();

        System.out.println("\nTime Slot: " + timeSlot);
        System.out.println("Status: " + status);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {

        // Array of Doctors
        Doctor[] doctors = new Doctor[2];

        doctors[0] = new Doctor(101, "Dr. Sharma", "Cardiologist");
        doctors[1] = new Doctor(102, "Dr. Verma", "Dermatologist");

        // Array of Patients
        Patient[] patients = new Patient[2];

        patients[0] = new Patient(201, "Rahul", 22);
        patients[1] = new Patient(202, "Priya", 25);

        // Array of Appointments
        Appointment[] appointments = new Appointment[2];

        appointments[0] = new Appointment(
                doctors[0],
                patients[0],
                "10:00 AM",
                "Booked"
        );

        appointments[1] = new Appointment(
                doctors[1],
                patients[1],
                "11:30 AM",
                "Cancelled"
        );

        // Display all appointments
        for (int counter = 0; counter < appointments.length; counter++) {
            appointments[counter].displayAppointment();
        }
    }
}

    }
}