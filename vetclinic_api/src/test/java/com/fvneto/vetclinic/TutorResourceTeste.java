package com.fvneto.vetclinic;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fvneto.vetclinic.enums.EspecieEnum;
import com.fvneto.vetclinic.model.Animal;
import com.fvneto.vetclinic.model.Tutor;

@SpringBootTest
@AutoConfigureMockMvc
public class TutorResourceTeste {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void bookingTestGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tutores"))
			   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
    public void bookingTestSave() throws Exception {

		Animal animalTeste = new Animal();
		animalTeste.setId(1L);
		animalTeste.setNome("Teste");
		animalTeste.setEspecie(EspecieEnum.CANINO);
		animalTeste.setRaca("raca");
		animalTeste.setDatanascimento(LocalDate.now());

        Tutor tutorModel = new Tutor(1l, "Edson", "8888- 8888", "edmilson@gmail.com", animalTeste);

        mockMvc.perform(MockMvcRequestBuilders.get("/tutores/{id}", tutorModel.getId()))
        		.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
