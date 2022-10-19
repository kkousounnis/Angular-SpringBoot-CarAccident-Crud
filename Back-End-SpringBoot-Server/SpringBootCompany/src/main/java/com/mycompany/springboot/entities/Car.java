package com.mycompany.springboot.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_emp", catalog = "kkcompany", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TbEmp.findAll", query = "SELECT t FROM TbEmp t"),
//    @NamedQuery(name = "TbEmp.findById", query = "SELECT t FROM TbEmp t WHERE t.id = :id"),
//    @NamedQuery(name = "TbEmp.findByName", query = "SELECT t FROM TbEmp t WHERE t.name = :name"),
//    @NamedQuery(name = "TbEmp.findByGender", query = "SELECT t FROM TbEmp t WHERE t.gender = :gender"),
//    @NamedQuery(name = "TbEmp.findByDepartment", query = "SELECT t FROM TbEmp t WHERE t.department = :department"),
//    @NamedQuery(name = "TbEmp.findByDob", query = "SELECT t FROM TbEmp t WHERE t.dob = :dob")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private String firstName;
    @Column(length = 255)
    private String lastName;
    @Column(length = 255)
    private String emailId;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{id=").append(id);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", emailId=").append(emailId);
        sb.append('}');
        return sb.toString();
    }
}
