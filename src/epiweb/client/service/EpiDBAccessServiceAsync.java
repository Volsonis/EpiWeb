package epiweb.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import epiweb.client.model.StaticEpiQuery;

/* This interface is in synch with the standard access interface
 * 
 * It also provides a so called "async number", 
 * which is used by GWT to respond to a request asynchronously 
 * and route it to the right entry point
 */

public interface EpiDBAccessServiceAsync
{
  void getCovariateByPMID(String id, AsyncCallback callback); //for async rpc callback
  void getEffectSizeByPMID(String id, AsyncCallback callback);
  void getExposureByPMID(String id, AsyncCallback callback);
  void getOutcomeByPMID(String id, AsyncCallback callback);
  void getPopulationByPMID(String id, AsyncCallback callback);
  void getStudyDesignByPMID(String id, AsyncCallback callback);
  
  void runStaticQuery(StaticEpiQuery query, AsyncCallback callback);
}
