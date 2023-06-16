package com.packt.modern.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@Table("ecomm.user")
public class UserEntity {
    @Id
    @Column("id")
    private UUID id;

    @NotNull(message = "User name is required.")
//    @Basic(optional = false)
    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Column("phone")
    private String phone;

    @Column("user_status")
    private String userStatus;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(
//            name = "USER_ADDRESS",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
//    )
//    private Flux<AddressEntity> addresses = Collections.emptyList();

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private CardEntity cards;

//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private CartEntity cart;

//    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<OrderEntity> orders;

    public UUID getId() {
        return id;
    }

    public UserEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public UserEntity setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }


    public CardEntity getCard() {
        return cards;
    }

    public UserEntity setCard(CardEntity card) {
        this.cards = card;
        return this;
    }

    public CartEntity getCart() {
        return cart;
    }

    public UserEntity setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }

}
