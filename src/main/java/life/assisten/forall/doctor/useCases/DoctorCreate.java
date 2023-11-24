package life.assisten.forall.doctor.useCases;

import life.assisten.forall.doctor.controller.converter.DoctorToDomain;
import life.assisten.forall.doctor.controller.dto.DoctorDTO;
import life.assisten.forall.doctor.domain.DoctorDomain;
import life.assisten.forall.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorCreate {

    private final DoctorRepository doctorRepository;
    private final DoctorToDomain converter;

    public DoctorCreate(DoctorRepository doctorRepository, DoctorToDomain converter) {
        this.doctorRepository = doctorRepository;
        this.converter = converter;
    }

    public DoctorDomain createDoctor(DoctorDTO doctorDTO) {
        DoctorDomain doctorDomain = converter.convertToDomain(doctorDTO);
        return doctorRepository.save(doctorDomain);
    }

}
