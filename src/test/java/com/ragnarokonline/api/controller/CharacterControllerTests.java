package com.ragnarokonline.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.CharacterModel;
import com.ragnarokonline.api.repository.CharacterRepository;

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

@WebMvcTest(controllers = CharacterController.class)
public class CharacterControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CharacterRepository characterRepository;

    @Test
    public void getCharacters() throws Exception {
        List<CharacterModel> response = new ArrayList<>();
        response.add(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0));
        Mockito.when(this.characterRepository.findAll()).thenReturn(response);
        mockMvc.perform(get("/v1/characters/"))
        .andExpect(content().string(containsString("\"name\":\"name\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getCharactersFail() throws Exception {
        mockMvc.perform(get("/v1/characters/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve characters from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getCharactersById() throws Exception {
        Mockito.when(this.characterRepository.findById(anyInt())).thenReturn(Optional.of(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0)));
        mockMvc.perform(get("/v1/characters/{char_id}", 1))
        .andExpect(content().string(containsString("\"name\":\"name\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getCharactersByIdFail() throws Exception {
        mockMvc.perform(get("/v1/characters/{char_id}", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve character from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getCharacterByName() throws Exception {
        Mockito.when(this.characterRepository.getCharacterByName(anyString())).thenReturn(Optional.of(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0)));
        mockMvc.perform(get("/v1/characters/name/{name}", "name"))
        .andExpect(content().string(containsString("\"name\":\"name\"")))
        .andExpect(status().isOk());
    }

    @Test
    public void getCharacterByNameFail() throws Exception {
        mockMvc.perform(get("/v1/characters/name/{name}", "name"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve character from the db with name\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void saveCharacter() throws Exception {
        Mockito.when(this.characterRepository.save(any(CharacterModel.class))).thenReturn(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0));
        mockMvc.perform(post("/v1/characters/new/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully added character to db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void saveCharacterFail() throws Exception {
        Mockito.when(this.characterRepository.save(any(CharacterModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(post("/v1/characters/new/"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateCharacterById() throws Exception {
        Mockito.when(this.characterRepository.findById(anyInt())).thenReturn(Optional.of(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0)));
        Mockito.when(this.characterRepository.save(any(CharacterModel.class))).thenReturn(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0));
        mockMvc.perform(put("/v1/characters/{char_id}/", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully updated character details in the db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void updateCharacterByIdfindByIdFail() throws Exception {
        Mockito.when(this.characterRepository.findById(anyInt())).thenReturn(null);
        mockMvc.perform(put("/v1/characters/{char_id}/", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to find character based on character id from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateCharacterByIdSaveFail() throws Exception {
        Mockito.when(this.characterRepository.findById(anyInt())).thenReturn(Optional.of(new CharacterModel(1, 2000000, 1, "name", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "last_map", 0, 0, "save_map", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "M", 0, 9, 0, null, 0, 0)));
        Mockito.when(this.characterRepository.save(any(CharacterModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/characters/{char_id}/", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateCharacterByIdFail() throws Exception {
        Mockito.when(this.characterRepository.findById(anyInt())).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/characters/{char_id}/", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteCharacterById() throws Exception {
        // Mockito.when(this.auctionRepository.deleteById(1)).thenReturn(null);
        mockMvc.perform(delete("/v1/characters/{char_id}/", 1))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Sucessfully deleted character\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteCharacterByIdFail() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.characterRepository).deleteById(1);
        // Mockito.when(this.auctionRepository.deleteById(1)).thenThrow(new RuntimeException());
        mockMvc.perform(delete("/v1/characters/{char_id}/", 1))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteAllCharacters() throws Exception {
        mockMvc.perform(delete("/v1/characters/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Sucessfully deleted all characters\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteAllCharactersFail() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.characterRepository).deleteAll();
        mockMvc.perform(delete("/v1/characters/"))
        .andExpect(status().isBadRequest());
    }
}
