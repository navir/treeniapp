package treeniapp.treeniapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Treeni {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String kesto;
  private String pvm;

  @ManyToOne
  @JoinColumn(name = "tyyppiid")
  private Treenityyppi treenityyppi;

  public Treeni() {
  }

  public Treeni(Treenityyppi treenityyppi, String kesto, String pvm) {
    this.treenityyppi = treenityyppi;
    this.pvm = pvm;
    this.kesto = kesto;
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

  public Treenityyppi getTreenityyppi() {
    return treenityyppi;
  }

  public void setTreenityyppi(Treenityyppi treenityyppi) {
    this.treenityyppi = treenityyppi;
  }

  @Override
  public String toString() {
    if (this.treenityyppi != null)
      return "Treeni [id=" + id + ", kesto=" + kesto + ", pvm=" + pvm + ", treenityyppi=" + this.getTreenityyppi() + "]";
    else
      return "Treeni [id=" + id + ", kesto=" + kesto + ", pvm=" + pvm + "]";
  }

  

}