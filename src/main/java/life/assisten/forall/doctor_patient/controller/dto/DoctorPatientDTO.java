package life.assisten.forall.doctor_patient.controller.dto;

import life.assisten.forall.doctor.domain.DoctorDomain;
import life.assisten.forall.patient.domain.PatientDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatientDTO {
    private PatientDomain patientDomain;
    private DoctorDomain doctorDomain;
}