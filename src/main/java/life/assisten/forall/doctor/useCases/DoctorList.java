package life.assisten.forall.doctor.useCases;

import life.assisten.forall.doctor.controller.converter.DoctorToDTO;
import life.assisten.forall.doctor.controller.dto.DoctorDTO;
import life.assisten.forall.doctor.domain.DoctorDomain;
import life.assisten.forall.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorList {

    private final DoctorRepository doctorRepository;
    private final DoctorToDTO converter;

    public DoctorList(DoctorRepository doctorRepository, DoctorToDTO converter) {
        this.doctorRepository = doctorRepository;
        this.converter = converter;
    }

    public List<DoctorDTO> listDoctors() {
        List<DoctorDomain> doctorDomains = doctorRepository.findAll();
        return doctorDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO findDoctorById(Integer id) {
        Optional<DoctorDomain> optionalDoctorDomain = doctorRepository.findById(id);
        return optionalDoctorDomain.map(converter::convertToDTO).orElse(null);
    }
}
