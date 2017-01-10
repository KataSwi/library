package pl.polsl.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Entity
@Table(name = "genre", schema = "public", catalog = "library")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreid", nullable = false)
    private int genreid;

    @Basic
    @Column(name = "type", length = 30)
    private String type;

    @Basic
    @Column(name = "biografia")
    private double biografia;

    @Basic
    @Column(name = "dzieci")
    private double dzieci;

    @Basic
    @Column(name = "mlodziez")
    private double mlodziez;

    @Basic
    @Column(name = "encyklopedia")
    private double encyklopedia;

    @Basic
    @Column(name = "fantastyka")
    private double fantastyka;

    @Basic
    @Column(name = "filozofia")
    private double filozofia;

    @Basic
    @Column(name = "historia")
    private double historia;

    @Basic
    @Column(name = "poezja")
    private double poezja;

    @Basic
    @Column(name = "lpiekna")
    private double lpiekna;

    @Basic
    @Column(name = "lfaktu")
    private double lfaktu;

    @Basic
    @Column(name = "obyczajowa")
    private double obyczajowa;

    @Basic
    @Column(name = "romans")
    private double romans;

    @Basic
    @Column(name = "sensacja")
    private double sensacja;

    @Basic
    @Column(name = "kryminal")
    private double kryminal;

    @Basic
    @Column(name = "thriller")
    private double thriller;

    @Basic
    @Column(name = "horror")
    private double horror;

    @OneToMany(mappedBy = "bookByGenre", cascade = CascadeType.ALL)
    private Collection<BookEntity> bookByGenre;


    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<BookEntity> getBookByGenre() {
        return bookByGenre;
    }

    public void setBookByGenre(Collection<BookEntity> bookByGenre) {
        this.bookByGenre = bookByGenre;
    }

    public double getBiografia() {
        return biografia;
    }

    public void setBiografia(double biografia) {
        this.biografia = biografia;
    }

    public double getDzieci() {
        return dzieci;
    }

    public void setDzieci(double dzieci) {
        this.dzieci = dzieci;
    }

    public double getMlodziez() {
        return mlodziez;
    }

    public void setMlodziez(double mlodziez) {
        this.mlodziez = mlodziez;
    }

    public double getEncyklopedia() {
        return encyklopedia;
    }

    public void setEncyklopedia(double encyklopedia) {
        this.encyklopedia = encyklopedia;
    }

    public double getFantastyka() {
        return fantastyka;
    }

    public void setFantastyka(double fantastyka) {
        this.fantastyka = fantastyka;
    }

    public double getFilozofia() {
        return filozofia;
    }

    public void setFilozofia(double filozofia) {
        this.filozofia = filozofia;
    }

    public double getHistoria() {
        return historia;
    }

    public void setHistoria(double historia) {
        this.historia = historia;
    }

    public double getPoezja() {
        return poezja;
    }

    public void setPoezja(double poezja) {
        this.poezja = poezja;
    }

    public double getLpiekna() {
        return lpiekna;
    }

    public void setLpiekna(double lpiekna) {
        this.lpiekna = lpiekna;
    }

    public double getLfaktu() {
        return lfaktu;
    }

    public void setLfaktu(double lfaktu) {
        this.lfaktu = lfaktu;
    }

    public double getObyczajowa() {
        return obyczajowa;
    }

    public void setObyczajowa(double obyczajowa) {
        this.obyczajowa = obyczajowa;
    }

    public double getRomans() {
        return romans;
    }

    public void setRomans(double romans) {
        this.romans = romans;
    }

    public double getSensacja() {
        return sensacja;
    }

    public void setSensacja(double sensacja) {
        this.sensacja = sensacja;
    }

    public double getKryminal() {
        return kryminal;
    }

    public void setKryminal(double kryminal) {
        this.kryminal = kryminal;
    }

    public double getThriller() {
        return thriller;
    }

    public void setThriller(double thriller) {
        this.thriller = thriller;
    }

    public double getHorror() {
        return horror;
    }

    public void setHorror(double horror) {
        this.horror = horror;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (genreid != that.genreid) return false;
        if (Double.compare(that.biografia, biografia) != 0) return false;
        if (Double.compare(that.dzieci, dzieci) != 0) return false;
        if (Double.compare(that.mlodziez, mlodziez) != 0) return false;
        if (Double.compare(that.encyklopedia, encyklopedia) != 0) return false;
        if (Double.compare(that.fantastyka, fantastyka) != 0) return false;
        if (Double.compare(that.filozofia, filozofia) != 0) return false;
        if (Double.compare(that.historia, historia) != 0) return false;
        if (Double.compare(that.poezja, poezja) != 0) return false;
        if (Double.compare(that.lpiekna, lpiekna) != 0) return false;
        if (Double.compare(that.lfaktu, lfaktu) != 0) return false;
        if (Double.compare(that.obyczajowa, obyczajowa) != 0) return false;
        if (Double.compare(that.romans, romans) != 0) return false;
        if (Double.compare(that.sensacja, sensacja) != 0) return false;
        if (Double.compare(that.kryminal, kryminal) != 0) return false;
        if (Double.compare(that.thriller, thriller) != 0) return false;
        if (Double.compare(that.horror, horror) != 0) return false;
        return type.equals(that.type);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = genreid;
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(biografia);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dzieci);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mlodziez);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(encyklopedia);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fantastyka);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(filozofia);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(historia);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(poezja);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lpiekna);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lfaktu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(obyczajowa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(romans);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sensacja);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(kryminal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(thriller);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(horror);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
