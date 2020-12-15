package com.demo.contact.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@NamedQueries({@NamedQuery(query = "FROM Contact c WHERE c.email LIKE :email", name = "Contact.listContactsByEmail"),
        @NamedQuery(query = "FROM Contact c WHERE c.personalPhoneNumber LIKE :phoneNumber or c.workPhoneNumber LIKE :phoneNumber", name = "Contact.listContactsByPhoneNumber"),
        @NamedQuery(query = "FROM Contact c WHERE c.address.city LIKE :city", name = "Contact.listContactsByCity"),
        @NamedQuery(query = "FROM Contact c WHERE c.address.state LIKE :state", name = "Contact.listContactsByState")})
public class Contact extends ResourceSupport {
    @Id
    @GeneratedValue
    private Long contactId;
    private String name;
    private String company;
    private String profileImage;
    private String email;
    private Calendar birthdate;
    private String personalPhoneNumber;
    private String workPhoneNumber;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Address address;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ContactMovie> movies;

    public Contact(Long contactId, String name, String company, String profileImage, String email, Calendar birthdate,
                   String personalPhoneNumber, String workPhoneNumber, Address address, Set<ContactMovie> movies) {
        this.contactId = contactId;
        this.name = name;
        this.company = company;
        this.profileImage = profileImage;
        this.email = email;
        this.birthdate = birthdate;
        this.personalPhoneNumber = personalPhoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.address = address;
        this.movies = movies;
    }

    public Contact() {
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<ContactMovie> getMovies() {
        return movies;
    }

    public void setMovies(Set<ContactMovie> movies) {
        this.movies = movies;
    }
}
