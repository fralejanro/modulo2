package com.sophossolutions.modulo2;

import com.sophossolutions.modulo2.models.Band;
import com.sophossolutions.modulo2.services.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Modulo2Application implements CommandLineRunner {
	private final KafkaProducerService kafkaProducerService;

	public Modulo2Application(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Modulo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		producerData();
	}

	private void producerData(){
		Band band1 = Band.builder()
				.id(1)
				.name("Grito")
				.genre("Hardcore Punk")
				.countryOfOrigin("Colombia")
				.yearOfCreation(1999)
				.status(Boolean.TRUE).build();

		Band band2 = Band.builder()
				.id(1)
				.name("Contrarresto No Violento")
				.genre("Hardcore Punk")
				.countryOfOrigin("Colombia")
				.yearOfCreation(2004)
				.status(Boolean.TRUE).build();
		String topico = "Bands-2023-9";
		kafkaProducerService.sendKey(topico, band1.getId(), band1);
		kafkaProducerService.sendKey(topico, band2.getId(), band2);
	}
}
