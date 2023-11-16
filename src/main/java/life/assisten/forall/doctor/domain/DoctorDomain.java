package life.assisten.forall.doctor.domain;

import jakarta.persistence.*;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;
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
@Table(name = "usuario_medico")
public class DoctorDomain implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "nm_medico", length = 100)
    private String nmMedico;

    @Column(name = "tipo_especialidade", length = 50)
    private String tipoEspecialidade;

    @Column(name = "crm", length = 20)
    private String crm;

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

    @OneToMany(mappedBy = "doctorDomain", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
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
