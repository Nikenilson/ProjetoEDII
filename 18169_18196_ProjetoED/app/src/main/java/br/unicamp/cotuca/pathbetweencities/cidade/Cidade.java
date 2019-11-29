package br.unicamp.cotuca.pathbetweencities.cidade;

public class Cidade{
    private int idCidade;
    private float coordenadaX, coordenadaY;
    private String nomeCidade;

    protected final int tamanhoId = 2;
    protected final int inicioNomeCidade = 2;
    protected final int tamanhoNomeCidade = 16;
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
        setNomeCidade(linha.substring(inicioNomeCidade, inicioNomeCidade+tamanhoNomeCidade));
        setCoordenadaX(Float.parseFloat(linha.substring(inicioX, inicioX+tamanhoCoord)));
        setCoordenadaY(Float.parseFloat(linha.substring(inicioY)));
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}
