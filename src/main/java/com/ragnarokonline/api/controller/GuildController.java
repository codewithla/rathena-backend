package com.ragnarokonline.api.controller;

import com.ragnarokonline.api.model.GuildModel;
import com.ragnarokonline.api.repository.GuildRepository;

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

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/guilds/")
@CrossOrigin(origins = { "http://localhost:3000", "http://snorlaxx-server.ddns.net:3000" })
public class GuildController {

    @Autowired
    GuildRepository guildRepository;

    @GetMapping("/")
    public ResponseEntity<?> getGuilds() {
        List<GuildModel> response = guildRepository.findAll();
        if (response.isEmpty()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guilds from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/guildid/{guild_id}")
    public ResponseEntity<?> getGuildById(@PathVariable int guild_id) {
        GuildModel response = guildRepository.findById(guild_id).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild from the db with id");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/guildname/{name}")
    public ResponseEntity<?> getGuildByName(@PathVariable String name) {
        GuildModel response = guildRepository.getGuildByName(name).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild from the db with name");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/character/{charId}")
    public ResponseEntity<?> getGuildByCharId(@PathVariable int charId) {
        GuildModel response = guildRepository.getGuildByCharId(charId).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild from the db with charId");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/master/{master}")
    public ResponseEntity<?> getGuildByMaster(@PathVariable String master) {
        GuildModel response = guildRepository.getGuildByMaster(master).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to retrieve guild from the db with master");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveGuild(@RequestBody GuildModel guild) {
        try {
            guildRepository.save(guild);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully added guild to db");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{guild_id}")
    public ResponseEntity<?> updateGuildById(@PathVariable int guild_id, @RequestBody GuildModel guild) {
        try {
            Optional<GuildModel> resposne = guildRepository.findById(guild_id);
            if (resposne == null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("statusCode", "400");
                map.put("status", "BAD REQUEST");
                map.put("message", "API Message: Failed to find guild based on guild id from the db");
                return ResponseEntity.badRequest().body(map);
            } else {
                GuildModel guildData = resposne.get();
                if (guild.getAverage_lv() != 0) {
                    guildData.setAverage_lv(guild.getAverage_lv());
                }
                if (guild.getCharId() != 0) {
                    guildData.setCharId(guild.getCharId());
                }
                if (guild.getConnect_member() != 0) {
                    guildData.setConnect_member(guild.getConnect_member());
                }
                if (guild.getEmblem_data() != null) {
                    guildData.setEmblem_data(guild.getEmblem_data());
                }
                if (guild.getEmblem_len() != 0) {
                    guildData.setEmblem_len(guild.getEmblem_len());
                }
                if (guild.getEmblem_id() != 0) {
                    guildData.setEmblem_id(guild.getEmblem_id());
                }
                if (guild.getExp() != 0) {
                    guildData.setExp(guild.getExp());
                }
                if (guild.getGuild_id() != 0) {
                    guildData.setGuild_id(guild.getGuild_id());
                }
                if (guild.getGuild_lv() != 0) {
                    guildData.setGuild_lv(guild.getGuild_lv());
                }
                if (guild.getLast_master_change() != null) {
                    guildData.setLast_master_change(guild.getLast_master_change());
                }
                if (guild.getMaster() != null) {
                    guildData.setMaster(guild.getMaster());
                }
                if (guild.getMax_member() != 0) {
                    guildData.setMax_member(guild.getMax_member());
                }
                if (guild.getMes1() != null) {
                    guildData.setMes1(guild.getMes1());
                }
                if (guild.getMes2() != null) {
                    guildData.setMes2(guild.getMes2());
                }
                if (guild.getName() != null) {
                    guildData.setName(guild.getName());
                }
                if (guild.getNext_exp() != 0) {
                    guildData.setNext_exp(guild.getNext_exp());
                }
                if (guild.getSkill_point() != 0) {
                    guildData.setSkill_point(guild.getSkill_point());
                }
                try {
                    guildRepository.save(guildData);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("statusCode", "200");
                    map.put("status", "SUCCESSFUL");
                    map.put("message", "API Message: Successfully updated guild details in the db");
                    return ResponseEntity.ok(map);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(e);
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{guild_id}")
    public ResponseEntity<?> deleteGuildById(@PathVariable int guild_id) {
        try {
            guildRepository.deleteById(guild_id);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted guild");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to delete guild with guild_id");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllGuilds() {
        try {
            guildRepository.deleteAll();
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("message", "API Message: Successfully deleted all guilds");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("message", "API Message: Failed to all guilds");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }
}
