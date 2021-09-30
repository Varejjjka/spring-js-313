package web.model;


import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "roles1")
public class Role implements GrantedAuthority {

        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column
        private String name;

        //31-05 либо закомментируем, либо пишем DTO
//        @ManyToMany(fetch = FetchType.EAGER,mappedBy = "role")
//        private Set<User> users;

        public Role() {

        }

        public Role(long id, String name) {
                this.id = id;
                this.name = name;
        }

        @Override
        public String getAuthority() {
                return getName();
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

        //31-05 либо закомментируем, либо пишем DTO
//        public Set<User> getUsers() {
//                return users;
//        }
//
//        public void setUsers(Set<User> users) {
//                this.users = users;
//        }
}
