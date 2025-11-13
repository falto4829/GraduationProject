package com.qaima.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exchange")
@Getter
@NoArgsConstructor
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exchangeId;

    @Column(nullable = false, unique = true, length = 20)
    private String code;      // KRX, NASDAQ

    @Column(nullable = false, length = 2)
    private String country;   // KR, US

    private String name;
    private String timezone;
}

