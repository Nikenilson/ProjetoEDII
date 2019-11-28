package br.unicamp.cotuca.pathbetweencities.cidade;

public class Cidade{
    private int idCidade, coordenadaX, coordenadaY;
    private String nomeCidade;

    protected final int tamanhoId = 3;
    protected final int inicioNomeCidade = 3;
    protected final int tamanhoNomeCidade = 15;
    protected final int inicioX = inicioNomeCidade + tamanhoNomeCidade;
    protected final int tamanhoCoord = 5;
    protected final int inicioY = inicioX + tamanhoCoord;

    public Cidade(int id, int x, int y, String nome)
    {
        this.setIdCidade(id);
        this.setCoordenadaX(x);
        this.setCoordenadaY(y);
        this.setNomeCidade(nome);
    }

    public Cidade (String linha)
    {
        setIdCidade(Integer.parseInt(linha.substring(0, tamanhoId)));
        setNomeCidade(linha.substring(inicioNomeCidade, tamanhoNomeCidade));
        setCoordenadaX( Integer.parseInt(linha.substring(inicioX, tamanhoCoord)));
        setCoordenadaY(Integer.parseInt(linha.substring(inicioY)));
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}
