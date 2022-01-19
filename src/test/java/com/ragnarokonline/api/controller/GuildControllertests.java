package com.ragnarokonline.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.GuildModel;
import com.ragnarokonline.api.repository.GuildRepository;

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

@WebMvcTest(controllers = GuildController.class)
public class GuildControllertests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GuildRepository guildRepository;

    @Test
    public void getGuilds() throws Exception {
        List<GuildModel> response = new ArrayList<>();
        response.add(new GuildModel(1, "name", 1500000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null));
        Mockito.when(this.guildRepository.findAll()).thenReturn(response);
        mockMvc.perform(get("/v1/guilds/"))
        .andExpect(content().string(containsString("\"master\":\"master\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getGuildsFail() throws Exception {
        mockMvc.perform(get("/v1/guilds/"))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Failed to retrieve guilds from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getGuildById() throws Exception {
        Mockito.when(this.guildRepository.findById(anyInt())).thenReturn(Optional.of(new GuildModel(1, "name", 1500000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null)));
        mockMvc.perform(get("/v1/guilds/guildid/{guild_id}", 1))
        .andExpect(content().string(containsString("\"master\":\"master\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getGuildByIdFail() throws Exception {
        mockMvc.perform(get("/v1/guilds/guildid/{guild_id}", 1))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Failed to retrieve guild from the db with id\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }
    
    @Test
    public void getGuildByName() throws Exception {
        Mockito.when(this.guildRepository.getGuildByName(anyString())).thenReturn(Optional.of(new GuildModel(1, "name", 1500000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null)));
        mockMvc.perform(get("/v1/guilds/guildname/{name}", "name"))
        .andExpect(content().string(containsString("\"master\":\"master\"")))
        .andExpect(status().isOk());
    }
    
    @Test
    public void getGuildByNameFail() throws Exception {
        mockMvc.perform(get("/v1/guilds/guildname/{name}", "name"))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Failed to retrieve guild from the db with name\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getGuildByCharId() throws Exception {
        Mockito.when(this.guildRepository.getGuildByCharId(anyInt())).thenReturn(Optional.of(new GuildModel(1, "name", 150000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null)));
        mockMvc.perform(get("/v1/guilds/character/{charId}", 150000))
        .andExpect(content().string(containsString("\"master\":\"master\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getGuildByCharIdFail() throws Exception {
        mockMvc.perform(get("/v1/guilds/character/{charId}", 150000))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Failed to retrieve guild from the db with charId\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getGuildByMaster() throws Exception {
        Mockito.when(this.guildRepository.getGuildByMaster(anyString())).thenReturn(Optional.of(new GuildModel(1, "name", 150000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null)));
        mockMvc.perform(get("/v1/guilds/master/{master}", "master"))
        .andExpect(content().string(containsString("\"master\":\"master\"")));
    }

    @Test
    public void getGuildByMasterFail() throws Exception {
        mockMvc.perform(get("/v1/guilds/master/{master}", "master"))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Failed to retrieve guild from the db with master\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void saveGuild() throws Exception {
        Mockito.when(this.guildRepository.save(any(GuildModel.class))).thenReturn(new GuildModel(1, "name", 150000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null));
        mockMvc.perform(post("/v1/guilds/new/"))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Successfully added guild to db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void saveGuildFail() throws Exception {
        Mockito.when(this.guildRepository.save(any(GuildModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(post("/v1/guilds/new/"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateGuildById() throws Exception {
        Mockito.when(this.guildRepository.findById(anyInt())).thenReturn(Optional.of(new GuildModel(1, "name", 150000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null)));
        Mockito.when(this.guildRepository.save(any(GuildModel.class))).thenReturn(new GuildModel(1, "name", 150000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null));
        mockMvc.perform(put("/v1/guilds/update/{guild_id}", 1))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Successfully updated guild details in the db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void updateGuildByIdFindByIdFail() throws Exception {
        Mockito.when(this.guildRepository.findById(anyInt())).thenReturn(null);
        mockMvc.perform(put("/v1/guilds/update/{guild_id}", 1))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Failed to find guild based on guild id from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateGuildByIdSaveFail() throws Exception {
        Mockito.when(this.guildRepository.findById(anyInt())).thenReturn(Optional.of(new GuildModel(1, "name", 150000, "master", 0, 0, 0, 0, 0, 0, 0, "mes1", "mes2", 0, 0, null, null)));
        Mockito.when(this.guildRepository.save(any(GuildModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/guilds/update/{guild_id}", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateGuildByIdFail() throws Exception {
        Mockito.when(this.guildRepository.save(any(GuildModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/guilds/update/{guild_id}", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteGuildById() throws Exception {
        mockMvc.perform(delete("/v1/guilds/{guild}/", 1))
        .andExpect(content().string(containsString("{\"message\":\"API Message: Successfully deleted guild\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteAllGuilds() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.guildRepository).deleteAll();
        mockMvc.perform(delete("/v1/guilds/"))
        .andExpect(status().isBadRequest());
    }
}
