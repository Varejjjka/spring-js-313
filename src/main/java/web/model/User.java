package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user1")
public class User implements UserDetails {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name", unique = true)
    private String name;

    @Column(name ="password")
    private String password;

    @Column(name ="job")
    private String job;

    @Column(name ="age")
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_roles1",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns  = { @JoinColumn(name = "role_id")}
    )
    private Set<Role> role = new HashSet<>(Arrays.asList(new Role(2L, "ROLE_USER")));

    public User() {

    }

    public User(long id, String name, String password, String job, int age, Set<Role> role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.job = job;
        this.age = age;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
