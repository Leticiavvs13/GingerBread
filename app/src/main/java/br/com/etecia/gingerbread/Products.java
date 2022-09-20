package br.com.etecia.gingerbread;

public class Products {
    String nomeCafe;
    int imagemCafe;
    String descricaoCafe;
    int ratingCafe;
    int favorite;

    public Products() {
    }

    public Products(String nomeCafe, int imagemCafe, String descricaoCafe, int ratingCafe, int favorite) {
        this.nomeCafe = nomeCafe;
        this.imagemCafe = imagemCafe;
        this.descricaoCafe = descricaoCafe;
        this.ratingCafe = ratingCafe;
        this.favorite = favorite;
    }

    public String getNomeCafe() {
        return nomeCafe;
    }

    public void setNomeCafe(String nomeCafe) {
        this.nomeCafe = nomeCafe;
    }

    public int getImagemCafe() {
        return imagemCafe;
    }

    public void setImagemCafe(int imagemCafe) {
        this.imagemCafe = imagemCafe;
    }

    public String getDescricaoCafe() {
        return descricaoCafe;
    }

    public void setDescricaoCafe(String descricaoCafe) {
        this.descricaoCafe = descricaoCafe;
    }

    public int getRatingCafe() {
        return ratingCafe;
    }

    public void setRatingCafe(int ratingCafe) {
        this.ratingCafe = ratingCafe;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

}
