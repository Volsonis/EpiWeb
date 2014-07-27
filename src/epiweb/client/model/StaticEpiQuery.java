package epiweb.client.model;

import java.io.Serializable;

/*
 * This package holds the custom Data models passed via RPC between the client and the server
 * 
 * This class holds the information for the data fields to be queried, which is assembled on the server
 */

public class StaticEpiQuery implements Serializable
{
  private String covariate;
  private String effect_size;
  private String exposure;
  private String outcome;
  private String population;
  private String study_design;

  public StaticEpiQuery() 
  {
    super();
    
    //lazy initialisation: initialise all empty
    this.covariate = "";
    this.effect_size = "";
    this.exposure = "";
    this.outcome = "";
    this.population = "";
    this.study_design = "";
    
  }

  public StaticEpiQuery(String covariate, String effect_size, String exposure, String outcome, String population, String study_design)
  {
    this.covariate = covariate;
    this.effect_size = effect_size;
    this.exposure = exposure;
    this.outcome = outcome;
    this.population = population;
    this.study_design = study_design;
  }

  public String getCovariate()
  {
    return covariate;
  }

  public void setCovariate(String covariate)
  {
    this.covariate = covariate;
  }

  public String getEffect_size()
  {
    return effect_size;
  }

  public void setEffect_size(String effect_size)
  {
    this.effect_size = effect_size;
  }

  public String getExposure()
  {
    return exposure;
  }

  public void setExposure(String exposure)
  {
    this.exposure = exposure;
  }

  public String getOutcome()
  {
    return outcome;
  }

  public void setOutcome(String outcome)
  {
    this.outcome = outcome;
  }

  public String getPopulation()
  {
    return population;
  }

  public void setPopulation(String population)
  {
    this.population = population;
  }

  public String getStudy_design()
  {
    return study_design;
  }

  public void setStudy_design(String study_design)
  {
    this.study_design = study_design;
  }
  
  
  
}
