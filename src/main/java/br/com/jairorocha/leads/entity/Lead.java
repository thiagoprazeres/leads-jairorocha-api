package br.com.jairorocha.leads.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String source;

    @Size(max = 255)
    private String adId;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String listId;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String linkAd;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Email
    @Size(max = 255)
    @Column(nullable = false)
    private String email;

    @Size(max = 255)
    private String phone;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String message;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private AdsInfo adsInfo;

    @Size(max = 255)
    private String externalId;
}
