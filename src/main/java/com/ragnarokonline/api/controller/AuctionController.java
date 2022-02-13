package com.ragnarokonline.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.AuctionModel;
import com.ragnarokonline.api.repository.AuctionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1/auctions/")
@CrossOrigin(origins = { "http://localhost:3000", "http://snorlaxx-server.ddns.net:3000" })
public class AuctionController {
    
    @Autowired
    AuctionRepository auctionRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAuctions() {
        List<AuctionModel> response = auctionRepository.findAll();
        if (response.isEmpty()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve auction from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
        
    }

    @GetMapping("/{auction_id}")
    public ResponseEntity<?> getAuctionById(@PathVariable int auction_id) {
        AuctionModel response = auctionRepository.findById(auction_id).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve auction from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/sellername/{sellerName}")
    public ResponseEntity<?> getAuctionBySellerName(@PathVariable String sellerName) {
        AuctionModel response = auctionRepository.getAuctionBySellerName(sellerName).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve auction from the db with sellerName");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/buyername/{buyerName}")
    public ResponseEntity<?> getAuctionByBuyerName(@PathVariable String buyerName) {
        AuctionModel response = auctionRepository.getAuctionByBuyerName(buyerName).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve auction from the db with buyerName");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveAuction(@RequestBody AuctionModel auction) {
        try {
            auctionRepository.save(auction);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully added auction to db");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{auction_id}")
    public ResponseEntity<?> updateAuctionById(@PathVariable int auction_id, @RequestBody AuctionModel auction) {
        try {
            Optional<AuctionModel> response = auctionRepository.findById(auction_id);
            if (response == null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("statusCode", "400");
                map.put("status", "BAD REQUEST");
                map.put("message", "API Message: Failed to find auction based on auction id from the db");
                return ResponseEntity.badRequest().body(map);
            } else {
                AuctionModel auctionData = response.get();
                if (auction.getAttribute() != 0) {
                    auctionData.setAttribute(auction.getAttribute());
                }
                if (auction.getBuyer_id() != 0) {
                    auctionData.setBuyer_id(auction.getBuyer_id());
                }
                if (auction.getBuynow() != 0) {
                    auctionData.setBuynow(auction.getBuynow());
                }
                if (auction.getCard0() != 0) {
                    auctionData.setCard0(auction.getCard0());
                }
                if (auction.getCard1() != 0) {
                    auctionData.setCard1(auction.getCard1());
                }
                if (auction.getCard2() != 0) {
                    auctionData.setCard2(auction.getCard2());
                }
                if (auction.getCard3() != 0) {
                    auctionData.setCard3(auction.getCard3());
                }
                if (auction.getEnchantgrade() != 0) {
                    auctionData.setEnchantgrade(auction.getEnchantgrade());
                }
                if (auction.getHours() != 0) {
                    auctionData.setHours(auction.getHours());
                }
                if (auction.getItem_name() != null) {
                    auctionData.setItem_name(auction.getItem_name());
                }
                if (auction.getNameid() != 0) {
                    auctionData.setNameid(auction.getNameid());
                }
                if (auction.getOption_id0() != 0) {
                    auctionData.setOption_id0(auction.getOption_id0());
                }
                if (auction.getOption_id1() != 0) {
                    auctionData.setOption_id1(auction.getOption_id1());
                }
                if (auction.getOption_id2() != 0) {
                    auctionData.setOption_id2(auction.getOption_id2());
                }
                if (auction.getOption_id3() != 0) {
                    auctionData.setOption_id3(auction.getOption_id3());
                }
                if (auction.getOption_id4() != 0) {
                    auctionData.setOption_id4(auction.getOption_id4());
                }
                if (auction.getOption_parm0() != 0) {
                    auctionData.setOption_id0(auction.getOption_parm0());
                }
                if (auction.getOption_parm1() != 0) {
                    auctionData.setOption_parm1(auction.getOption_parm1());
                }
                if (auction.getOption_parm2() != 0) {
                    auctionData.setOption_parm2(auction.getOption_id2());
                }
                if (auction.getOption_parm3() != 0) {
                    auctionData.setOption_parm3(auction.getOption_parm3());
                }
                if (auction.getOption_parm4() != 0) {
                    auctionData.setOption_parm4(auction.getOption_parm4());
                }
                if (auction.getOption_val0() != 0) {
                    auctionData.setOption_val0(auction.getOption_val0());
                }
                if (auction.getOption_val1() != 0) {
                    auctionData.setOption_val1(auction.getOption_val1());
                }
                if (auction.getOption_val2() != 0) {
                    auctionData.setOption_val2(auction.getOption_val2());
                }
                if (auction.getOption_val3() != 0) {
                    auctionData.setOption_val3(auction.getOption_val3());
                }
                if (auction.getOption_val4() != 0) {
                    auctionData.setOption_val4(auction.getOption_val4());
                }
                if (auction.getPrice() != 0) {
                    auctionData.setPrice(auction.getPrice());
                }
                if (auction.getRefine() != 0) {
                    auctionData.setRefine(auction.getRefine());
                }
                if (auction.getSeller_id() != 0) {
                    auctionData.setSeller_id(auction.getSeller_id());
                }
                if (auction.getTimestamp() != 0) {
                    auctionData.setTimestamp(auction.getTimestamp());
                }
                if (auction.getType() != 0) {
                    auctionData.setType(auction.getType());
                }
                if (auction.getUnique_id() != 0) {
                    auctionData.setUnique_id(auction.getUnique_id());
                }
                if (auction.getbuyerName() != null) {
                    auctionData.setbuyerName(auction.getbuyerName());
                }
                if (auction.getsellerName() != null) {
                    auctionData.setsellerName(auction.getsellerName());
                }
                try {
                    auctionRepository.save(auctionData);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("statusCode", "200");
                    map.put("status", "SUCCESSFUL");
                    map.put("message", "API Message: Successfully updated auction details in the db");
                    return ResponseEntity.ok(map);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(e);
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{auction_id}")
    public ResponseEntity<?> deleteAuctionById(@PathVariable int auction_id) {
        try {
            auctionRepository.deleteById(auction_id);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted auction");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to delete auction with auction_id");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllAuctions() {
        try {
            auctionRepository.deleteAll();
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted all auctions");
            return ResponseEntity.ok(map);

        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to all auctions");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }
}
