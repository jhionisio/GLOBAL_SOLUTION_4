package life.assisten.forall.doctor.controller.converter;

import org.springframework.stereotype.Component;

import life.assisten.forall.doctor.controller.dto.DoctorNoId;
import life.assisten.forall.doctor.domain.DoctorDomain;

@Component
public class DoctorNoIdToDTO {

    public static DoctorNoId convertToDoctorWithoutIdDTO(DoctorDomain doctorDomain) {
        DoctorNoId doctor = new DoctorNoId();
        doctor.setNmMedico(doctorDomain.getNmMedico());
        doctor.setTipoEspecialidade(doctorDomain.getTipoEspecialidade());
        doctor.setCrm(doctorDomain.getCrm());
        doctor.setNrCpf(doctorDomain.getNrCpf());
        doctor.setDtNascimento(doctorDomain.getDtNascimento());
        doctor.setSexo(doctorDomain.getSexo());
        doctor.setNmEndereco(doctorDomain.getNmEndereco());
        doctor.setNrTelefone(doctorDomain.getNrTelefone());
        doctor.setEmail(doctorDomain.getEmail());

        return doctor;
    }
}
