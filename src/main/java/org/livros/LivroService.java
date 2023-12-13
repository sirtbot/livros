package org.livros;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class LivroService {

    public static void main(String[] args) {
        // Publicar o serviço web
        String endereco = "http://localhost:8080/LivroService";
        Endpoint.publish(endereco, new LivroService());

        // Simulando a chamada do cliente ao próprio serviço
        LivroService service = new LivroService();
        String resultado = service.obterInformacoesLivro("Aventuras do NetBeans");
        System.out.println("Informações do Livro: " + resultado);
    }

    @WebMethod
    public String obterInformacoesLivro(String titulo) {
        if (titulo.equals("Aventuras do NetBeans")) {
            return "Autor: Java Developer\nAno: 2023";
        } else {
            return "Livro não encontrado.";
        }
    }
}
