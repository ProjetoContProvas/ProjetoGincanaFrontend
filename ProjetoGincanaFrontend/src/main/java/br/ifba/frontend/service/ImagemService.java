package br.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.ifba.frontend.model.ImagemModel;
import reactor.core.publisher.Mono;


@Service
public class ImagemService {
	@Autowired
	private WebClient webClient;
	
	public ImagemModel getImagem(Integer id) {
		
		Mono<ImagemModel> objModel = this.webClient
											.method(HttpMethod.GET)
											.uri("status/{id}", id)
											.retrieve()
											.bodyToMono(ImagemModel.class);
		
		ImagemModel sm = objModel.block();
		return sm;
	}
	
	public List<ImagemModel> getListImagem() {
		
		Mono<ImagemModel[]> objModel = this.webClient
											.method(HttpMethod.GET)
											.uri("status/listall")
											.retrieve()
											.bodyToMono(ImagemModel[].class);
		
		List<ImagemModel> list = new ArrayList<ImagemModel>();
		ImagemModel[] sm = objModel.block();
		
		for (ImagemModel status : sm) {
			list.add(status);
		}
		
		return list;
	}
	
	public Boolean deleteTarefa(Integer id) {
		Mono<Boolean> objDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("status/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = objDel.block();
		return result;
	}
	
	public Boolean insert(ImagemModel imagemModel) {
		System.out.println(getClass() + "insert: " + imagemModel);
		Mono<Boolean> status = this.webClient
									.method(HttpMethod.POST)
									.uri("status/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(imagemModel), ImagemModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = status.block();
		return result;
	}
	
	public ImagemModel update(ImagemModel imagemModel) {
		System.out.println("update: " + imagemModel);
		Mono<ImagemModel> status = this.webClient
									.method(HttpMethod.PUT)
									.uri("status/{id}", imagemModel.getId_Imagem())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(imagemModel), ImagemModel.class)
									.retrieve()
									.bodyToMono(ImagemModel.class);
		ImagemModel result = status.block();
		return result;
	}
	
	
	
}
