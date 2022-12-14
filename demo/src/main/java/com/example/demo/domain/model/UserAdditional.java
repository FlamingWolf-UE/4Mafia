package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class UserAdditional implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
    private Integer Id;

    @Column(name = "AltNick")
    private String AltNickname;

    @Column(name="Nick")
    private String Nickname;

    @Column(name="Name")
    private String Name;

    @Column(name="UserEmail")
    private String Email;

    @Column(name="Gender")
    private Boolean IsMale;

    @Column(name = "PhotoFile")
    private String PhotoImagePath;
    @JsonIgnore
    @Column(name="username")
    private String username;

    @JsonIgnore
    @Column(name="password")
    private String password;

    @Column(name="mobile")
    private String PhoneNumber;

    @Column(name="Archieved")
    private Boolean IsArchived;
    @JsonIgnoreProperties({"usersOfCLub","City", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ClubID", nullable=false)
    private Club Club;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ClubStatuseID", nullable=false)
    private ClubStatus Status;

    @JsonIgnore
    @OneToMany(mappedBy = "User", fetch=FetchType.LAZY)
    private List<GameMember> Members;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="roles",
            joinColumns = @JoinColumn(name="UserID"),
            inverseJoinColumns = @JoinColumn(name="RoleID")
    )
    private List<ClubRole> Roles;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getDescription()))
                .collect(Collectors.toList());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
