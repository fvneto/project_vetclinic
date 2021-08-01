package com.fvneto.vetclinic;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fvneto.vetclinic.enums.EspecieEnum;
import com.fvneto.vetclinic.model.Animal;
import com.fvneto.vetclinic.model.Tutor;

@SpringBootTest
@AutoConfigureMockMvc
public class TutorResourceTeste {						

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	//----------------------------------------
    //	           Testes de Sucesso
    //----------------------------------------
	@Test
	public void deveRetornarSucesso_QuandoListarTodosOstutores() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/tutores"))
				.andDo(print())
			    .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
    public void   deveRetornarSucesso_QuandoBuscarTutorPeloId () throws Exception {
		
        mockMvc.perform(MockMvcRequestBuilders
        		.get("/tutores/{id}", 1L))
        		.andDo(print())
        		.andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
	public void deveRetornarSucesso_QuandoCriarNovotutor () throws Exception {
		
		Animal animalTeste = new Animal();
		animalTeste.setId(1L);
		animalTeste.setNome("Toto");
		animalTeste.setEspecie(EspecieEnum.CANINO);
		animalTeste.setRaca("desconhecida");
		animalTeste.setDatanascimento(LocalDate.now());

		Tutor tutorASalvar = new Tutor(1L, "Edson", "8888- 8888", "edmilson@gmail.com", animalTeste);

        mockMvc.perform(MockMvcRequestBuilders
        		.post("/tutores")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(objectMapper.writeValueAsString(tutorASalvar)))
                .andDo(print())
        		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void deveRetornarSucesso_QuandoAtualizartutor () throws Exception {
		
		Animal animalTeste = new Animal();
		animalTeste.setId(1L);
		animalTeste.setNome("Toto");
		animalTeste.setEspecie(EspecieEnum.CANINO);
		animalTeste.setRaca("desconhecida");
		animalTeste.setDatanascimento(LocalDate.now());

		Tutor tutorASalvar = new Tutor(1L, "Edson", "8888- 8888", "edmilson@gmail.com", animalTeste);

        mockMvc.perform(MockMvcRequestBuilders
        		.post("/tutores")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(objectMapper.writeValueAsString(tutorASalvar)))
                .andDo(print())
        		.andExpect(MockMvcResultMatchers.status().isCreated());
	}	
	

    //----------------------------------------
    //	           Testes de ERRO
    //----------------------------------------
 
	@Test
    public void deveRetornarErroNotFoun_QuandoBuscarTutorPeloIdInexistente () throws Exception {
		
        mockMvc.perform(MockMvcRequestBuilders
        		.get("/tutores/{id}", 10L))
        		.andDo(print())
        		.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
	
	@Test
	public void deveRetornarErroBadResquest_QuandoCriarNovotutorSemTelefone () throws Exception {
		
		Animal animalTeste = new Animal();
		animalTeste.setId(1L);
		animalTeste.setNome("Toto");
		animalTeste.setEspecie(EspecieEnum.CANINO);
		animalTeste.setRaca("desconhecida");
		animalTeste.setDatanascimento(LocalDate.now());

		Tutor tutorASalvar = new Tutor(1L, "Edson", null, "edmilson@gmail.com", animalTeste);

        mockMvc.perform(MockMvcRequestBuilders
        		.post("/tutores")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(objectMapper.writeValueAsString(tutorASalvar)))
                .andDo(print())
        		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	
}
