package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.configs.security.UserDetails;
import org.example.domains.Card;
import org.example.domains.Product;
import org.example.repository.CardRepository;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 15/10/22 02:37 (Saturday)
 * e-commerce-shopping/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final ProductRepository productRepository;

    public void create(Long id, UserDetails userDetails) {
        Product product = productRepository.findById(id).orElse(new Product());

        List<Card> cards = cardRepository.findByUserId(userDetails.getUser().getId());
        for (Card card : cards) {
            if (card.getProductName().equals(product.getName())){
                card.setAmount(card.getAmount()+1);
                card.setTotal(card.getPrice()*card.getAmount());
                cardRepository.save(card);
                return;
            }
        }

        Card card = Card.builder()
                .productName(product.getName())
                .productColor(product.getColor())
                .price(product.getPrice())
                .user_id(userDetails.getUser().getId())
                .amount(1)
                .total(product.getPrice()*1)
                .productCoverGeneratedName(product.getCover().getGeneratedName())
                .build();

        cardRepository.save(card);
    }

    public void buy(UserDetails userDetails) {
        cardRepository.deleteByUserId(userDetails.getUser().getId());

    }
}

