package treeniapp.treeniapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Treenityyppi {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long tyyppid;
  private String name;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "treenityyppi")
  private List<Treeni> treenit;

  public Treenityyppi() {
  }

  public Treenityyppi(String name) {
    this.name = name;
  }

  public Treenityyppi(Long tyyppid, String name, List<Treeni> treenit) {
    this.tyyppid = tyyppid;
    this.name = name;
    this.treenit = treenit;
  }

  public Long getTyyppid() {
    return tyyppid;
  }

  public void setTyyppid(Long tyyppid) {
    this.tyyppid = tyyppid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Treeni> getTreenit() {
    return treenit;
  }

  public void setTreenit(List<Treeni> treenit) {
    this.treenit = treenit;
  }

  
}