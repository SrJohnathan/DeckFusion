package br.com.deckfudion.johnathan.card;

import com.badlogic.gdx.utils.Disposable;

import java.io.Serializable;

import br.com.deckfudion.johnathan.utill.Utiil;

public class Cards implements Serializable , Disposable {


    private Long id;

    private int type;

    private String name;

    private int colorname;

    private String cardcolor;

    private int atk;

    private int def;

    private int attr;

    private int star;

    private String description;

    private int effect;

    private int guardian1;
    private int guardian2;

    private int idd;

    public Cards() {
    }

    public Cards(Long id) {
        this.id = id;
    }

    public Cards(Long id, int type, String name, int colorname, String cardcolor, int atk, int def, int attr, int star, String description, int effect, int guardian1, int guardian2, int idd) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.colorname = colorname;
        this.cardcolor = cardcolor;
        this.atk = atk;
        this.def = def;
        this.attr = attr;
        this.star = star;
        this.description = description;
        this.effect = effect;
        this.guardian1 = guardian1;
        this.guardian2 = guardian2;
        this.idd = idd;
    }

    public Long getId() {
        return id;
    }

    public String filter(boolean id, boolean at, boolean df) {

        String v1 = ((id ? idd : "") + "" + name + "" + (at ? atk : "") + "" + (df ? def : "")).toLowerCase();

        return v1;
    }

    public String filterNumber(boolean id, boolean at, boolean df) {

        String v1 = ((id ? idd : "") + "" + (at ? atk : "") + "" + (df ? def : "")).toLowerCase();

        return v1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorname() {
        return colorname;
    }

    public void setColorname(int colorname) {
        this.colorname = colorname;
    }

    public String getCardcolor() {
        return cardcolor;
    }

    public void setCardcolor(String cardcolor) {
        this.cardcolor = cardcolor;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public int getGuardian1() {
        return guardian1;
    }

    public void setGuardian1(int guardian1) {
        this.guardian1 = guardian1;
    }

    public int getGuardian2() {
        return guardian2;
    }

    public void setGuardian2(int guardian2) {
        this.guardian2 = guardian2;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public void encrypto() {

        this.name = Utiil.encryptDecrypt(name);
        this.cardcolor = Utiil.encryptDecrypt(cardcolor);
        this.description = Utiil.encryptDecrypt(description);

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cards)) {
            return false;
        }
        Cards other = (Cards) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libs.Newcards[ id=" + id + "  ]";
    }

    @Override
    public void dispose() {

    }
}