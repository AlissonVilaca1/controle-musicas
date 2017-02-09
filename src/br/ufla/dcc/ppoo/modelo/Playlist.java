package br.ufla.dcc.ppoo.modelo;

import java.util.ArrayList;
import java.util.List;

/** Representa uma playlist no sistema
 *
 * @author alisson-vilaca
 */
public class Playlist {
    //nome da playlist
    private String nome;
    //usuario da playlist
    private Usuario usuario;
    //lista de palavras chaves da play list
    private List<String> listaPalavras;
    //lista de musicas da playlist
    private List<Musica> listaMusicas;
    // visibilidade da paylist
   private boolean visilidade;
    
    public Playlist(String nome, Usuario usuario,  List<String> listaPalavras, List<Musica> listaMusicas, boolean visilidade){
        this.usuario = usuario;
        this.nome = nome;
        this.listaPalavras = listaPalavras; 
        this.listaMusicas = listaMusicas;
        this.visilidade = visilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisilidade() {
        return visilidade;
    }

    public void setVisilidade(boolean visilidade) {
        this.visilidade = visilidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setListaMusicas(List<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public List<String> getPalavras() {
        return listaPalavras;
    }
    
    public List<Musica> getMusicas() {
        return listaMusicas;
    }

    public void setListaPalavras(List<String> listaPalavras) {
        this.listaPalavras = listaPalavras;
    }
    
    /**
     * Apaga musica de uma playlist
     * @param m 
     */
    public void apagarMusica(Musica m){
        for (Musica u : listaMusicas){            
            if (u == m){
                listaMusicas.remove(u);
            }
        }
    
    }
    
    /**
     * Compara duas playlists
     * @param u
     * @return 
     */
    public boolean comparaPlaylist (Playlist u){
        if ((nome.equals(u.getNome()))      // este if deveria estar na classe musica, nã cabe ao if fazer
                             && (usuario == u.getUsuario())//essa cmparação
                    ) {
            return true;
        } else {            
            return false;
        }   
        
    }
    
}