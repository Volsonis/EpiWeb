package epiweb.client.model;

import java.io.Serializable;

/*
 * This package holds the custom Data models passed via RPC between the client and the server
 * 
 * This class holds the information from the results of a query exctacted into primitive datatypes,
 * which can be passed via RPC and assembled on client side.
 */

public class StaticEpiQueryResult implements Serializable
{
  
  private String pmid;
  private String year;
  private String title;
  
  public StaticEpiQueryResult()
  {
    this.pmid = "";
    this.year = "";
    this.title = "";
  }
  
  public StaticEpiQueryResult(String pmid, String year, String title) {
    super();
    this.pmid = pmid;
    this.year = year;
    this.title = title;
  }

  public String getPmid()
  {
    return pmid;
  }

  public void setPmid(String pmid)
  {
    this.pmid = pmid;
  }

  public String getYear()
  {
    return year;
  }

  public void setYear(String year)
  {
    this.year = year;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }
  
  
  
}
