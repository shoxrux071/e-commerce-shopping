package org.example.domains;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productColor;

    @Column(nullable = false)
    private String productCoverGeneratedName;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private Long user_id;

}
