package com.example.LinkDB;

import com.example.LinkDB.doa.AnimeDao;
import com.example.LinkDB.entity.Anime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.CancellationException;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@SpringBootApplication
public class LinkDbApplication {
	public static void main(String[] args) {
		SpringApplication.run(LinkDbApplication.class, args);
	}
		@Bean
	public CommandLineRunner cmdR(AnimeDao animeDao){
		return runner ->{
//			createAnime(animeDao);
//			readAnime(animeDao);
			queryAnime(animeDao);
//			upAnime(animeDao);
			delAnime(animeDao);
		};
		}

//	private void createAnime(AnimeDao animeDao) {
//		Anime a = new Anime("Naruto");
//		animeDao.save(a);
//	}


	private void delAnime(AnimeDao animeDao) {
		animeDao.delete(5);
	}

//	private void upAnime(AnimeDao animeDao) {
//		Anime anime = animeDao.findById(3);
//		anime.setName("kyukyu");
//		animeDao.update(anime);
//		System.out.println("up " +  anime);
//	}

	private void queryAnime(AnimeDao animeDao) {
		List<Anime> anime = animeDao.findAll();
		for(Anime name : anime){
			System.out.println(name);
		}
	}
//	private void readAnime(AnimeDao animeDao) {
//		System.out.println(animeDao.findById(1));
//	}
}