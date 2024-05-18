package tr.com.turksat;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.turksat.entity.Birim;
import tr.com.turksat.entity.Personel;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
class PersonelControllerTest {
	private final MockMvc mockMvc;
	private final ObjectMapper objectMapper;

	@Autowired
	public PersonelControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
		this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

	@Test
	public void testGetAllPersonel() throws Exception {
		mockMvc.perform(get("/api/personel")
						.with(httpBasic("turksat", "turksat-odev-uygulamasi")))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$").isNotEmpty());
	}

	@Test
	public void testGetPersonelById() throws Exception {
		mockMvc.perform(get("/api/personel/2")
						.with(httpBasic("turksat", "turksat-odev-uygulamasi")))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isNotEmpty());
	}

	@Test
	public void testAddPersonel() throws Exception {
		Personel personel = new Personel();
		personel.setAd("Ibrahim");
		personel.setSoyad("Kilic");
		personel.setTcKimlikNo("12345678901");
		personel.setDogumTarihi(LocalDate.of(1990, 2, 1));
		Birim birim = new Birim();
		birim.setId(1);
		personel.setBirim(birim);

		mockMvc.perform(post("/api/personel")
						.with(SecurityMockMvcRequestPostProcessors.httpBasic("turksat", "turksat-odev-uygulamasi"))
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(personel)))
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdatePersonel() throws Exception {
		Personel personel = new Personel();
		personel.setAd("Mehmet");
		personel.setDogumTarihi(LocalDate.of(1890, 5, 11));
		Birim birim = new Birim();
		birim.setId(2);
		personel.setBirim(birim);

		mockMvc.perform(put("/api/personel/2")
						.with(SecurityMockMvcRequestPostProcessors.httpBasic("turksat", "turksat-odev-uygulamasi"))
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(personel)))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeletePersonelById() throws Exception {
		mockMvc.perform(delete("/api/personel/14")
						.with(httpBasic("turksat", "turksat-odev-uygulamasi")))
				.andExpect(status().isOk());
	}
}

