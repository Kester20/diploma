package com.diploma.noormal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Time;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long mobileNumber;
    private Long failedLogin;
    private Time banWillBeRemoved;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (!id.equals(users.id)) return false;
        if (!firstName.equals(users.firstName)) return false;
        if (!lastName.equals(users.lastName)) return false;
        if (!email.equals(users.email)) return false;
        if (!password.equals(users.password)) return false;
        if (!mobileNumber.equals(users.mobileNumber)) return false;
        if (!failedLogin.equals(users.failedLogin)) return false;
        if (!banWillBeRemoved.equals(users.banWillBeRemoved)) return false;
        return role.equals(users.role);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + mobileNumber.hashCode();
        result = 31 * result + failedLogin.hashCode();
        result = 31 * result + banWillBeRemoved.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", failedLogin=" + failedLogin +
                ", banWillBeRemoved=" + banWillBeRemoved +
                ", role=" + role +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getFailedLogin() {
        return failedLogin;
    }

    public void setFailedLogin(Long failedLogin) {
        this.failedLogin = failedLogin;
    }

    public Time getBanWillBeRemoved() {
        return banWillBeRemoved;
    }

    public void setBanWillBeRemoved(Time banWillBeRemoved) {
        this.banWillBeRemoved = banWillBeRemoved;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
