/**
 *
 */
package com.sample;

import javax.persistence.*;

@Entity
@Table(name="Seller")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

   private Integer id;
   @Column(name = "name")
   private String name;
    @Column(name = "email")
   private String userEmail;
    @Column(name = "address")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
