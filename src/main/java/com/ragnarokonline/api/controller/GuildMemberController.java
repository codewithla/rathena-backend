package com.ragnarokonline.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.GuildMemberModel;
import com.ragnarokonline.api.repository.GuildMemberRepository;

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
@RequestMapping("/v1/guild/member/")
@CrossOrigin(origins = { "http://localhost:3000", "http://snorlaxx-server.ddns.net:3000" })
public class GuildMemberController {

    @Autowired
    GuildMemberRepository guildMemberRepository;

    @GetMapping("/all/")
    public ResponseEntity<?> getGuildMembers() {
        List<GuildMemberModel> response = guildMemberRepository.findAll();
        if (response.isEmpty()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild members from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/byId/{guild_id}/")
    public ResponseEntity<?> getGuildMembersByGuildId(@PathVariable int guild_id) {
        GuildMemberModel response = guildMemberRepository.findById(guild_id).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild member from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/byCharId/{charId}")
    public ResponseEntity<?> getGuildInfoByCharId(@PathVariable int charId) {
        GuildMemberModel response = guildMemberRepository.getGuildMemberByCharId(charId).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild member from the db by charId");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/new/")
    public ResponseEntity<?> saveGuildMember(@RequestBody GuildMemberModel guildMember) {
        try {
            guildMemberRepository.save(guildMember);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully added guild member to db");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/byCharId/{charId}")
    public ResponseEntity<?> updateGuildMember(@PathVariable int charId, @RequestBody GuildMemberModel guildMember) {
        try {
            Optional<GuildMemberModel> response = guildMemberRepository.getGuildMemberByCharId(charId);
            if (response == null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("statusCode", "400");
                map.put("status", "BAD REQUEST");
                map.put("message", "API Message: Failed to find guild member based on char id from the db");
                return ResponseEntity.badRequest().body(map);
            } else {
                GuildMemberModel guildMembersData = response.get();
                if (guildMember.getCharId() != 0) {
                    guildMembersData.setCharId(guildMember.getCharId());
                }
                if (guildMember.getExp() != 0) {
                    guildMembersData.setExp(guildMember.getExp());
                }
                if (guildMember.getGuild_id() != 0) {
                    guildMembersData.setGuild_id(guildMember.getGuild_id());
                }
                if (guildMember.getPosition() != 0) {
                    guildMembersData.setPosition(guildMember.getPosition());
                }
                try {
                    guildMemberRepository.save(guildMembersData);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("statusCode", "200");
                    map.put("status", "SUCCESSFUL");
                    map.put("message", "API Message: Successfully guild members details in the db");
                    return ResponseEntity.ok(map);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(e);
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/deleteByCharId/{charId}")
    public ResponseEntity<?> deleteGuildMemberByCharId(@PathVariable int charId) {
        try {
            guildMemberRepository.deleteGuildMemberByCharId(charId);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted guild member");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to delete guild member with charId");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllGuildMembers() {
        try {
            guildMemberRepository.deleteAll();
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted all guild members");
            return ResponseEntity.ok(map);

        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to all guild members");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }
}
