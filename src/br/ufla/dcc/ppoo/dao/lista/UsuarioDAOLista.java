package br.ufla.dcc.ppoo.dao.lista;

import br.ufla.dcc.ppoo.dao.UsuarioDAO;
import br.ufla.dcc.ppoo.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do Data Access Object (Padrão de Projeto) do Usuário através de
 * Lista em memória
 * 
 * @author Paulo Jr. e Julio Alves
 */
public class UsuarioDAOLista implements UsuarioDAO {

    // instância única da classe (Padrão de Projeto Singleton)
    private static UsuarioDAOLista instancia;
    
    // lista em em memória dos usuários cadastrados
    private final List<Usuario> listaUsuario;
    
    //Usuario que será exibido
    private Usuario exibido;

    /**
     * Constrói o objeto já definindo 5 usuários padrões
     */
    private UsuarioDAOLista() {
        listaUsuario = new ArrayList<Usuario>();

        // Cadastrei alguns usuários para testar o programa.
        char[] senha = new char[]{'1', '2', '3'};
        listaUsuario.add(new Usuario("paulo", senha, "Paulo"));
        listaUsuario.add(new Usuario("jose", senha, "José"));
        listaUsuario.add(new Usuario("flavia", senha, "Flávia"));
        listaUsuario.add(new Usuario("matheus", senha, "Matheus"));
        listaUsuario.add(new Usuario("alexandre", senha, "Alexandre"));
        exibido = new Usuario();

    }

    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static UsuarioDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAOLista();
        }
        return instancia;
    }

    /**
     * Retorna o usuário a partir de seu login
     * 
     * @param login Login do usuário a ser retornado.
     * @return Usuário correspondente ao login passado.
     */
    @Override
    public Usuario obterUsuarioPeloLogin(String login) {
        for (Usuario u : listaUsuario) {
            if (login.equals(u.obterLogin())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Cadastra o usuário passado.
     * 
     * @param usuario Usuário a ser cadastrado.
     */
    @Override
    public void adicionarUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
    }
    
    /**
     * Retorna lista de usuarios que tem nome igual às palavras da lista
     * @param palavra lista de palavras
     * @return 
     */
    public List<Usuario> buscaUsuarios(List<String> palavra){
       List<Usuario> lista = new ArrayList<Usuario>();
        for ( String s : palavra){
            for (Usuario p : listaUsuario) {  
                if(p.obterNome().equals(s)){
                    if (!lista.contains(p)){
                        lista.add(p);
                    }                    
                }
            }                                    
        }
        return lista;
    }
    
    /**
     * Seta o Usuario que o Usuario selecionou para ser exibido
     */
    public void setarExibido(Usuario usuario){
        exibido.setLogin(usuario.obterLogin());
        exibido.setNome(usuario.obterNome());
        exibido.setSenha(usuario.obterSenha());
        exibido.setPontuacao(usuario.getPontuacao());
    
    }
    
    /**
     * Retorna o Usuario que o Usuario selecionou para ser exibido
     */
    public String getUsuarioExibido(){        
        return "Nome do usuario: " + exibido.obterNome() + "\nPontuação: " + exibido.getPontuacao()
                + "\nEmail (login): " + exibido.obterLogin();
    }
    
    /**
     * Retorna o Usuario que o Usuario selecionou para ser exibido
     */
    public Usuario getExibido(){        
        return exibido;
    }
    
    /**
     * Soma a ultima avaliação à avaliação geral do usuario
     * @param u usuario
     * @param pont valor a ser somado
     */
    public void somarAvaliacao(Usuario u, int pont){
        for(Usuario p : listaUsuario){
            if (p.obterNome().equals(u.obterNome())){                
                p.setPontuacao(pont+p.getPontuacao());
            }
        }
        
    }
}
