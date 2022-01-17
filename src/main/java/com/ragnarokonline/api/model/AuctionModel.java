package com.ragnarokonline.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auction")
public class AuctionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auction_id;
    private int seller_id;
    @Column(name = "seller_name")
    private String sellerName;
    private int buyer_id;
    @Column(name = "buyer_name")
    private String buyerName;
    private int price;
    private int buynow;
    private int hours;
    private int timestamp;
    private int nameid;
    private String item_name;
    private int type;
    private int refine;
    private int attribute;
    private int card0;
    private int card1;
    private int card2;
    private int card3;
    private int option_id0;
    private int option_val0;
    private int option_parm0;
    private int option_id1;
    private int option_val1;
    private int option_parm1;
    private int option_id2;
    private int option_val2;
    private int option_parm2;
    private int option_id3;
    private int option_val3;
    private int option_parm3;
    private int option_id4;
    private int option_val4;
    private int option_parm4;
    private int unique_id;
    private int enchantgrade;

    public AuctionModel() {}

    public AuctionModel(int auction_id, int seller_id, String sellerName, int buyer_id, String buyerName, int price,
            int buynow, int hours, int timestamp, int nameid, String item_name, int type, int refine, int attribute,
            int card0, int card1, int card2, int card3, int option_id0, int option_val0, int option_parm0,
            int option_id1, int option_val1, int option_parm1, int option_id2, int option_val2, int option_parm2,
            int option_id3, int option_val3, int option_parm3, int option_id4, int option_val4, int option_parm4,
            int unique_id, int enchantgrade) {
        this.auction_id = auction_id;
        this.seller_id = seller_id;
        this.sellerName = sellerName;
        this.buyer_id = buyer_id;
        this.buyerName = buyerName;
        this.price = price;
        this.buynow = buynow;
        this.hours = hours;
        this.timestamp = timestamp;
        this.nameid = nameid;
        this.item_name = item_name;
        this.type = type;
        this.refine = refine;
        this.attribute = attribute;
        this.card0 = card0;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.option_id0 = option_id0;
        this.option_val0 = option_val0;
        this.option_parm0 = option_parm0;
        this.option_id1 = option_id1;
        this.option_val1 = option_val1;
        this.option_parm1 = option_parm1;
        this.option_id2 = option_id2;
        this.option_val2 = option_val2;
        this.option_parm2 = option_parm2;
        this.option_id3 = option_id3;
        this.option_val3 = option_val3;
        this.option_parm3 = option_parm3;
        this.option_id4 = option_id4;
        this.option_val4 = option_val4;
        this.option_parm4 = option_parm4;
        this.unique_id = unique_id;
        this.enchantgrade = enchantgrade;
    }
    public int getAuction_id() {
        return auction_id;
    }
    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
    public int getSeller_id() {
        return seller_id;
    }
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }
    public String getsellerName() {
        return sellerName;
    }
    public void setsellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public int getBuyer_id() {
        return buyer_id;
    }
    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }
    public String getbuyerName() {
        return buyerName;
    }
    public void setbuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getBuynow() {
        return buynow;
    }
    public void setBuynow(int buynow) {
        this.buynow = buynow;
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public int getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
    public int getNameid() {
        return nameid;
    }
    public void setNameid(int nameid) {
        this.nameid = nameid;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getRefine() {
        return refine;
    }
    public void setRefine(int refine) {
        this.refine = refine;
    }
    public int getAttribute() {
        return attribute;
    }
    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }
    public int getCard0() {
        return card0;
    }
    public void setCard0(int card0) {
        this.card0 = card0;
    }
    public int getCard1() {
        return card1;
    }
    public void setCard1(int card1) {
        this.card1 = card1;
    }
    public int getCard2() {
        return card2;
    }
    public void setCard2(int card2) {
        this.card2 = card2;
    }
    public int getCard3() {
        return card3;
    }
    public void setCard3(int card3) {
        this.card3 = card3;
    }
    public int getOption_id0() {
        return option_id0;
    }
    public void setOption_id0(int option_id0) {
        this.option_id0 = option_id0;
    }
    public int getOption_val0() {
        return option_val0;
    }
    public void setOption_val0(int option_val0) {
        this.option_val0 = option_val0;
    }
    public int getOption_parm0() {
        return option_parm0;
    }
    public void setOption_parm0(int option_parm0) {
        this.option_parm0 = option_parm0;
    }
    public int getOption_id1() {
        return option_id1;
    }
    public void setOption_id1(int option_id1) {
        this.option_id1 = option_id1;
    }
    public int getOption_val1() {
        return option_val1;
    }
    public void setOption_val1(int option_val1) {
        this.option_val1 = option_val1;
    }
    public int getOption_parm1() {
        return option_parm1;
    }
    public void setOption_parm1(int option_parm1) {
        this.option_parm1 = option_parm1;
    }
    public int getOption_id2() {
        return option_id2;
    }
    public void setOption_id2(int option_id2) {
        this.option_id2 = option_id2;
    }
    public int getOption_val2() {
        return option_val2;
    }
    public void setOption_val2(int option_val2) {
        this.option_val2 = option_val2;
    }
    public int getOption_parm2() {
        return option_parm2;
    }
    public void setOption_parm2(int option_parm2) {
        this.option_parm2 = option_parm2;
    }
    public int getOption_id3() {
        return option_id3;
    }
    public void setOption_id3(int option_id3) {
        this.option_id3 = option_id3;
    }
    public int getOption_val3() {
        return option_val3;
    }
    public void setOption_val3(int option_val3) {
        this.option_val3 = option_val3;
    }
    public int getOption_parm3() {
        return option_parm3;
    }
    public void setOption_parm3(int option_parm3) {
        this.option_parm3 = option_parm3;
    }
    public int getOption_id4() {
        return option_id4;
    }
    public void setOption_id4(int option_id4) {
        this.option_id4 = option_id4;
    }
    public int getOption_val4() {
        return option_val4;
    }
    public void setOption_val4(int option_val4) {
        this.option_val4 = option_val4;
    }
    public int getOption_parm4() {
        return option_parm4;
    }
    public void setOption_parm4(int option_parm4) {
        this.option_parm4 = option_parm4;
    }
    public int getUnique_id() {
        return unique_id;
    }
    public void setUnique_id(int unique_id) {
        this.unique_id = unique_id;
    }
    public int getEnchantgrade() {
        return enchantgrade;
    }
    public void setEnchantgrade(int enchantgrade) {
        this.enchantgrade = enchantgrade;
    }

    

}
