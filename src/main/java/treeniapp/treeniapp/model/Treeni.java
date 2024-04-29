package treeniapp.treeniapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Treeni {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String kesto;
  private String pvm;
  private String kuvaus;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "tyyppid")
  private Treenityyppi treenityyppi;

  public Treeni() {
  }

  

  public Treeni(String kesto, String pvm, String kuvaus, LocalDate date, Treenityyppi treenityyppi) {
    this.kesto = kesto;
    this.pvm = pvm;
    this.kuvaus = kuvaus;
    this.date = date;
    this.treenityyppi = treenityyppi;
  }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getKesto() {
    return kesto;
  }

  public void setKesto(String kesto) {
    this.kesto = kesto;
  }

  public String getPvm() {
    return pvm;
  }

  public void setPvm(String pvm) {
    this.pvm = pvm;
  }

  public String getKuvaus() {
    return kuvaus;
  }

  public void setKuvaus(String kuvaus) {
    this.kuvaus = kuvaus;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Treenityyppi getTreenityyppi() {
    return treenityyppi;
  }

  public void setTreenityyppi(Treenityyppi treenityyppi) {
    this.treenityyppi = treenityyppi;
  }

  @Override
  public String toString() {
    if (this.treenityyppi != null)
      return "Treeni [id=" + id + ", kesto=" + kesto + ", pvm=" + pvm + ", treenityyppi=" + this.getTreenityyppi()
          + "]";
    else
      return "Treeni [id=" + id + ", kesto=" + kesto + ", pvm=" + pvm + "]";
  }

}