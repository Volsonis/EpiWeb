package epiweb.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import epiweb.client.model.StaticEpiQuery;

/* 
 * For tidyness sake.
 * Specifies all the methods that the client actually wants to invoke
 * Usually most/all from Service/Async
 */

public interface EpiDBAccessServiceClientInt
{
  void getCovariateByID(String id); // here we want the async method so we can invoke an async rpc
  void getEffectSizeByPMID(String id);
  void getExposureByPMID(String id);
  void getOutcomeByPMID(String id);
  void getPopulationByPMID(String id);
  void getStudyDesignByPMID(String id);
  
  void runStaticQuery(StaticEpiQuery query);
}
