package com.ragnarokonline.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.CharacterModel;
import com.ragnarokonline.api.repository.CharacterRepository;

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
@RequestMapping("/v1/characters/")
@CrossOrigin(origins = { "http://localhost:3000", "http://snorlaxx-server.ddns.net:3000" })
public class CharacterController {
    
    @Autowired
    CharacterRepository characterRepository;

    @GetMapping("/")
    public ResponseEntity<?> getCharacters() {
        List<CharacterModel> response = characterRepository.findAll();
        if (response.isEmpty()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve characters from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{char_id}")
    public ResponseEntity<?> getCharacterById(@PathVariable int char_id) {
        CharacterModel response = characterRepository.findById(char_id).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve character from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getCharacterByName(@PathVariable String name) {
        CharacterModel response = characterRepository.getCharacterByName(name).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve character from the db with name");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveCharacter(@RequestBody CharacterModel character) {
        try {
            System.out.println(character.toString());
            System.out.println(characterRepository.save(character));
            characterRepository.save(character);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully added character to db");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{char_id}")
    public ResponseEntity<?> updateCharacterById(@PathVariable int char_id, @RequestBody CharacterModel character) {
        try {
            Optional<CharacterModel> response = characterRepository.findById(char_id);
            if (response == null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("statusCode", "400");
                map.put("status", "BAD REQUEST");
                map.put("message", "API Message: Failed to find character based on character id from the db");
                return ResponseEntity.badRequest().body(map);
            } else {
                CharacterModel characterData = response.get();
                if (character.getAgi() != 0) {
                    characterData.setAgi(character.getAgi());
                }
                if (character.getBase_exp() != 0) {
                    characterData.setBase_exp(character.getBase_exp());
                }
                if (character.getBase_level() != 0) {
                    characterData.setBase_level(character.getBase_level());
                }
                if (character.getBody() != 0) {
                    characterData.setBody(character.getBody());
                }
                if (character.getCharClass() != 0) {
                    characterData.setCharClass(character.getCharClass());
                }
                if (character.getChar_id() != 0) {
                    characterData.setChar_id(character.getChar_id());
                }
                if (character.getChar_num() != 0) {
                    characterData.setChar_num(character.getChar_num());
                }
                if (character.getChild() != 0) {
                    characterData.setChild(character.getChild());
                }
                if (character.getClan_id() != 0) {
                    characterData.setClan_id(character.getClan_id());
                }
                if (character.getCharClass() != 0) {
                    characterData.setCharClass(character.getCharClass());
                }
                if (character.getClothes_color() != 0) {
                    characterData.setClothes_color(character.getClothes_color());
                }
                if (character.getDelete_date() != 0) {
                    characterData.setDelete_date(character.getDelete_date());
                }
                if (character.getDex() != 0) {
                    characterData.setDex(character.getDex());
                }
                if (character.getElemental_id() != 0) {
                    characterData.setElemental_id(character.getElemental_id());
                }
                if (character.getFame() != 0) {
                    characterData.setFame(character.getFame());
                }
                if (character.getFather() != 0) {
                    characterData.setFather(character.getFather());
                }
                if (character.getFont() != 0) {
                    characterData.setFont(character.getFont());
                }
                if (character.getGuild_id() != 0) {
                    characterData.setGuild_id(character.getGuild_id());
                }
                if (character.getHair() != 0){
                    characterData.setHair(character.getHair());
                }
                if (character.getHair_color() != 0) {
                    characterData.setHair_color(character.getHair_color());
                }
                if (character.getHead_bottom() != 0) {
                    characterData.setHead_bottom(character.getHead_bottom());
                }
                if (character.getHead_mid() != 0) {
                    characterData.setHead_mid(character.getHead_mid());
                }
                if (character.getHead_top() != 0) {
                    characterData.setHead_top(character.getHead_top());
                }
                if (character.getHotkey_rowshift() != 0) {
                    characterData.setHotkey_rowshift(character.getHotkey_rowshift());
                }
                if (character.getHotkey_rowshift2() != 0) {
                    characterData.setHotkey_rowshift2(character.getHotkey_rowshift2());
                }
                if (character.getHp() != 0) {
                    characterData.setHp(character.getHp());
                }
                if (character.getJob_exp() != 0) {
                    characterData.setJob_exp(character.getJob_exp());
                }
                if (character.getJob_level() != 0) {
                    characterData.setJob_level(character.getJob_level());
                }
                if (character.getKarma() != 0) {
                    characterData.setKarma(character.getKarma());
                }
                if (character.getLast_x() != 0) {
                    characterData.setLast_x(character.getLast_x());
                }
                if (character.getLast_y() != 0) {
                    characterData.setLast_y(character.getLast_y());
                }
                if (character.getLuk() != 0) {
                    characterData.setLuk(character.getLuk());
                }
                if (character.getManner() != 0) {
                    characterData.setManner(character.getManner());
                }
                if (character.getMax_hp() != 0) {
                    characterData.setMax_hp(character.getMax_hp());
                }
                if (character.getMax_sp() != 0) {
                    characterData.setMax_sp(character.getMax_sp());
                }
                if (character.getMother() != 0) {
                    characterData.setMother(character.getMother());
                }
                if (character.getMoves() != 0) {
                    characterData.setMoves(character.getMoves());
                }
                if (character.getName() != null) {
                    characterData.setName(character.getName());
                }
                if (character.getOnline() != 0) {
                    characterData.setOnline(character.getOnline());
                }
                if (character.getOption() != 0) {
                    characterData.setOption(character.getOption());
                }
                if (character.getPartner_id() != 0) {
                    characterData.setPartner_id(character.getPartner_id());
                }
                if (character.getParty_id() != 0) {
                    characterData.setParty_id(character.getParty_id());
                }
                if (character.getPet_id() != 0) {
                    characterData.setPet_id(character.getPet_id());
                }
                if (character.getRename() != 0) {
                    characterData.setRename(character.getRename());
                }
                if (character.getRobe() != 0) {
                    characterData.setRobe(character.getRobe());
                }
                if (character.getSave_map() != null) {
                    characterData.setSave_map(character.getSave_map());
                }
                if (character.getSave_x() != 0) {
                    characterData.setSave_x(character.getSave_x());
                }
                if (character.getSave_y() != 0) {
                    characterData.setSave_y(character.getSave_y());
                }
                if (character.getSex() != null) {
                    characterData.setSex(character.getSex());
                }
                if (character.getShield() != 0) {
                    characterData.setShield(character.getShield());
                }
                if (character.getShow_equip() != 0) {
                    characterData.setShow_equip(character.getShow_equip());
                }
                if (character.getSkill_point() != 0) {
                    characterData.setSkill_point(character.getSkill_point());
                }
                if (character.getSp() != 0) {
                    characterData.setSp(character.getSp());
                }
                if (character.getStatus_point() != 0) {
                    characterData.setStatus_point(character.getStatus_point());
                }
                if (character.getStr() != 0){
                    characterData.setStr(character.getStr());
                }
                if (character.getTitle_id() != 0) {
                    characterData.setTitle_id(character.getTitle_id());
                }
                if (character.getUnban_time() != 0) {
                    characterData.setUnban_time(character.getUnban_time());
                }
                if (character.getUniqueitem_counter() != 0) {
                    characterData.setUniqueitem_counter(character.getUniqueitem_counter());
                }
                if (character.getVit() != 0) {
                    characterData.setVit(character.getVit());
                }
                if (character.getInte() != 0) {
                    characterData.setInte(character.getInte());
                }
                if (character.getWeapon() != 0) {
                    characterData.setWeapon(character.getWeapon());
                }
                if (character.getZeny() != 0) {
                    characterData.setZeny(character.getZeny());
                }
                try {
                    characterRepository.save(characterData);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("statusCode", "200");
                    map.put("status", "SUCCESSFUL");
                    map.put("message", "API Message: Successfully updated character details in the db");
                    return ResponseEntity.ok(map);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(e);
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{char_id}")
    public ResponseEntity<?> deleteCharacterById(@PathVariable int char_id) {
        try {
            characterRepository.deleteById(char_id);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted character");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to delete character with char_id");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllCharacter() {
        try {
            characterRepository.deleteAll();
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted all characters");
            return ResponseEntity.ok(map);

        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to all characters");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }
}
