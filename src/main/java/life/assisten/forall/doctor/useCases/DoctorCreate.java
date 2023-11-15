package life.assisten.forall.doctor.useCases;

import life.assisten.forall.doctor.controller.converter.DoctorToDomain;
import life.assisten.forall.doctor.controller.dto.DoctorDTO;
import life.assisten.forall.doctor.domain.DoctorDomain;
import life.assisten.forall.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class DoctorCreate {

    private final DoctorRepository doctorRepository;
    private final DoctorToDomain converter;
    private final PasswordEncoder passwordEncoder;

    public DoctorCreate(DoctorRepository doctorRepository, DoctorToDomain converter, PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
    }

    public DoctorDomain createDoctor(DoctorDTO doctorDTO) {
        DoctorDomain doctorDomain = converter.convertToDomain(doctorDTO);
        String senhaCodificada = passwordEncoder.encode(doctorDomain.getPassword());
        doctorDomain.setPassword(senhaCodificada);
        return doctorRepository.save(doctorDomain);
    }

}
