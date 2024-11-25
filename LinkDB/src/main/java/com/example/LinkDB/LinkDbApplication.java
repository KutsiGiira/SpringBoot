package com.example.LinkDB;

import com.example.LinkDB.doa.AnimeDao;
import com.example.LinkDB.entity.Anime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LinkDbApplication {
	public static void main(String[] args) {
		SpringApplication.run(LinkDbApplication.class, args);
	}
		@Bean
	public CommandLineRunner cmdR(AnimeDao animeDao){
		return runner ->{
//			createAnime(animeDao);
			readAnime(animeDao);
		};
		}

//	private void createAnime(AnimeDao animeDao) {

//		System.out.println(a7.getId());
//	}

	private void readAnime(AnimeDao look) {
		Anime a0 = new Anime("kuzu");
		Anime a1 = new Anime("Vinland");
		Anime a2 = new Anime("jojo");
		look.save(a0);
		look.save(a1);
		look.save(a2);
		System.out.println(a2.getId());
		System.out.println(look.findById(a0.getId()));
		System.out.println(look.findById(a1.getId()));
		System.out.println(look.findById(a2.getId()));

	}
}