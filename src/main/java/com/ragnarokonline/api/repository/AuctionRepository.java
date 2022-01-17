package com.ragnarokonline.api.repository;

import java.util.Optional;

import com.ragnarokonline.api.model.AuctionModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<AuctionModel, Integer> {
    Optional<AuctionModel> getAuctionBySellerName(String sellerName);
    Optional<AuctionModel> getAuctionByBuyerName(String buyerName);
}
