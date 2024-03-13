package br.com.jairorocha.leads.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdsInfo {
    @Id
    @Column(name = "id_ad_data")
    private Long id;

    @NotNull
    private Integer category;

    @Size(max = 255)
    private String subject;

    @Size(max = 1000)
    private String body;

    @Size(max = 50)
    private String type;

    @Size(max = 50)
    private String price;

    @Size(max = 50)
    private String zipcode;

    @Size(max = 50)
    private String regdate;

    @Size(max = 50)
    private String mileage;

    @Size(max = 50)
    private String carcolor;

    @Size(max = 50)
    private String fuel;

    @Size(max = 50)
    @JsonProperty("car_steering")
    private String carSteering;

    @Size(max = 50)
    private String exchange;

    @Size(max = 50)
    private String owner;

    @Size(max = 255)
    private String financial;

    @Size(max = 50)
    @JsonProperty("financial_status")
    private String financialStatus;

    @Size(max = 50)
    @JsonProperty("vehicle_brand")
    private String vehicleBrand;

    @Size(max = 50)
    @JsonProperty("vehicle_model")
    private String vehicleModel;

    @Size(max = 50)
    @JsonProperty("vehicle_version")
    private String vehicleVersion;

    @Size(max = 50)
    private String cubiccms;

    @Size(max = 255)
    @JsonProperty("moto_features")
    private String motoFeatures;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_ad_data")
    @JsonBackReference
    private Lead lead;
}
