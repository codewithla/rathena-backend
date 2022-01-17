package com.ragnarokonline.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.AuctionModel;
import com.ragnarokonline.api.repository.AuctionRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuctionController.class)
public class AuctionTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuctionRepository auctionRepository;

    @Test
    public void getAuctions() throws Exception {
        List<AuctionModel> response = new ArrayList<>();
        response.add(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        Mockito.when(this.auctionRepository.findAll()).thenReturn(response);
        mockMvc.perform(get("/v1/auctions/"))
        .andExpect(content().string(containsString("\"auction_id\":1")))
        .andExpect(status().isOk());
    }

    @Test
    public void getAuctionsFail() throws Exception {
        mockMvc.perform(get("/v1/auctions/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve auction from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getAuctionById() throws Exception {
        Mockito.when(this.auctionRepository.findById(anyInt())).thenReturn(Optional.of(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        mockMvc.perform(get("/v1/auctions/{auction_id}", 1))
        .andExpect(content().string(containsString("\"auction_id\":1")))
        .andExpect(status().isOk());
    }

    @Test
    public void getAuctionByIdFail() throws Exception {
        mockMvc.perform(get("/v1/auctions/{auction_id}", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve auction from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getAuctionBySellerName() throws Exception {
        Mockito.when(this.auctionRepository.getAuctionBySellerName(anyString())).thenReturn(Optional.of(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        mockMvc.perform(get("/v1/auctions/sellername/{sellerName}", "sellerName"))
        .andExpect(content().string(containsString("\"sellerName\":\"sellerName\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getAuctionBySellerNameFail() throws Exception {
        mockMvc.perform(get("/v1/auctions/sellername/{sellerName}", "sellerName"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve auction from the db with sellerName\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getAuctionByBuyerName() throws Exception {
        Mockito.when(this.auctionRepository.getAuctionByBuyerName(anyString())).thenReturn(Optional.of(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        mockMvc.perform(get("/v1/auctions/buyername/{buyerName}", "buyerName"))
        .andExpect(content().string(containsString("\"buyerName\":\"buyerName\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getAuctionByBuyerNameFail() throws Exception {
        mockMvc.perform(get("/v1/auctions/buyername/{buyerName}", "buyerName"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve auction from the db with buyerName\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void saveAuction() throws Exception {
        Mockito.when(this.auctionRepository.save(any(AuctionModel.class))).thenReturn(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        mockMvc.perform(post("/v1/auctions/new/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully added auction to db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void saveAuctionFail() throws Exception {
        Mockito.when(this.auctionRepository.save(any(AuctionModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(post("/v1/auctions/new/"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateAuctionsById() throws Exception {
        Mockito.when(this.auctionRepository.findById(anyInt())).thenReturn(Optional.of(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        Mockito.when(this.auctionRepository.save(any(AuctionModel.class))).thenReturn(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        mockMvc.perform(put("/v1/auctions/{auction_id}/", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully updated auction details in the db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void updateAuctionsByIdfindByIdFail() throws Exception {
        Mockito.when(this.auctionRepository.findById(anyInt())).thenReturn(null);
        // Mockito.when(this.auctionRepository.save(any(LoginModel.class))).thenReturn(new LoginModel(1, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0));
        mockMvc.perform(put("/v1/auctions/{auction_id}/", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to find auction based on auction id from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateAuctionsByIdSaveFail() throws Exception {
        Mockito.when(this.auctionRepository.findById(anyInt())).thenReturn(Optional.of(new AuctionModel(1, 1, "sellerName", 1, "buyerName", 1, 1, 1, 1, 1, "item_name", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
        Mockito.when(this.auctionRepository.save(any(AuctionModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/auctions/{auction_id}/", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateAuctionsByIdFail() throws Exception {
        Mockito.when(this.auctionRepository.findById(anyInt())).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/auctions/{auction_id}/", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteAuctionById() throws Exception {
        // Mockito.when(this.auctionRepository.deleteById(1)).thenReturn(null);
        mockMvc.perform(delete("/v1/auctions/{auction_id}/", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Sucessfully deleted auction\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteAuctionByIdFail() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.auctionRepository).deleteById(1);
        // Mockito.when(this.auctionRepository.deleteById(1)).thenThrow(new RuntimeException());
        mockMvc.perform(delete("/v1/auctions/{auction_id}/", 1))
        // .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully updated auction details in the db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteAllAuctions() throws Exception {
        mockMvc.perform(delete("/v1/auctions/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Sucessfully deleted all auctions\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteAllAuctionsFail() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.auctionRepository).deleteAll();
        mockMvc.perform(delete("/v1/auctions/"))
        .andExpect(status().isBadRequest());
    }
}