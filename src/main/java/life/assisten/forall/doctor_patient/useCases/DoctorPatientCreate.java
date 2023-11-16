package life.assisten.forall.doctor_patient.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.doctor.controller.converter.DoctorToDomain;
import life.assisten.forall.doctor.repository.DoctorRepository;
import life.assisten.forall.doctor_patient.controller.converters.DoctorPatientToDomain;
import life.assisten.forall.doctor_patient.controller.dto.DoctorPatientDTO;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;
import life.assisten.forall.doctor_patient.repository.DoctorPatientRepository;
import life.assisten.forall.patient.controller.converter.PatientToDomain;
import life.assisten.forall.patient.repository.PatientRepository;

@Service
public class DoctorPatientCreate {

    private final DoctorPatientRepository doctorPatientRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DoctorPatientToDomain converter;
    private final DoctorToDomain doctorToDomain;
    private final PatientToDomain patientToDomain;

    public DoctorPatientCreate(PatientToDomain patientToDomain, DoctorToDomain doctorToDomain,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository, DoctorPatientRepository doctorPatientRepository,
            DoctorPatientToDomain converter) {
        this.doctorPatientRepository = doctorPatientRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.converter = converter;
        this.doctorToDomain = doctorToDomain;
        this.patientToDomain = patientToDomain;
    }

    public DoctorPatientDomain createDoctorPatient(Integer doctorId, Integer patientId) {
        DoctorPatientDTO doctorPatientDTO = new DoctorPatientDTO();
        doctorPatientDTO.setDoctorDomain(doctorToDomain.convertToDomainOptional(doctorRepository.findById(doctorId)));
        doctorPatientDTO.setPatientDomain(
                patientToDomain.convertToDomainOptional(patientRepository.findByIdPaciente(patientId)));
        DoctorPatientDomain doctorPatient = converter.convertToEntity(doctorPatientDTO);
        return doctorPatientRepository.save(doctorPatient);
    }
}
