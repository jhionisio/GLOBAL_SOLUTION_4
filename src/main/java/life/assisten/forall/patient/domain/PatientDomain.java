package life.assisten.forall.patient.domain;

import jakarta.persistence.*;
import life.assisten.forall.diary.domain.DiaryDomain;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;
import life.assisten.forall.emergencyContacts.domain.EmergencyContactsDomain;
import life.assisten.forall.healthinsurance.domain.HealthinsuranceDomain;
import life.assisten.forall.record.domain.RecordDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario_paciente")
public class PatientDomain implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "nm_paciente", length = 100)
    private String nmPaciente;

    @Column(name = "nm_doencas_cronicas", length = 255)
    private String nmDoencasCronicas;

    @Column(name = "nr_cpf", length = 11)
    private String nrCpf;

    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Column(name = "sexo", length = 1)
    private char sexo;

    @Column(name = "nm_endereco", length = 255)
    private String nmEndereco;

    @Column(name = "nr_telefone", length = 20)
    private String nrTelefone;

    @Column(name = "nn_email", length = 100)
    private String email;

    @Column(name = "password", length = 60)
    private String password;

    @OneToMany(mappedBy = "patientDomain", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<RecordDomain> recordDomains;

    @OneToMany(mappedBy = "patientDomain", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<EmergencyContactsDomain> emergencyContactsDomains;

    @OneToMany(mappedBy = "patientDomain", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<HealthinsuranceDomain> healthInsuranceDomains;

    @OneToMany(mappedBy = "patientDomain", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<DoctorPatientDomain> doctorPatientDomains;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
